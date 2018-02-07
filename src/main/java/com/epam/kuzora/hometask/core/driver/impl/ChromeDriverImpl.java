package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.ChromeDriverInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverImpl implements ChromeDriverInterface {
    private static ChromeDriver instance;

    private ChromeDriverImpl() {
    }

    public static WebDriver getInstance(String pathToChromeDriver) {
        if (instance == null) {
            instance = new ChromeDriver();
            System.setProperty("webdriver.chrome.driver", pathToChromeDriver);
        }
        return instance;
    }
}
