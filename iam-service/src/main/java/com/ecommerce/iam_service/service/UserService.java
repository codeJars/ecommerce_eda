package com.ecommerce.iam_service.service;

import com.ecommerce.iam_service.dto.request.RegisterUserRequest;
import com.ecommerce.iam_service.dto.response.RegisterUserResponse;
import com.ecommerce.iam_service.entity.User;
import reactor.core.publisher.Mono;


public interface UserService {
    Mono<RegisterUserResponse> registerUser(RegisterUserRequest request);

}
