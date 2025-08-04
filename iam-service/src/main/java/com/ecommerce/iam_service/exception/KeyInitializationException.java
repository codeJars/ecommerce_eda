package com.ecommerce.iam_service.exception;

public class KeyInitializationException extends RuntimeException{

    public KeyInitializationException(){
        super("Key Initialization Failed");
    }

    public KeyInitializationException(String message) {
        super(message);
    }

    public KeyInitializationException(String message, Throwable cause) {
        super(message, cause);
    }

}
