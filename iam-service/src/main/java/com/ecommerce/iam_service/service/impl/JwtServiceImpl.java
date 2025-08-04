package com.ecommerce.iam_service.service.impl;

import com.ecommerce.iam_service.dto.request.LoginUserRequest;
import com.ecommerce.iam_service.dto.request.RefreshTokenRequest;
import com.ecommerce.iam_service.dto.response.LoginUserResponse;
import com.ecommerce.iam_service.dto.response.RefreshTokenResponse;
import com.ecommerce.iam_service.entity.User;
import com.ecommerce.iam_service.exception.DataMappingException;
import com.ecommerce.iam_service.exception.InvalidTokenException;
import com.ecommerce.iam_service.service.JwtService;
import com.ecommerce.iam_service.service.JwtTokenFactory;
import com.ecommerce.iam_service.service.UserService;
import com.ecommerce.iam_service.service.UserServiceFactory;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Map;

import static com.ecommerce.iam_service.constant.SecurityConstant.*;

@Service
@RequiredArgsConstructor
@Log4j2
public class JwtServiceImpl implements JwtService {

    private final UserServiceFactory userServiceFactory;
    private final JwtTokenFactory jwtTokenFactory;

    @Override
    public Mono<LoginUserResponse> loginUser(LoginUserRequest loginUserRequest) {
        return userServiceFactory.validateCredentials(loginUserRequest.username(), loginUserRequest.password())
                .map( user -> {
                    String accessToken = jwtTokenFactory.generateAccessToken(user);
                    String refreshToken = jwtTokenFactory.generateRefreshToken(user);
                    return buildLoginUserResponse(accessToken, refreshToken, user);
                });
    }

    @Override
    public Mono<RefreshTokenResponse> refreshToken(RefreshTokenRequest refreshTokenRequest) {

        String subject = jwtTokenFactory.parseAndVerifyRefreshToken(refreshTokenRequest.refreshToken());

        return userServiceFactory.getUser(subject)
            .map( user -> {
                String accessToken = jwtTokenFactory.generateAccessToken(user);
                String refreshToken = jwtTokenFactory.generateRefreshToken(user);
                return buildRefreshTokenResponse(accessToken, refreshToken, user);
            });
    }

    private LoginUserResponse buildLoginUserResponse(String accessToken, String refreshToken, User user) {
        try {

            LoginUserResponse.UserInfo userInfo = LoginUserResponse.UserInfo.builder()
                    .userId(user.getUserId().toString())
                    .username(user.getEmail())
                    .roles(user.getRoles())
                    .build();

            return LoginUserResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .expiresIn(ACCESS_TOKEN_VALIDITY_SECONDS)
                    .refreshExpiresIn(REFRESH_TOKEN_VALIDITY_SECONDS)
                    .tokenType(TOKEN_TYPE)
                    .user(userInfo)
                    .build();
        }catch (Exception e) {
            throw new DataMappingException(e, Map.of("message", "Error while building LoginUserResponse"));
        }
    }

    private RefreshTokenResponse buildRefreshTokenResponse(String accessToken, String refreshToken, User user) {
        try {
            RefreshTokenResponse.UserInfo userInfo = RefreshTokenResponse.UserInfo.builder()
                    .userId(user.getUserId().toString())
                    .username(user.getEmail())
                    .roles(user.getRoles())
                    .build();

            return RefreshTokenResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .expiresIn(ACCESS_TOKEN_VALIDITY_SECONDS)
                    .refreshExpiresIn(REFRESH_TOKEN_VALIDITY_SECONDS)
                    .tokenType(TOKEN_TYPE)
                    .user(userInfo)
                    .build();

        }catch (Exception e){
            throw new DataMappingException(e, Map.of("message","Error while building RefreshTokenResponse"));
        }
    }

}
