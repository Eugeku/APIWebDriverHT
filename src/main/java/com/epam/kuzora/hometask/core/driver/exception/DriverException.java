package com.epam.kuzora.hometask.core.driver.exception;

public class DriverException extends Exception {

    DriverException(String message, Exception exception) {
        super(message, exception);
    }

    DriverException(String message) {
        super(message);
    }
}
