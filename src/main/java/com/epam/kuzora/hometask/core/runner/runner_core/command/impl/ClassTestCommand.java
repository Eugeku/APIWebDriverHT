package com.epam.kuzora.hometask.core.runner.runner_core.command.impl;

import com.epam.kuzora.hometask.core.listener.ListenerHandler;
import com.epam.kuzora.hometask.core.runner.runner_core.command.Ifaces.Command;
import com.epam.kuzora.hometask.core.runner.runner_core.command.exception.CommandException;
import org.testng.ITestNGListener;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

public class ClassTestCommand implements Command {
    private static final String LOCAL_PATH_IN_PROJECT_FOR_CLASSES = "com.epam.kuzora.hometask.tests.test.";

    @Override
    public Object runCommand(String... strings) throws CommandException {
        TestNG runner = new TestNG();
        Class[] classes = new Class[strings.length];
        for (int i = 0; i < classes.length; i++) {
            try {
                String className = LOCAL_PATH_IN_PROJECT_FOR_CLASSES + strings[i];
                classes[i] = Class.forName(className);
            } catch (ClassNotFoundException e) {
            }
        }
        runner.setTestClasses(classes);
        List<Class<? extends ITestNGListener>> listeners = new ArrayList<>();
        listeners.addAll(ListenerHandler.getInstance().getListOfListeners());
        runner.setListenerClasses(listeners);
        runner.run();
        return "End";
    }
}
