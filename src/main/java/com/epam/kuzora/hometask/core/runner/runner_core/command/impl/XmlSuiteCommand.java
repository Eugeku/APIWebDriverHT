package com.epam.kuzora.hometask.core.runner.runner_core.command.impl;

import com.epam.kuzora.hometask.core.runner.runner_core.command.Ifaces.Command;
import com.epam.kuzora.hometask.core.runner.runner_core.command.exception.CommandException;
import org.testng.TestNG;
import java.util.ArrayList;

public class XmlSuiteCommand implements Command {

    @Override
    public Object runCommand(String... strings) throws CommandException {
        TestNG runner = new TestNG();
        ArrayList<String> testSuits = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            testSuits.add(strings[i]);
        }
        runner.setTestSuites(testSuits);
        runner.run();
        return "End";
    }
}
