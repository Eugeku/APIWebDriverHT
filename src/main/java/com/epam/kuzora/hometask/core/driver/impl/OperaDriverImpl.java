package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.OperaDriverInterface;
import org.openqa.selenium.opera.OperaDriver;

public class OperaDriverImpl implements OperaDriverInterface {
    private static final OperaDriver instance = new OperaDriver();

    private OperaDriverImpl() {
    }

    public static OperaDriver getInstance() {
        return instance;
    }
}
