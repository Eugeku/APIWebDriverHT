package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.HTMLUnitDriverInterface;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverImpl implements HTMLUnitDriverInterface {
    private HtmlUnitDriver instance;

    public HTMLUnitDriverImpl() {
    }

    public HtmlUnitDriver getInstance() {
        if (instance == null) {
            instance = new HtmlUnitDriver();
        }
        return instance;
    }

    public HtmlUnitDriver getInstance(BrowserVersion browserVersion) {
        if (instance == null) {
            instance = new HtmlUnitDriver(browserVersion);
        }
        return instance;
    }
}
