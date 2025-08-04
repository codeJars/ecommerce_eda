package com.ecommerce.iam_service.service;

import com.ecommerce.iam_service.dto.request.LoginUserRequest;
import com.ecommerce.iam_service.dto.request.RefreshTokenRequest;
import com.ecommerce.iam_service.dto.response.LoginUserResponse;
import com.ecommerce.iam_service.dto.response.RefreshTokenResponse;
import reactor.core.publisher.Mono;


public interface JwtService {
    Mono<LoginUserResponse> loginUser(LoginUserRequest loginUserRequest);
    Mono<RefreshTokenResponse> refreshToken(RefreshTokenRequest refreshTokenRequest);

}
