package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;

import java.util.Map;

public class EventSerializationException extends ApiException{
    public EventSerializationException(){
        super(ErrorCode.EVENT_SERIALIZATION_ERROR, ErrorCode.EVENT_SERIALIZATION_ERROR.getDefaultMessage(), null);
    }

    public EventSerializationException(String message) {
        super(ErrorCode.EVENT_SERIALIZATION_ERROR, message, null);
    }

    public EventSerializationException(Throwable cause){
        super(ErrorCode.EVENT_SERIALIZATION_ERROR, ErrorCode.EVENT_SERIALIZATION_ERROR.getDefaultMessage(), cause, null);
    }

    public EventSerializationException(String message, Throwable cause) {
        super(ErrorCode.EVENT_SERIALIZATION_ERROR, message, cause, null);
    }

    public EventSerializationException(ErrorCode errorCode){
        super(errorCode, errorCode.getDefaultMessage(), null);
    }

    public EventSerializationException(ErrorCode errorCode, String message) {
        super(errorCode, message, null);
    }

    public EventSerializationException(ErrorCode errorCode, Throwable cause){
        super(errorCode, errorCode.getDefaultMessage(), cause, null);
    }

    public EventSerializationException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause, null);
    }


    public EventSerializationException(Map<String, Object> context){
        super(ErrorCode.EVENT_SERIALIZATION_ERROR, ErrorCode.EVENT_SERIALIZATION_ERROR.getDefaultMessage(), context);
    }

    public EventSerializationException(String message, Map<String, Object> context) {
        super(ErrorCode.EVENT_SERIALIZATION_ERROR, message, context);
    }

    public EventSerializationException(Throwable cause, Map<String, Object> context){
        super(ErrorCode.EVENT_SERIALIZATION_ERROR, ErrorCode.EVENT_SERIALIZATION_ERROR.getDefaultMessage(), cause, context);
    }

    public EventSerializationException(String message, Throwable cause, Map<String, Object> context) {
        super(ErrorCode.EVENT_SERIALIZATION_ERROR, message, cause, context);
    }

    public EventSerializationException(ErrorCode errorCode, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), context);
    }

    public EventSerializationException(ErrorCode errorCode, String message, Map<String, Object> context) {
        super(errorCode, message, context);
    }

    public EventSerializationException(ErrorCode errorCode, Throwable cause, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), cause, context);
    }

    public EventSerializationException(ErrorCode errorCode, String message, Throwable cause, Map<String, Object> context) {
        super(errorCode, message, cause, context);
    }
}
