package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.InternetExplorerDriverInterface;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerDriverImpl implements InternetExplorerDriverInterface {
    private static final InternetExplorerDriver instance = new InternetExplorerDriver();

    private InternetExplorerDriverImpl() {
    }

    public static InternetExplorerDriver getInstance() {
        return instance;
    }
}
