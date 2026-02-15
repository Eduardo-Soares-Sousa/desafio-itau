package com.itau.apiRest.exceptions;

public class UnprocessableException extends RuntimeException {
    public UnprocessableException(String message) {
        super(message);
    }

    public UnprocessableException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
