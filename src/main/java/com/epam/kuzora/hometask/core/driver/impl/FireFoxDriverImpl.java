package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.FireFoxDriverInterface;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverImpl implements FireFoxDriverInterface {
    private FirefoxDriver instance = new FirefoxDriver();

    public FireFoxDriverImpl() {
    }

    public FirefoxDriver getInstance() {
        return instance;
    }
}
