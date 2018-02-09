package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.SafariDriverInterface;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverImpl implements SafariDriverInterface {
    private SafariDriver instance = new SafariDriver();

    public SafariDriverImpl() {
    }

    public SafariDriver getInstance() {
        return instance;
    }
}
