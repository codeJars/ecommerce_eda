package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;

import java.util.Map;

public class TokenGenerationException extends ApiException{
    public TokenGenerationException(){
        super(ErrorCode.TOKEN_GENERATION_FAILED, ErrorCode.TOKEN_GENERATION_FAILED.getDefaultMessage(), null);
    }

    public TokenGenerationException(String message) {
        super(ErrorCode.TOKEN_GENERATION_FAILED, message, null);
    }

    public TokenGenerationException(Throwable cause){
        super(ErrorCode.TOKEN_GENERATION_FAILED, ErrorCode.TOKEN_GENERATION_FAILED.getDefaultMessage(), cause, null);
    }

    public TokenGenerationException(String message, Throwable cause) {
        super(ErrorCode.TOKEN_GENERATION_FAILED, message, cause, null);
    }

    public TokenGenerationException(ErrorCode errorCode){
        super(errorCode, errorCode.getDefaultMessage(), null);
    }

    public TokenGenerationException(ErrorCode errorCode, String message) {
        super(errorCode, message, null);
    }

    public TokenGenerationException(ErrorCode errorCode, Throwable cause){
        super(errorCode, errorCode.getDefaultMessage(), cause, null);
    }

    public TokenGenerationException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause, null);
    }


    public TokenGenerationException(Map<String, Object> context){
        super(ErrorCode.TOKEN_GENERATION_FAILED, ErrorCode.TOKEN_GENERATION_FAILED.getDefaultMessage(), context);
    }

    public TokenGenerationException(String message, Map<String, Object> context) {
        super(ErrorCode.TOKEN_GENERATION_FAILED, message, context);
    }

    public TokenGenerationException(Throwable cause, Map<String, Object> context){
        super(ErrorCode.TOKEN_GENERATION_FAILED, ErrorCode.TOKEN_GENERATION_FAILED.getDefaultMessage(), cause, context);
    }

    public TokenGenerationException(String message, Throwable cause, Map<String, Object> context) {
        super(ErrorCode.TOKEN_GENERATION_FAILED, message, cause, context);
    }

    public TokenGenerationException(ErrorCode errorCode, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), context);
    }

    public TokenGenerationException(ErrorCode errorCode, String message, Map<String, Object> context) {
        super(errorCode, message, context);
    }

    public TokenGenerationException(ErrorCode errorCode, Throwable cause, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), cause, context);
    }

    public TokenGenerationException(ErrorCode errorCode, String message, Throwable cause, Map<String, Object> context) {
        super(errorCode, message, cause, context);
    }
}
