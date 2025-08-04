package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;

import java.util.Map;

public class InvalidCredentialsException extends ApiException{

    public InvalidCredentialsException(){
        super(ErrorCode.INVALID_CREDENTIALS, ErrorCode.INVALID_CREDENTIALS.getDefaultMessage(), null);
    }

    public InvalidCredentialsException(String message) {
        super(ErrorCode.INVALID_CREDENTIALS, message, null);
    }

    public InvalidCredentialsException(Throwable cause){
        super(ErrorCode.INVALID_CREDENTIALS, ErrorCode.INVALID_CREDENTIALS.getDefaultMessage(), cause, null);
    }

    public InvalidCredentialsException(String message, Throwable cause) {
        super(ErrorCode.INVALID_CREDENTIALS, message, cause, null);
    }

    public InvalidCredentialsException(ErrorCode errorCode){
        super(errorCode, errorCode.getDefaultMessage(), null);
    }

    public InvalidCredentialsException(ErrorCode errorCode, String message) {
        super(errorCode, message, null);
    }

    public InvalidCredentialsException(ErrorCode errorCode, Throwable cause){
        super(errorCode, errorCode.getDefaultMessage(), cause, null);
    }

    public InvalidCredentialsException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause, null);
    }


    public InvalidCredentialsException(Map<String, Object> context){
        super(ErrorCode.INVALID_CREDENTIALS, ErrorCode.INVALID_CREDENTIALS.getDefaultMessage(), context);
    }

    public InvalidCredentialsException(String message, Map<String, Object> context) {
        super(ErrorCode.INVALID_CREDENTIALS, message, context);
    }

    public InvalidCredentialsException(Throwable cause, Map<String, Object> context){
        super(ErrorCode.INVALID_CREDENTIALS, ErrorCode.INVALID_CREDENTIALS.getDefaultMessage(), cause, context);
    }

    public InvalidCredentialsException(String message, Throwable cause, Map<String, Object> context) {
        super(ErrorCode.INVALID_CREDENTIALS, message, cause, context);
    }

    public InvalidCredentialsException(ErrorCode errorCode, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), context);
    }

    public InvalidCredentialsException(ErrorCode errorCode, String message, Map<String, Object> context) {
        super(errorCode, message, context);
    }

    public InvalidCredentialsException(ErrorCode errorCode, Throwable cause, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), cause, context);
    }

    public InvalidCredentialsException(ErrorCode errorCode, String message, Throwable cause, Map<String, Object> context) {
        super(errorCode, message, cause, context);
    }


}
