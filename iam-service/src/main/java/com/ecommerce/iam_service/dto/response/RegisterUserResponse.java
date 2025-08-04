package com.ecommerce.iam_service.dto.response;

import com.ecommerce.iam_service.constant.Authority;
import lombok.Builder;
import lombok.NonNull;

import java.util.List;

@Builder
public record RegisterUserResponse(
    @NonNull String accessToken,
    @NonNull String refreshToken,
    @NonNull Long expiresIn,
    @NonNull Long refreshExpiresIn,
    @NonNull String tokenType,
    @NonNull UserInfo user

){
    @Builder
    public record UserInfo(
        @NonNull String userId,
        @NonNull String username,
        @NonNull List<Authority> roles
    ){}

}
