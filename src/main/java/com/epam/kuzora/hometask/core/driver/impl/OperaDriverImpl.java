package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.OperaDriverInterface;
import org.openqa.selenium.opera.OperaDriver;

public class OperaDriverImpl implements OperaDriverInterface {
    private OperaDriver instance = new OperaDriver();

    public OperaDriverImpl() {
    }

    public OperaDriver getInstance() {
        return instance;
    }
}
