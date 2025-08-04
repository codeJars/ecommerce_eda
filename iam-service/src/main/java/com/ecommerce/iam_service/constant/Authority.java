package com.ecommerce.iam_service.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Authority {
    USER,
    ADMIN;

    public enum Scope {
        SCOPE_USER,
        SCOPE_ADMIN
    }
}
