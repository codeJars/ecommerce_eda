package com.ecommerce.iam_service.service.impl;

import com.ecommerce.iam_service.dto.request.RegisterUserRequest;
import com.ecommerce.iam_service.dto.response.RegisterUserResponse;
import com.ecommerce.iam_service.exception.*;
import com.ecommerce.iam_service.entity.User;
import com.ecommerce.iam_service.service.UserServiceFactory;
import com.ecommerce.iam_service.service.JwtTokenFactory;
import com.ecommerce.iam_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

import static com.ecommerce.iam_service.constant.SecurityConstant.*;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserServiceFactory userServiceFactory;
    private final JwtTokenFactory jwtTokenFactory;

    @Override
    public Mono<RegisterUserResponse> registerUser(RegisterUserRequest request) {

        return userServiceFactory.getUser(request.username())
                .flatMap(existingUser ->
                        Mono.error(new UserAlreadyExistException(Map.of("user", existingUser.getUserId())))
                )
                .then(userServiceFactory.saveUserAndEvent(request.username(), request.password()))
                .map(savedUser -> {
                    String accessToken = jwtTokenFactory.generateAccessToken(savedUser);
                    String refreshToken = jwtTokenFactory.generateRefreshToken(savedUser);
                    return  buildRegisterUserResponse(savedUser, accessToken, refreshToken);
                });
    }

    private RegisterUserResponse buildRegisterUserResponse(User user, String accessToken, String refreshToken) {
        try {
            RegisterUserResponse.UserInfo userInfo = RegisterUserResponse.UserInfo.builder()
                    .userId(user.getUserId().toString())
                    .username(user.getEmail())
                    .roles(user.getRoles())
                    .build();

            return RegisterUserResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .expiresIn(ACCESS_TOKEN_VALIDITY_SECONDS)
                    .refreshExpiresIn(REFRESH_TOKEN_VALIDITY_SECONDS)
                    .tokenType(TOKEN_TYPE)
                    .user(userInfo)
                    .build();

        }catch (Exception e) {
            throw new DataMappingException(e, Map.of("message", "Error building user registration response for user: " + user.getUserId()));
        }
    }

}










//      <dependency>
//			<groupId>org.springframework.kafka</groupId>
//			<artifactId>spring-kafka</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>org.apache.kafka</groupId>
//			<artifactId>kafka-clients</artifactId>
//		</dependency>
//
//		<dependency>
//			<groupId>org.springframework.kafka</groupId>
//			<artifactId>spring-kafka-test</artifactId>
//			<scope>test</scope>
//		</dependency>

// @Value("${spring.kafka.topics.user-created}")
//private String userCreatedTopic;


//    private void sendUserCreatedEvent(User user) {
//
//        UserCreatedEvent userEvent;
//
//        try {
//            userEvent = UserCreatedEvent.builder()
//                    .userId(user.getUserId())
//                    .email(user.getEmail())
//                    .createdAt(user.getCreatedAt())
//                    .build();
//        }catch (Exception e){
//            throw new DataMappingException(e, Map.of("message", "Error mapping user to UserCreatedEvent for user: " + user.getUserId()));
//        }
//
//        kafkaTemplate.send(userCreatedTopic, userEvent)
//            .whenComplete((result, e) -> {
//                if (e == null) {
//                    log.info("Sent message=[{}] to topic-partition={}", userEvent, result.getRecordMetadata());
//                } else {
//                    throw new EventPublishingException(e, Map.of(
//                            "Topic", userCreatedTopic,
//                            "event", "user-created",
//                            "user", user.getUserId()
//                    ));
//                }
//            });
//    }

