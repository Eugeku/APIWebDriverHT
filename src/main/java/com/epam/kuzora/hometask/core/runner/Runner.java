package com.epam.kuzora.hometask.core.runner;

import com.epam.kuzora.hometask.core.constant.Constants;
import com.epam.kuzora.hometask.core.runner.runner_core.CommandParser;
import com.epam.kuzora.hometask.core.runner.runner_core.browser.exception.BrowserException;
import com.epam.kuzora.hometask.core.runner.runner_core.command.CommandProvider;
import com.epam.kuzora.hometask.core.runner.runner_core.command.Ifaces.Command;
import com.epam.kuzora.hometask.core.runner.runner_core.command.exception.CommandException;
import com.epam.kuzora.hometask.core.runner.runner_core.command.impl.RunnerInfo;

import java.util.ArrayList;

public class Runner {
    public static void main(String[] args) {
        /*
        Run with jar file:
            java -Dfile.encoding=UTF-8 -jar
            /Users/yauhen_kuzora/Projects/APIWebDriverHT/target/APIWebDriverHT-1.0-SNAPSHOT.jar
            "CLASS_TEST|FIREFOX_52|WebBrowserGoogleTest"
            java -Dfile.encoding=UTF-8 -jar
            /Users/yauhen_kuzora/Projects/APIWebDriverHT/target/APIWebDriverHT-1.0-SNAPSHOT.jar
            "XML_SUITE|FIREFOX_52|src/main/resources/SeleniumWebServer.xml"
        Run class file:
            "XML_SUITE|FIREFOX_52|src/main/resources/SeleniumWebServer.xml";
            "CLASS_TEST|FIREFOX_52|APIGetBookMethodTest"
        */
        try {
            System.out.println(run(args[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object run(String request) throws CommandException, BrowserException {
        String commandName;
        String browserVersionName;
        Command executionCommand;
        ArrayList<String> requestAfterParse = CommandParser.getInstance().parse(request);
        if (requestAfterParse.size() <= Constants.Runner.MINIMAL_COUNT_OF_PARAM_IN_REQUEST) {
            return new RunnerInfo().runCommand(request);
        }
        commandName = requestAfterParse.get(0);
        //        browserVersionName = requestAfterParse.get(1);
        //        BrowserVersion browserVersion = BrowserProvider.getInstance().getBrowser(browserVersionName);
        //        WebDriver webBrowser = DriverFactory.getInstance().getHtmlUnitDriver(browserVersion);
        //        WebBrowserGoogleTest.setDriver(webBrowser);
        //        BrowserVersion browserVersion = BrowserProvider.getInstance().getBrowser(browserVersionName);
        //        WebDriver webBrowser = DriverFactory.getInstance().getChromeDriver();
        //        BaseTest.setDriver(webBrowser);
        requestAfterParse.remove(0);
        requestAfterParse.remove(0);
        executionCommand = CommandProvider.getInstance().getCommand(commandName);
        String[] stringsArray = new String[requestAfterParse.size()];
        stringsArray = requestAfterParse.toArray(stringsArray);
        Object resultOfExecuting = executionCommand.runCommand(stringsArray);
        return resultOfExecuting;
    }
}
