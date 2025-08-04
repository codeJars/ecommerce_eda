package com.ecommerce.iam_service.service.impl;

import com.ecommerce.iam_service.constant.ErrorCode;
import com.ecommerce.iam_service.constant.Event;
import com.ecommerce.iam_service.dto.event.UserCreatedEvent;
import com.ecommerce.iam_service.entity.Outbox;
import com.ecommerce.iam_service.entity.User;
import com.ecommerce.iam_service.exception.*;
import com.ecommerce.iam_service.repository.OutBoxRepository;
import com.ecommerce.iam_service.repository.UserRepository;
import com.ecommerce.iam_service.service.UserServiceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.reactive.TransactionalOperator;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceFactoryImpl implements UserServiceFactory {

    private final UserRepository userRepository;
    private final OutBoxRepository outBoxRepository;
    private final PasswordEncoder passwordEncoder;
    private final TransactionalOperator transactionalOperator;
    private final ObjectMapper objectMapper;

    @Override
    public Mono<User> validateCredentials(String username, String password) {
        return getUser(username)
                .switchIfEmpty(
                        Mono.defer( () -> Mono.error(new UserNotFoundException(ErrorCode.INVALID_CREDENTIALS)))
                )
                .flatMap( user -> {

                    if (user.getPasswordHash()==null || !passwordEncoder.matches(password, user.getPasswordHash())) {
                        return Mono.error(new InvalidCredentialsException(
                                Map.of("message", "Invalid password attempt for user: " + user.getUserId())
                        ));
                    }

                    return Mono.just(user);
                });
    }

    @Override
    public Mono<User> getUser(String username) {
        return userRepository.findByEmail(username)
                .onErrorMap(e -> new DatabaseReadUserException(e, Map.of("user", username)));
    }
    @Override
    public Mono<User> saveUser(User user){
        return userRepository.save(user)
                .as(transactionalOperator::transactional)
                .onErrorMap(e -> new DatabaseWriteUserException(e, Map.of("user", user.getEmail())));
    }

    @Override
    public User createUserEntityObject(String username, String password) {
        try {
            return User.getUserWithDefaults().toBuilder()
                    .email(username)
                    .passwordHash(passwordEncoder.encode(password))
                    .build();
        }catch (Exception e){
            throw new DataMappingException(e, Map.of("message", "Error mapping register user request to user entity for username: " + username));
        }
    }

    @Override
    public Mono<User> saveUserAndEvent(String username, String password){

        User user = createUserEntityObject(username, password);

        return userRepository.save(user)
                .flatMap(savedUser ->  {
                    Outbox outbox = createOutboxEvent(savedUser);
                    return outBoxRepository.save(outbox).thenReturn(savedUser);
                })
                .onErrorMap(e -> new DatabaseWriteUserException(e, Map.of("user", user.getEmail())))
                .as(transactionalOperator::transactional);
    }

    private Outbox createOutboxEvent(User user) {

        UserCreatedEvent event = createUserCreatedEvent(user);
        String payload = serializeEvent(event);

        try{
            return Outbox.getOutboxWithDefaults().toBuilder()
                    .aggregateType(Event.USER_CREATED.getAggregateType())
                    .aggregateId(user.getUserId().toString())
                    .eventType(Event.USER_CREATED.getEventType())
                    .payload(payload)
                    .status(Event.Status.PENDING.getStatus())
                    .createdAt(user.getCreatedAt())
                    .build();
        }catch (Exception e){
            throw new DataMappingException(e, Map.of("message", "Error mapping event to Outbox for user: " + user.getUserId()));
        }

    }

    private UserCreatedEvent createUserCreatedEvent(User user){
        try {
            return UserCreatedEvent.builder()
                    .userId(user.getUserId())
                    .email(user.getEmail())
                    .createdAt(user.getCreatedAt())
                    .build();
        }catch (Exception e) {
            throw new DataMappingException(e, Map.of("message", "Error mapping user to UserCreatedEvent for user: " + user.getUserId()));
        }
    }

    private String serializeEvent(UserCreatedEvent event) {
        try {
            return objectMapper.writeValueAsString(event);
        } catch (Exception e) {
            throw new EventSerializationException(e, Map.of("user", event.userId()));
        }
    }

}

