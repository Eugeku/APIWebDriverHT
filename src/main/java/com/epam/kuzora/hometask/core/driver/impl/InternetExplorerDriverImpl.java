package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.InternetExplorerDriverInterface;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorerDriverImpl implements InternetExplorerDriverInterface {
    private InternetExplorerDriver instance = new InternetExplorerDriver();

    public InternetExplorerDriverImpl() {
    }

    public InternetExplorerDriver getInstance() {
        return instance;
    }
}
