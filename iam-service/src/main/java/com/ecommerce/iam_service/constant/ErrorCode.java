package com.ecommerce.iam_service.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    VALIDATION_FAILED("IAM001", HttpStatus.BAD_REQUEST, "Validation failed", "Validation failed for the provided input"),
    INVALID_CREDENTIALS("IAM002", HttpStatus.UNAUTHORIZED, "Invalid credentials provided", "The provided credentials are invalid"),
    TOKEN_GENERATION_FAILED("IAM003", HttpStatus.INTERNAL_SERVER_ERROR, "Failed to generate token", "An unexpected error occurred, please try again later"),
    INTERNAL_ERROR("IAM004", HttpStatus.INTERNAL_SERVER_ERROR, "An internal error occurred", "An unexpected error occurred, please try again later"),
    INVALID_TOKEN("IAM005", HttpStatus.UNAUTHORIZED, "Invalid token", "The provided token is invalid or expired"),
    BAD_REQUEST("IAM006", HttpStatus.BAD_REQUEST, "Bad request", "The request could not be understood by the server due to malformed syntax"),
    USER_NOT_FOUND("IAM007", HttpStatus.NOT_FOUND, "User not found", "The requested user does not exist"),
    FORBIDDEN("IAM008", HttpStatus.FORBIDDEN, "Access denied", "You do not have permission to access this resource"),
    USER_ALREADY_EXISTS("IAM009", HttpStatus.CONFLICT, "User already exists", "The user with the provided email already exists"),
    DATABASE_READ_USER_ERROR("IAM010", HttpStatus.INTERNAL_SERVER_ERROR, "Error reading from database", "An unexpected error occurred, please try again later"),
    DATABASE_WRITE_USER_ERROR("IAM011", HttpStatus.INTERNAL_SERVER_ERROR, "Error writing to database", "An unexpected error occurred, please try again later"),
    DATA_MAPPING_ERROR("IAM012", HttpStatus.INTERNAL_SERVER_ERROR, "Error mapping data", "An unexpected error occurred, please try again later"),
    EVENT_SERIALIZATION_ERROR("IAM013", HttpStatus.INTERNAL_SERVER_ERROR, "Error serializing event", "An unexpected error occurred, please try again later"),;

    private final String code;
    private final HttpStatus httpStatus;
    private final String defaultMessage;
    private final String responseMessage;
}
