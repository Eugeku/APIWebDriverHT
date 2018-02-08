package com.epam.kuzora.hometask.service.exception;

public class APICommandException extends Exception {
    public APICommandException(String message, Exception e) {
        super(message, e);
    }

    public APICommandException(Exception e) {
        super(e);
    }
}
