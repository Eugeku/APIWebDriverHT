package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.HTMLUnitDriverInterface;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverImpl implements HTMLUnitDriverInterface {
    private static HtmlUnitDriver instance;

    private HTMLUnitDriverImpl() {
    }

    public static HtmlUnitDriver getInstance() {
        if (instance == null) {
            instance = new HtmlUnitDriver();
        }
        return instance;
    }

    public static HtmlUnitDriver getInstance(BrowserVersion browserVersion) {
        if (instance == null) {
            instance = new HtmlUnitDriver(browserVersion);
        }
        return instance;
    }
}
