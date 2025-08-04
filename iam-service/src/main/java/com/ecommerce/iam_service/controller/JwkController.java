package com.ecommerce.iam_service.controller;

import com.ecommerce.iam_service.config.key.RsaKeyConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/.well-known")
@RequiredArgsConstructor
public class JwkController {

    private final RsaKeyConfig rsaKeyConfig;

    @GetMapping("/jwks.json")
    public Mono<Map<String, Object>> getJwkSet() {
        return Mono.just(rsaKeyConfig.getJwkSetJson());
    }

}
