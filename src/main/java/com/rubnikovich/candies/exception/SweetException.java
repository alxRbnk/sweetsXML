package com.rubnikovich.candies.exception;

public class SweetException extends Exception {

    public SweetException() {
    }

    public SweetException(String message) {
        super(message);
    }

    public SweetException(String message, Throwable cause) {
        super(message, cause);
    }

    public SweetException(Throwable cause) {
        super(cause);
    }

}
