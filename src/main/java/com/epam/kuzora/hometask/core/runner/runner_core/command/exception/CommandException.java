package com.epam.kuzora.hometask.core.runner.runner_core.command.exception;

public class CommandException extends Exception {
    public CommandException(String message, Exception e) {
        super(message, e);
    }

    public CommandException(String message) {
        super(message);
    }
}
