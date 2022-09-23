package com.example.service;

public class NoSuchMerchException extends Exception {

    public NoSuchMerchException(String message) {
        super(message);
    }

    public NoSuchMerchException(String message, Throwable cause) {
        super(message, cause);
    }
}
