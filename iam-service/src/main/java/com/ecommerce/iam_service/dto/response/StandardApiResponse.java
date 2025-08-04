package com.ecommerce.iam_service.dto.response;

import lombok.Builder;
import lombok.NonNull;

import java.time.LocalDateTime;

@Builder
public record StandardApiResponse<T> (

        @NonNull Integer status,
        @NonNull String message,
        @NonNull LocalDateTime timeStamp,
        @NonNull T data

        ){}
