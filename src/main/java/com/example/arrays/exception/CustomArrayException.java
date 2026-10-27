package com.example.arrays.exception;

public class CustomArrayException extends Exception {

    private static final long serialVersionUID = 1L;

    public CustomArrayException() {
    }

    public CustomArrayException(String message) {
        super(message);
    }

    public CustomArrayException(Throwable cause) {
        super(cause);
    }

    public CustomArrayException(String message, Throwable cause) {
        super(message, cause);
    }
}
