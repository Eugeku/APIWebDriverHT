package com.epam.kuzora.hometask.core.runner.runner_core.command.Ifaces;

import com.epam.kuzora.hometask.core.runner.runner_core.command.exception.CommandException;

public interface Command {
    Object runCommand(String... strings) throws CommandException;
}
