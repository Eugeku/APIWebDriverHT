package com.epam.kuzora.hometask.service.exception;

public class APIServiceException extends Exception {
    public APIServiceException(String message, Exception e) {
        super(message, e);
    }

    public APIServiceException(Exception e) {
        super(e);
    }
}
