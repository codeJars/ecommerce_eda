package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;

import java.util.Map;

public class DataMappingException extends ApiException{
    public DataMappingException(){
        super(ErrorCode.DATA_MAPPING_ERROR, ErrorCode.DATA_MAPPING_ERROR.getDefaultMessage(), null);
    }

    public DataMappingException(String message) {
        super(ErrorCode.DATA_MAPPING_ERROR, message, null);
    }

    public DataMappingException(Throwable cause){
        super(ErrorCode.DATA_MAPPING_ERROR, ErrorCode.DATA_MAPPING_ERROR.getDefaultMessage(), cause, null);
    }

    public DataMappingException(String message, Throwable cause) {
        super(ErrorCode.DATA_MAPPING_ERROR, message, cause, null);
    }

    public DataMappingException(ErrorCode errorCode){
        super(errorCode, errorCode.getDefaultMessage(), null);
    }

    public DataMappingException(ErrorCode errorCode, String message) {
        super(errorCode, message, null);
    }

    public DataMappingException(ErrorCode errorCode, Throwable cause){
        super(errorCode, errorCode.getDefaultMessage(), cause, null);
    }

    public DataMappingException(ErrorCode errorCode, String message, Throwable cause) {
        super(errorCode, message, cause, null);
    }


    public DataMappingException(Map<String, Object> context){
        super(ErrorCode.DATA_MAPPING_ERROR, ErrorCode.DATA_MAPPING_ERROR.getDefaultMessage(), context);
    }

    public DataMappingException(String message, Map<String, Object> context) {
        super(ErrorCode.DATA_MAPPING_ERROR, message, context);
    }

    public DataMappingException(Throwable cause, Map<String, Object> context){
        super(ErrorCode.DATA_MAPPING_ERROR, ErrorCode.DATA_MAPPING_ERROR.getDefaultMessage(), cause, context);
    }

    public DataMappingException(String message, Throwable cause, Map<String, Object> context) {
        super(ErrorCode.DATA_MAPPING_ERROR, message, cause, context);
    }

    public DataMappingException(ErrorCode errorCode, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), context);
    }

    public DataMappingException(ErrorCode errorCode, String message, Map<String, Object> context) {
        super(errorCode, message, context);
    }

    public DataMappingException(ErrorCode errorCode, Throwable cause, Map<String, Object> context){
        super(errorCode, errorCode.getDefaultMessage(), cause, context);
    }

    public DataMappingException(ErrorCode errorCode, String message, Throwable cause, Map<String, Object> context) {
        super(errorCode, message, cause, context);
    }
}
