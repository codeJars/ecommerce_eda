package com.ecommerce.iam_service.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Event {

    USER_CREATED("UserCreatedEvent", "User");

    private final String eventType;
    private final String aggregateType;

    @RequiredArgsConstructor
    @Getter
    public static enum Status {
        PENDING("Pending");
        private final String status;
    }
}
