package com.ecommerce.iam_service.constant;

import org.springframework.beans.factory.annotation.Value;

import javax.crypto.spec.SecretKeySpec;

public final class SecurityConstant {
    private SecurityConstant(){};

    public static final String TOKEN_TYPE = "Bearer";
    public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 1800L; //30mins
    public static final long REFRESH_TOKEN_VALIDITY_SECONDS = 604800L; //7days
    public static final String TOKEN_ISSUER = "ecommerce-iam-service";
    public static final int PASSWORD_ENCODER_STRENGTH = 12;
    public static final String REFRESH_SCOPE = "refresh";



    public static final String[] PUBLIC_PATHS = {
            "/actuator/**",
            "/auth/login",
            "/auth/refresh",
            "/auth/register",
            "/.well-known/jwks.json",
    };
}
