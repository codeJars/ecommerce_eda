package com.ecommerce.iam_service.service;

import com.ecommerce.iam_service.entity.User;
import reactor.core.publisher.Mono;

public interface UserServiceFactory {
    Mono<User> validateCredentials(String username, String password);
    Mono<User> getUser(String email);
    Mono<User> saveUser(User user);
    User createUserEntityObject(String username, String password);
    Mono<User> saveUserAndEvent(String username, String password);
}
