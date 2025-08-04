package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;

import java.util.Map;

public class InvalidTokenException extends ApiException{
    public InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN, ErrorCode.INVALID_TOKEN.getDefaultMessage(), null);
    }

    public InvalidTokenException(String message) {
        super(ErrorCode.INVALID_TOKEN, message, null);
    }

    public InvalidTokenException(Throwable cause){
        super(ErrorCode.INVALID_TOKEN, ErrorCode.INVALID_TOKEN.getDefaultMessage(), cause, null);
    }

    public InvalidTokenException(String message, Throwable cause) {
        super(ErrorCode.INVALID_TOKEN, message, cause, null);
    }

    public InvalidTokenException(ErrorCode errorCode){
        super(errorCode, errorCode.getDefaultMessage(), null);
    }

    public InvalidTokenException(ErrorCode errorCode, String message) {
        super(errorCode, message, null);
    }

    public InvalidTokenException(ErrorCode errorCode, Throwable cause){
        super(errorCode, errorCode.getDefaultMessage(), cause, null);
    }

    public InvalidTokenException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause, null);
    }


    public InvalidTokenException(Map<String, Object> context){
        super(ErrorCode.INVALID_TOKEN, ErrorCode.INVALID_TOKEN.getDefaultMessage(), context);
    }

    public InvalidTokenException(String message, Map<String, Object> context) {
        super(ErrorCode.INVALID_TOKEN, message, context);
    }

    public InvalidTokenException(Throwable cause, Map<String, Object> context){
        super(ErrorCode.INVALID_TOKEN, ErrorCode.INVALID_TOKEN.getDefaultMessage(), cause, context);
    }

    public InvalidTokenException(String message, Throwable cause, Map<String, Object> context) {
        super(ErrorCode.INVALID_TOKEN, message, cause, context);
    }

    public InvalidTokenException(ErrorCode errorCode, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), context);
    }

    public InvalidTokenException(ErrorCode errorCode, String message, Map<String, Object> context) {
        super(errorCode, message, context);
    }

    public InvalidTokenException(ErrorCode errorCode, Throwable cause, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), cause, context);
    }

    public InvalidTokenException(ErrorCode errorCode, String message, Throwable cause, Map<String, Object> context) {
        super(errorCode, message, cause, context);
    }
}
