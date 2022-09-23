package com.example.service;

public class NoMerchInventoryException extends Exception {

    public NoMerchInventoryException(String message) {
        super(message);
    }

    public NoMerchInventoryException(String message, Throwable cause) {
        super(message, cause);
    }

}
