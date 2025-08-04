package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;
import com.ecommerce.iam_service.dto.response.StandardApiErrorResponse;
import com.ecommerce.iam_service.dto.response.FieldValidationErrorDto;
import com.ecommerce.iam_service.dto.response.StandardApiResponse;
import com.ecommerce.iam_service.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebInputException;
import reactor.core.publisher.Mono;

import java.util.List;

@RestControllerAdvice
@Log4j2
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ApiService apiService;


    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ResponseEntity<StandardApiResponse<StandardApiErrorResponse>>> handleValidationExceptions(WebExchangeBindException e, ServerHttpRequest request){

        ErrorCode errorCode = ErrorCode.VALIDATION_FAILED;

        List<FieldValidationErrorDto> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map( err -> new FieldValidationErrorDto(err.getField(), err.getDefaultMessage()))
                .toList();

        log.warn(errorCode.getCode() + ": " + errorCode.getDefaultMessage() + ": " + errors);

        StandardApiResponse<StandardApiErrorResponse> response =
                apiService.buildStandardApiErrorResponse(
                        errorCode,
                        errorCode.getResponseMessage(),
                        request.getPath().toString(),
                        errors
                );

        return Mono.just(ResponseEntity.badRequest().body(response));
    }

    @ExceptionHandler(ServerWebInputException.class)
    public Mono<ResponseEntity<StandardApiResponse<StandardApiErrorResponse>>> handleMissingBody(ServerWebInputException e, ServerHttpRequest request) {

        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
        log.warn(errorCode.getCode() + ": " + errorCode.getDefaultMessage(), e);

        StandardApiResponse<StandardApiErrorResponse> response =
                apiService.buildStandardApiErrorResponse(
                        errorCode,
                        errorCode.getResponseMessage(),
                        request.getURI().toString(),
                        null
                );

        return Mono.just(ResponseEntity.status(errorCode.getHttpStatus()).body(response));
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public Mono<ResponseEntity<StandardApiResponse<StandardApiErrorResponse>>> handleAuthorizationDeniedException(AuthorizationDeniedException e, ServerHttpRequest request) {

        ErrorCode errorCode = ErrorCode.FORBIDDEN;
        log.warn(errorCode.getCode() + ": " + errorCode.getDefaultMessage(), e);

        StandardApiResponse<StandardApiErrorResponse> response =
                apiService.buildStandardApiErrorResponse(
                        errorCode,
                        errorCode.getResponseMessage(),
                        request.getPath().toString(),
                        null
                );

        return Mono.just(ResponseEntity.status(errorCode.getHttpStatus()).body(response));
    }

    @ExceptionHandler(ApiException.class)
    public Mono<ResponseEntity<StandardApiResponse<StandardApiErrorResponse>>> handleApiException(ApiException e, ServerHttpRequest request){

        ErrorCode errorCode = e.getErrorCode();

        log.warn("Handled ApiException [{}]: {} - Context: {} - Path: {}",
                errorCode.getCode(), e.getMessage(), e.getContextString(), request.getPath().toString(), e);

        StandardApiResponse<StandardApiErrorResponse> response =
                apiService.buildStandardApiErrorResponse(
                        errorCode,
                        errorCode.getResponseMessage(),
                        request.getPath().toString(),
                        null
                );

        return Mono.just(ResponseEntity.status(e.getErrorCode().getHttpStatus()).body(response));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ResponseEntity<StandardApiResponse<StandardApiErrorResponse>>> handleGenericException(Exception e, ServerHttpRequest request){

        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;
        log.error("Unexpected error: {}", e.getMessage(), e);

        StandardApiResponse<StandardApiErrorResponse> response =
                apiService.buildStandardApiErrorResponse(
                        errorCode,
                        errorCode.getResponseMessage(),
                        request.getPath().toString(),
                        null
                );

        return Mono.just(ResponseEntity.status(errorCode.getHttpStatus().value()).body(response));
    }
}
