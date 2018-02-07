package com.epam.kuzora.hometask.core.driver.impl;

import com.epam.kuzora.hometask.core.driver.ifaces.PhantomJSDriverInterface;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidDriverImpl implements PhantomJSDriverInterface {
    private static RemoteWebDriver instance;

    private AndroidDriverImpl() {
    }

    public static RemoteWebDriver getInstance() {
        if (instance == null) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("device", "Android");
                capabilities.setCapability("deviceName", "Android");
                capabilities.setCapability("platformName", "Android");
                capabilities.setBrowserName("Chrome");
//                capabilities.setCapability("autoWebview", true);
                instance = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
            }
        }
        return instance;
    }

//    public static RemoteWebDriver getInstance(BrowserVersion browserVersion) {
//        if (instance == null) {
//            instance = new HtmlUnitDriver(browserVersion);
//        }
//        return instance;
//    }
}
