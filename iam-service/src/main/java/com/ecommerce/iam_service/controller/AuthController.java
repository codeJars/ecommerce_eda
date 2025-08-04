package com.ecommerce.iam_service.controller;

import com.ecommerce.iam_service.dto.request.LoginUserRequest;
import com.ecommerce.iam_service.dto.request.RefreshTokenRequest;
import com.ecommerce.iam_service.dto.request.RegisterUserRequest;
import com.ecommerce.iam_service.dto.response.*;
import com.ecommerce.iam_service.service.ApiService;
import com.ecommerce.iam_service.service.JwtService;
import com.ecommerce.iam_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Log4j2
public class AuthController {

    private final JwtService jwtService;
    private final ApiService apiService;
    private final UserService userService;

    @PostMapping("/login")
    public Mono<ResponseEntity<StandardApiResponse<LoginUserResponse>>> login(@RequestBody @Valid LoginUserRequest loginUserRequest){

        log.info("Login request received for user : {}", loginUserRequest.username());

        return jwtService.loginUser(loginUserRequest)
                .map(loginUserResponse -> {

                    StandardApiResponse<LoginUserResponse> response =
                            apiService.buildStandardApiResponse(HttpStatus.OK.value(), "Login successful", loginUserResponse);

                    return ResponseEntity.ok(response);
                })
                .doOnSuccess(responseEntity -> log.info("Login successful for user: {}", responseEntity.getBody().data().user().userId() ));
    }

    @PostMapping("/refresh")
    public Mono<ResponseEntity<StandardApiResponse<RefreshTokenResponse>>> refresh(@RequestBody @Valid RefreshTokenRequest refreshTokenRequest){

        log.info("Refresh token request received");

        return jwtService.refreshToken(refreshTokenRequest)
                .map(refreshTokenResponse -> {

                    StandardApiResponse<RefreshTokenResponse> response =
                            apiService.buildStandardApiResponse(HttpStatus.OK.value(), "Token refreshed successfully", refreshTokenResponse);

                    return ResponseEntity.ok(response);
                })
                .doOnSuccess(responseEntity -> log.info("Token refreshed successfully for user: {}", responseEntity.getBody().data().user().userId()));
    }

    @PostMapping("/register")
    public Mono<ResponseEntity<StandardApiResponse<RegisterUserResponse>>> register(@RequestBody @Valid RegisterUserRequest registerUserRequest){

        log.info("User registration request received for user: {}", registerUserRequest.username());

        return userService.registerUser(registerUserRequest)
                .map(registerUserResponse -> {

                    StandardApiResponse<RegisterUserResponse> response =
                            apiService.buildStandardApiResponse(HttpStatus.CREATED.value(), "User registered successfully", registerUserResponse);

                    return ResponseEntity.status(HttpStatus.CREATED).body(response);
                })
                .doOnSuccess(responseEntity -> log.info("User registered successfully: {}", responseEntity.getBody().data().user().userId()));
    }

//    @PreAuthorize("hasAuthority(T(com.ecommerce.iam_service.constant.Authority.Scope).SCOPE_ADMIN)")
//    @GetMapping("/secured_admin")
//    public Mono<ResponseEntity<StandardApiResponse<String>>> securedAdminEndpoint() {
//        log.info("Accessing secured admin endpoint");
//
//        return ReactiveSecurityContextHolder.getContext()
//                .map(ctx -> {
//                    String authority = ctx.getAuthentication().getAuthorities().toString();
//                    log.info("User has authority: {}", authority);
//                    StandardApiResponse<String> response =
//                            apiService.buildStandardApiResponse(HttpStatus.OK.value(), "Access granted to secured admin endpoint", authority);
//                    return ResponseEntity.ok(response);
//                });
//    }
//
//    @PreAuthorize("hasAuthority('SCOPE_USER')")
//    @GetMapping("/secured_user")
//    public Mono<ResponseEntity<StandardApiResponse<String>>> securedUserEndpoint() {
//        log.info("Accessing secured user endpoint");
//
//        return ReactiveSecurityContextHolder.getContext()
//                .map(ctx -> {
//                    String authority = ctx.getAuthentication().getAuthorities().toString();
//                    log.info("User has authority: {}", authority);
//                    StandardApiResponse<String> response =
//                            apiService.buildStandardApiResponse(HttpStatus.OK.value(), "Access granted to secured user endpoint", authority);
//                    return ResponseEntity.ok(response);
//                });
//    }
//
//    @GetMapping("/protected")
//    public Mono<ResponseEntity<StandardApiResponse<List<String>>>> protectedEndpoint() {
//        log.info("Accessing protected endpoint");
//
//        return ReactiveSecurityContextHolder.getContext()
//                .map(ctx -> {
//                    List<String> authorityList = ctx.getAuthentication().getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
//                    log.info("User has authority: {}", authorityList);
//                    StandardApiResponse<List<String>> response =
//                            apiService.buildStandardApiResponse(HttpStatus.OK.value(), "Access granted to protected endpoint", authorityList);
//                    return ResponseEntity.ok(response);
//                });
//    }

    // Responsibilities
    // register
    // roles
    // Account lock, expiry, enable/disable flags

}
