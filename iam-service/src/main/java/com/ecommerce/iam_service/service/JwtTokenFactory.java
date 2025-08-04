package com.ecommerce.iam_service.service;

import com.ecommerce.iam_service.dto.response.LoginUserResponse;
import com.ecommerce.iam_service.dto.response.RefreshTokenResponse;
import com.ecommerce.iam_service.entity.User;
import io.jsonwebtoken.*;
import java.util.Map;

public interface JwtTokenFactory {
    String generateAccessToken(User user);
    String generateRefreshToken(User user);
    String parseAndVerifyRefreshToken(String token);
    Claims parseToken(String token);
}
