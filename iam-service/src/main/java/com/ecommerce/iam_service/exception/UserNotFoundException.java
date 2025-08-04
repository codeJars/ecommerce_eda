package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;

import java.util.Map;

public class UserNotFoundException extends ApiException {
    public UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND, ErrorCode.USER_NOT_FOUND.getDefaultMessage(), null);
    }

    public UserNotFoundException(String message) {
        super(ErrorCode.USER_NOT_FOUND, message, null);
    }

    public UserNotFoundException(Throwable cause){
        super(ErrorCode.USER_NOT_FOUND, ErrorCode.USER_NOT_FOUND.getDefaultMessage(), cause, null);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(ErrorCode.USER_NOT_FOUND, message, cause, null);
    }

    public UserNotFoundException(ErrorCode errorCode){
        super(errorCode, errorCode.getDefaultMessage(), null);
    }

    public UserNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message, null);
    }

    public UserNotFoundException(ErrorCode errorCode, Throwable cause){
        super(errorCode, errorCode.getDefaultMessage(), cause, null);
    }

    public UserNotFoundException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause, null);
    }


    public UserNotFoundException(Map<String, Object> context){
        super(ErrorCode.USER_NOT_FOUND, ErrorCode.USER_NOT_FOUND.getDefaultMessage(), context);
    }

    public UserNotFoundException(String message, Map<String, Object> context) {
        super(ErrorCode.USER_NOT_FOUND, message, context);
    }

    public UserNotFoundException(Throwable cause, Map<String, Object> context){
        super(ErrorCode.USER_NOT_FOUND, ErrorCode.USER_NOT_FOUND.getDefaultMessage(), cause, context);
    }

    public UserNotFoundException(String message, Throwable cause, Map<String, Object> context) {
        super(ErrorCode.USER_NOT_FOUND, message, cause, context);
    }

    public UserNotFoundException(ErrorCode errorCode, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), context);
    }

    public UserNotFoundException(ErrorCode errorCode, String message, Map<String, Object> context) {
        super(errorCode, message, context);
    }

    public UserNotFoundException(ErrorCode errorCode, Throwable cause, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), cause, context);
    }

    public UserNotFoundException(ErrorCode errorCode, String message, Throwable cause, Map<String, Object> context) {
        super(errorCode, message, cause, context);
    }
}
