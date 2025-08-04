package com.ecommerce.iam_service.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record StandardApiErrorResponse(
        @NonNull String errorCode,
        @NonNull String message,
        @NonNull Integer status,
        @NonNull String path,
        @NonNull @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime timestamp,
        List<FieldValidationErrorDto> errors
) {}
