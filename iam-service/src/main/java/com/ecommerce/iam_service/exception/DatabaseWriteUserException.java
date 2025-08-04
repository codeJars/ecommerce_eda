package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;

import java.util.Map;

public class DatabaseWriteUserException extends ApiException{
    public DatabaseWriteUserException(){
        super(ErrorCode.DATABASE_WRITE_USER_ERROR, ErrorCode.DATABASE_WRITE_USER_ERROR.getDefaultMessage(), null);
    }

    public DatabaseWriteUserException(String message) {
        super(ErrorCode.DATABASE_WRITE_USER_ERROR, message, null);
    }

    public DatabaseWriteUserException(Throwable cause){
        super(ErrorCode.DATABASE_WRITE_USER_ERROR, ErrorCode.DATABASE_WRITE_USER_ERROR.getDefaultMessage(), cause, null);
    }

    public DatabaseWriteUserException(String message, Throwable cause) {
        super(ErrorCode.DATABASE_WRITE_USER_ERROR, message, cause, null);
    }

    public DatabaseWriteUserException(ErrorCode errorCode){
        super(errorCode, errorCode.getDefaultMessage(), null);
    }

    public DatabaseWriteUserException(ErrorCode errorCode, String message) {
        super(errorCode, message, null);
    }

    public DatabaseWriteUserException(ErrorCode errorCode, Throwable cause){
        super(errorCode, errorCode.getDefaultMessage(), cause, null);
    }

    public DatabaseWriteUserException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause, null);
    }


    public DatabaseWriteUserException(Map<String, Object> context){
        super(ErrorCode.DATABASE_WRITE_USER_ERROR, ErrorCode.DATABASE_WRITE_USER_ERROR.getDefaultMessage(), context);
    }

    public DatabaseWriteUserException(String message, Map<String, Object> context) {
        super(ErrorCode.DATABASE_WRITE_USER_ERROR, message, context);
    }

    public DatabaseWriteUserException(Throwable cause, Map<String, Object> context){
        super(ErrorCode.DATABASE_WRITE_USER_ERROR, ErrorCode.DATABASE_WRITE_USER_ERROR.getDefaultMessage(), cause, context);
    }

    public DatabaseWriteUserException(String message, Throwable cause, Map<String, Object> context) {
        super(ErrorCode.DATABASE_WRITE_USER_ERROR, message, cause, context);
    }

    public DatabaseWriteUserException(ErrorCode errorCode, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), context);
    }

    public DatabaseWriteUserException(ErrorCode errorCode, String message, Map<String, Object> context) {
        super(errorCode, message, context);
    }

    public DatabaseWriteUserException(ErrorCode errorCode, Throwable cause, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), cause, context);
    }

    public DatabaseWriteUserException(ErrorCode errorCode, String message, Throwable cause, Map<String, Object> context) {
        super(errorCode, message, cause, context);
    }
}
