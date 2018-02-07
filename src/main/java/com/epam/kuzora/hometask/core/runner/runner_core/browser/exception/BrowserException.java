package com.epam.kuzora.hometask.core.runner.runner_core.browser.exception;

public class BrowserException extends Exception {
    public BrowserException(String message, Exception e) {
        super(message, e);
    }

    public BrowserException(String message) {
        super(message);
    }
}
