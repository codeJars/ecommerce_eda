package com.ecommerce.iam_service.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RefreshTokenRequest(
   @NotBlank String refreshToken
) {}
