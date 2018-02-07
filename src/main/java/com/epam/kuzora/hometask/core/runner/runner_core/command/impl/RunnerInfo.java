package com.epam.kuzora.hometask.core.runner.runner_core.command.impl;

import com.epam.kuzora.hometask.core.runner.runner_core.command.Ifaces.Command;
import com.epam.kuzora.hometask.core.runner.runner_core.command.exception.CommandException;

public class RunnerInfo implements Command {
    private static final String VERSION = "Runner (version: 0.0.2)";
    private static final String LIST_OF_AVAILABLE_COMMANDS = "Available commands:\n\r" +
            "1) XML_SUITE|WebBrowser version|pathToFile\\nameFile1.xml|[pathToFile\\nameFile1.xml]...\n\r" +
            "2) CLASS_TEST|WebBrowser version|nameOfClass1|[nameOfClass2]...\n\r" +
            "3) RUNNER_INFO\n\r";

    @Override
    public Object runCommand(String... strings) throws CommandException {
        String currentMessage = String.format("%s\n\r%s", VERSION, LIST_OF_AVAILABLE_COMMANDS);
        return currentMessage;
    }
}
