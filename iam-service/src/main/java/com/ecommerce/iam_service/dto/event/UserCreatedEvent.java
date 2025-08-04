package com.ecommerce.iam_service.dto.event;

import lombok.Builder;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record UserCreatedEvent (
        @NonNull UUID userId,
        @NonNull String email,
        @NonNull LocalDateTime createdAt
){}
