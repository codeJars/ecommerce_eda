package com.ecommerce.iam_service.dto.response;

import lombok.NonNull;

public record FieldValidationErrorDto(
   @NonNull String field,
   @NonNull String message
) {}
