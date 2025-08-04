package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;

import java.util.Map;

public class UserAlreadyExistException extends ApiException{
    public UserAlreadyExistException(){
        super(ErrorCode.USER_ALREADY_EXISTS, ErrorCode.USER_ALREADY_EXISTS.getDefaultMessage(), null);
    }

    public UserAlreadyExistException(String message) {
        super(ErrorCode.USER_ALREADY_EXISTS, message, null);
    }

    public UserAlreadyExistException(Throwable cause){
        super(ErrorCode.USER_ALREADY_EXISTS, ErrorCode.USER_ALREADY_EXISTS.getDefaultMessage(), cause, null);
    }

    public UserAlreadyExistException(String message, Throwable cause) {
        super(ErrorCode.USER_ALREADY_EXISTS, message, cause, null);
    }

    public UserAlreadyExistException(ErrorCode errorCode){
        super(errorCode, errorCode.getDefaultMessage(), null);
    }

    public UserAlreadyExistException(ErrorCode errorCode, String message) {
        super(errorCode, message, null);
    }

    public UserAlreadyExistException(ErrorCode errorCode, Throwable cause){
        super(errorCode, errorCode.getDefaultMessage(), cause, null);
    }

    public UserAlreadyExistException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause, null);
    }


    public UserAlreadyExistException(Map<String, Object> context){
        super(ErrorCode.USER_ALREADY_EXISTS, ErrorCode.USER_ALREADY_EXISTS.getDefaultMessage(), context);
    }

    public UserAlreadyExistException(String message, Map<String, Object> context) {
        super(ErrorCode.USER_ALREADY_EXISTS, message, context);
    }

    public UserAlreadyExistException(Throwable cause, Map<String, Object> context){
        super(ErrorCode.USER_ALREADY_EXISTS, ErrorCode.USER_ALREADY_EXISTS.getDefaultMessage(), cause, context);
    }

    public UserAlreadyExistException(String message, Throwable cause, Map<String, Object> context) {
        super(ErrorCode.USER_ALREADY_EXISTS, message, cause, context);
    }

    public UserAlreadyExistException(ErrorCode errorCode, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), context);
    }

    public UserAlreadyExistException(ErrorCode errorCode, String message, Map<String, Object> context) {
        super(errorCode, message, context);
    }

    public UserAlreadyExistException(ErrorCode errorCode, Throwable cause, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), cause, context);
    }

    public UserAlreadyExistException(ErrorCode errorCode, String message, Throwable cause, Map<String, Object> context) {
        super(errorCode, message, cause, context);
    }
}
