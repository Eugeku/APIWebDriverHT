package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.constant.Constants.Driver;
import com.epam.kuzora.hometask.core.driver.ifaces.ChromeDriverInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverImpl implements ChromeDriverInterface {
    private static ChromeDriver instance;

    private ChromeDriverImpl() {
    }

    public static WebDriver getInstance(String pathToChromeDriver) {
        if (instance == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(Driver.ChromeOption.TEST_TYPE);
            options.addArguments(Driver.ChromeOption.DISABLE_POPUP_BLOCKING);
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            instance = new ChromeDriver(capabilities);
            System.setProperty(Driver.WEBDR_CHROME_DRIVER, pathToChromeDriver);
        }
        return instance;
    }
}
