package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;

import java.util.Map;

public class DatabaseReadUserException extends ApiException{
    public DatabaseReadUserException(){
        super(ErrorCode.DATABASE_READ_USER_ERROR, ErrorCode.DATABASE_READ_USER_ERROR.getDefaultMessage(), null);
    }

    public DatabaseReadUserException(String message) {
        super(ErrorCode.DATABASE_READ_USER_ERROR, message, null);
    }

    public DatabaseReadUserException(Throwable cause){
        super(ErrorCode.DATABASE_READ_USER_ERROR, ErrorCode.DATABASE_READ_USER_ERROR.getDefaultMessage(), cause, null);
    }

    public DatabaseReadUserException(String message, Throwable cause) {
        super(ErrorCode.DATABASE_READ_USER_ERROR, message, cause, null);
    }

    public DatabaseReadUserException(ErrorCode errorCode){
        super(errorCode, errorCode.getDefaultMessage(), null);
    }

    public DatabaseReadUserException(ErrorCode errorCode, String message) {
        super(errorCode, message, null);
    }

    public DatabaseReadUserException(ErrorCode errorCode, Throwable cause){
        super(errorCode, errorCode.getDefaultMessage(), cause, null);
    }

    public DatabaseReadUserException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause, null);
    }


    public DatabaseReadUserException(Map<String, Object> context){
        super(ErrorCode.DATABASE_READ_USER_ERROR, ErrorCode.DATABASE_READ_USER_ERROR.getDefaultMessage(), context);
    }

    public DatabaseReadUserException(String message, Map<String, Object> context) {
        super(ErrorCode.DATABASE_READ_USER_ERROR, message, context);
    }

    public DatabaseReadUserException(Throwable cause, Map<String, Object> context){
        super(ErrorCode.DATABASE_READ_USER_ERROR, ErrorCode.DATABASE_READ_USER_ERROR.getDefaultMessage(), cause, context);
    }

    public DatabaseReadUserException(String message, Throwable cause, Map<String, Object> context) {
        super(ErrorCode.DATABASE_READ_USER_ERROR, message, cause, context);
    }

    public DatabaseReadUserException(ErrorCode errorCode, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), context);
    }

    public DatabaseReadUserException(ErrorCode errorCode, String message, Map<String, Object> context) {
        super(errorCode, message, context);
    }

    public DatabaseReadUserException(ErrorCode errorCode, Throwable cause, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), cause, context);
    }

    public DatabaseReadUserException(ErrorCode errorCode, String message, Throwable cause, Map<String, Object> context) {
        super(errorCode, message, cause, context);
    }
}
