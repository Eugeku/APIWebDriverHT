package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.SafariDriverInterface;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverImpl implements SafariDriverInterface {
    private static final SafariDriver instance = new SafariDriver();

    private SafariDriverImpl() {
    }

    public static SafariDriver getInstance() {
        return instance;
    }
}
