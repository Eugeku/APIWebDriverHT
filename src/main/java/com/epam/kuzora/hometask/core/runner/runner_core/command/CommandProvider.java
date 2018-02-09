package com.epam.kuzora.hometask.core.runner.runner_core.command;

import com.epam.kuzora.hometask.core.runner.runner_core.command.Ifaces.Command;
import com.epam.kuzora.hometask.core.runner.runner_core.command.exception.CommandException;
import com.epam.kuzora.hometask.core.runner.runner_core.command.impl.ClassTestCommand;
import com.epam.kuzora.hometask.core.runner.runner_core.command.impl.RunnerInfo;
import com.epam.kuzora.hometask.core.runner.runner_core.command.impl.XmlSuiteCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static final CommandProvider instance = new CommandProvider();
    private Map<CommandName, Command> commandList = new HashMap<>();

    private CommandProvider() {
        commandList.put(CommandName.XML_SUITE, new XmlSuiteCommand());
        commandList.put(CommandName.RUNNER_INFO, new RunnerInfo());
        commandList.put(CommandName.CLASS_TEST, new ClassTestCommand());
    }

    public static CommandProvider getInstance() {
        return instance;
    }

    public Command getCommand(String stringCommand) throws CommandException {
        String com = stringCommand.replace("-", "_").toUpperCase();
        Command command;
        CommandName name;
        try {
            name = CommandName.valueOf(com);
            command = commandList.get(name);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new CommandException(e.getMessage(), e);
        }
        if (command == null) {
            command = commandList.get(CommandName.RUNNER_INFO);
        }
        return command;
    }
}
