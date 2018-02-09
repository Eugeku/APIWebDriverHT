package com.epam.kuzora.hometask.core.driver;

import com.epam.kuzora.hometask.core.constant.Constants.Driver;
import com.epam.kuzora.hometask.core.driver.impl.ChromeDriverImpl;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static final DriverFactory instance = new DriverFactory();

    private DriverFactory() {
    }

    public static DriverFactory getInstance() {
        return instance;
    }

    /*
    not yet implemented inside

    public ChromeDriver getChromeDriver() {
        return ChromeDriverImpl.getInstance();
    }

    public FirefoxDriver getFirefoxDriver() {
        return FireFoxDriverImpl.getInstance();
    }

    public InternetExplorerDriver getInternetExplorerDriver() {
        return InternetExplorerDriverImpl.getInstance();
    }

    public SafariDriver getSafariDriver() {
        return SafariDriverImpl.getInstance();
    }


    public HtmlUnitDriver getHtmlUnitDriver() {
        return HTMLUnitDriverImpl.getInstance();
    }

    public HtmlUnitDriver getHtmlUnitDriver(BrowserVersion browserVersion) {
        return HTMLUnitDriverImpl.getInstance(browserVersion);
    }

    public RemoteWebDriver getAndroidRemoteDriver() {
        return AndroidDriverImpl.getInstance();
    }
    */

    public WebDriver getChromeDriver() {
        String pathToChromeDriver;
        String os = System.getProperty(Driver.OS_NAME).toLowerCase();
        if (os.contains(Driver.OS_TYPE)) {
            pathToChromeDriver = System.getProperty(Driver.USER_DIR) + Driver.CHROME_DRIVER_NAME_MAC;
        } else {
            pathToChromeDriver = System.getProperty(Driver.USER_DIR) + Driver.CHROME_DRIVER_NAME_WIN;
        }
        ChromeDriverImpl chromeDriver = new ChromeDriverImpl();
        return chromeDriver.getInstance(pathToChromeDriver);
    }
}
