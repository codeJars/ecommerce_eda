package com.ecommerce.iam_service.exception;

import com.ecommerce.iam_service.constant.ErrorCode;
import lombok.Getter;

import java.util.Map;

@Getter
public class ApiException extends RuntimeException{
    private final ErrorCode errorCode;
    private final Map<String, Object> context;
    public ApiException(ErrorCode errorCode, String message, Map<String, Object> context) {
        super(message);
        this.errorCode = errorCode;
        this.context = context!=null ? context : Map.of();
    }

    public ApiException(ErrorCode errorCode, String message, Throwable cause, Map<String, Object> context) {
        super(message, cause);
        this.errorCode = errorCode;
        this.context = context!=null ? context : Map.of();
    }

    public String getContextString(){
        StringBuilder sb = new StringBuilder();
        context.forEach( (k,v) -> sb.append("{").append(k).append("=").append(v).append("}") );
        return sb.toString();
    }
}
