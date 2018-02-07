package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.FireFoxDriverInterface;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverImpl implements FireFoxDriverInterface {
    private static final FirefoxDriver instance = new FirefoxDriver();

    private FireFoxDriverImpl() {
    }

    public static FirefoxDriver getInstance() {
        return instance;
    }
}
