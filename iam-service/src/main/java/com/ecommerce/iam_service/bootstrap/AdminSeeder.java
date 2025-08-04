package com.ecommerce.iam_service.bootstrap;

import com.ecommerce.iam_service.constant.Authority;
import com.ecommerce.iam_service.entity.User;
import com.ecommerce.iam_service.service.UserService;
import com.ecommerce.iam_service.service.UserServiceFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Log4j2
public class AdminSeeder implements ApplicationRunner {

    private final UserServiceFactory userServiceFactory;
    private final PasswordEncoder encoder;

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @Override
    public void run(ApplicationArguments args){

        if(adminEmail == null || adminPassword == null) {
            log.info("Skipping admin seeding: Admin credentials not provided");
            return;
        }

        userServiceFactory.getUser(adminEmail)
            .map(existing -> {
                log.info("Skipping admin seeding: Admin user already exists");
                return existing;
            })
            .switchIfEmpty(
                userServiceFactory.saveUser(
                    User.getUserWithDefaults().toBuilder()
                            .email(adminEmail)
                            .passwordHash(encoder.encode(adminPassword))
                            .authorities(buildAuthorities())
                            .build()
                )
                .doOnSuccess(user -> log.info("Admin user seeded with ID: {}", user.getUserId()))
            )
            .block();
    }

    private String buildAuthorities() {
        return String.join(",", Authority.ADMIN.name(), Authority.USER.name());
    }

}

