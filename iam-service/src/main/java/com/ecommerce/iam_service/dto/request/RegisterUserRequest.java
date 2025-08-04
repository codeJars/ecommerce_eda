package com.ecommerce.iam_service.dto.request;

import jakarta.validation.constraints.NotBlank;


public record RegisterUserRequest(
  @NotBlank String username,
  @NotBlank String password

){}
