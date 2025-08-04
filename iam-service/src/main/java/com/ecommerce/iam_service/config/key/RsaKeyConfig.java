package com.ecommerce.iam_service.config.key;

import com.ecommerce.iam_service.exception.KeyInitializationException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Map;

@Configuration
@Log4j2
@Getter
public class RsaKeyConfig {

    private final RSAPrivateKey privateKey;
    private final RSAPublicKey publicKey;
    private final Map<String, Object> jwkSetJson;

    private static final Base64.Decoder BASE64_DECODER = Base64.getDecoder();

    public RsaKeyConfig(
            @Value("${security.jwt.private-key}")
            String privateKey,

            @Value(("${security.jwt.public-key}"))
            String publicKey
    ) {
        this.privateKey = createPrivateKey(privateKey);
        this.publicKey = createPublicKey(publicKey);
        this.jwkSetJson = createJwkSetJson();
        log.info("RSA Key Configuration initialized successfully");
    }

    private Map<String, Object> createJwkSetJson() {
        try{
            return createJwkSet().toJSONObject();
        }catch (Exception e){
            throw new KeyInitializationException("Failed to convert JWK Set to JSON", e);
        }
    }

    private JWKSet createJwkSet() {
        try{
            RSAKey rsaKey = new RSAKey.Builder(publicKey)
                    .keyUse(KeyUse.SIGNATURE)
                    .algorithm(JWSAlgorithm.RS256)
                    .keyIDFromThumbprint()
                    .build();

            return new JWKSet(rsaKey);

        }catch (Exception e){
            throw new KeyInitializationException("Failed to generate JWK Set", e);
        }
    }

    private RSAPrivateKey createPrivateKey(String privateKey){
        try {
                byte[] decoded = BASE64_DECODER.decode(privateKey);
                PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(decoded);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                PrivateKey generatedKey = keyFactory.generatePrivate(spec);

                if (!(generatedKey instanceof RSAPrivateKey rsaPrivateKey)) {
                    throw new IllegalStateException("Unsupported key type: only RSAPrivateKey is supported");
                }

                return rsaPrivateKey;

        }catch (Exception e){
            throw new KeyInitializationException("Error loading RSA private key", e);
        }
    }

    private RSAPublicKey createPublicKey(String publicKey){
        try{
                byte[] decoded = BASE64_DECODER.decode(publicKey);
                X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                PublicKey generatedKey = keyFactory.generatePublic(spec);

                if (!(generatedKey instanceof RSAPublicKey rsaPublicKey)) {
                    throw new IllegalStateException("Unsupported key type: only RSAPublicKey is supported");
                }

                return rsaPublicKey;

        }catch (Exception e){
            throw new KeyInitializationException("Error loading RSA public key", e);
        }
    }

}
