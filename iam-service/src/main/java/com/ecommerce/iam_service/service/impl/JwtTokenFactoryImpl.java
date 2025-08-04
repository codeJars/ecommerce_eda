package com.ecommerce.iam_service.service.impl;

import com.ecommerce.iam_service.config.key.RsaKeyConfig;
import com.ecommerce.iam_service.dto.response.LoginUserResponse;
import com.ecommerce.iam_service.dto.response.RefreshTokenResponse;
import com.ecommerce.iam_service.exception.DataMappingException;
import com.ecommerce.iam_service.exception.InvalidTokenException;
import com.ecommerce.iam_service.exception.TokenGenerationException;
import com.ecommerce.iam_service.entity.User;
import com.ecommerce.iam_service.service.JwtTokenFactory;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.security.interfaces.RSAPrivateKey;
import java.time.Instant;
import java.util.*;

import static com.ecommerce.iam_service.constant.SecurityConstant.*;
import static com.ecommerce.iam_service.constant.SecurityConstant.TOKEN_TYPE;

@Service
@Log4j2
@RequiredArgsConstructor
public class JwtTokenFactoryImpl implements JwtTokenFactory {

    private final RsaKeyConfig rsaKeyConfig;

    @Override
    public String generateAccessToken(User user) {

        Map<String, Object> baseClaims = Map.of("scope", user.getScope());
        return createToken(user, baseClaims,ACCESS_TOKEN_VALIDITY_SECONDS);
    }

    @Override
    public String generateRefreshToken(User user) {

        Map<String, Object> baseClaims = Map.of("scope", REFRESH_SCOPE);
        return createToken(user, baseClaims,REFRESH_TOKEN_VALIDITY_SECONDS);
    }

    @Override
    public String parseAndVerifyRefreshToken(String token) {

        Claims claims = parseToken(token);

        String scope = (String) claims.get("scope");
        String subject = claims.getSubject();

        if (!REFRESH_SCOPE.equals(scope))
            throw new InvalidTokenException(Map.of("message","Invalid refresh token scope"));

        if (subject == null || subject.isEmpty())
            throw new InvalidTokenException(Map.of("message","Invalid refresh token subject"));

        return subject;
    }

    @Override
    public Claims parseToken(String token) {

        try {
            return Jwts
                .parser()
                .verifyWith(rsaKeyConfig.getPublicKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        }catch (ExpiredJwtException e) {
            throw new InvalidTokenException(
                    "Jwt parsing failed: Token has expired",
                    e,
                    Map.of("subject", e.getClaims().getSubject())
            );

        } catch (UnsupportedJwtException e) {
            throw new InvalidTokenException("Jwt parsing failed: Unsupported JWT token", e);

        } catch (MalformedJwtException e) {
            throw new InvalidTokenException("Jwt parsing failed: Malformed JWT", e);

        } catch (SecurityException e) {
            throw new InvalidTokenException("Jwt parsing failed: Invalid JWT signature", e);

        } catch (IllegalArgumentException e) {
            throw new InvalidTokenException("Jwt parsing failed: Token must not be null or empty", e);
        }
    }

    private String createToken(User user, Map<String, Object> baseClaims, Long tokenValiditySeconds) {

        RSAPrivateKey privateKey = rsaKeyConfig.getPrivateKey();
        Map<String, Object> claims = prepareClaims(baseClaims, user);

        return buildJwtToken(user.getUserId().toString(), claims, tokenValiditySeconds, privateKey);
    }

    private Map<String, Object> prepareClaims(Map<String, Object> baseClaims, User user){

        try {

            Map<String, Object> claims = new HashMap<>(Optional.ofNullable(baseClaims).orElse(Map.of()));
            claims.put("email", user.getEmail());
            claims.put("authorities", user.getRoles());
            claims.put("typ", "JWT");

            return claims;

        }catch (Exception e) {
            throw new TokenGenerationException("Failed to prepare claims for JWT", e);
        }
    }

    private String buildJwtToken(String subject, Map<String, Object> claims, Long tokenValiditySeconds, RSAPrivateKey privateKey){
        try{
            String jwtId = UUID.randomUUID().toString();
            Instant instant = Instant.now();

            return Jwts.builder()
                    .id(jwtId)
                    .subject(subject)
                    .claims(claims)
                    .issuer(TOKEN_ISSUER)
                    .issuedAt(Date.from(instant))
                    .expiration(Date.from(instant.plusSeconds(tokenValiditySeconds)))
                    .signWith(privateKey) //SignatureAlgorithm.RS256
                    .compact();

        }catch (Exception e) {
            throw new TokenGenerationException(e);
        }
    }


}
