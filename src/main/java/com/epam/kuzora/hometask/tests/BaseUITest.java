package com.epam.kuzora.hometask.tests;

import com.epam.kuzora.hometask.core.driver.DriverFactory;
import com.epam.kuzora.hometask.tests.common.constant.TestConstant.DriverProps;
import com.epam.kuzora.hometask.tests.common.pageobject.model.PageGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseUITest extends BaseTest {
    protected WebDriver driver;
    protected PageGenerator page;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        driver = DriverFactory.getInstance().getChromeDriver();
        driver.manage().timeouts().implicitlyWait(DriverProps.MAX_LATENCY, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        page = new PageGenerator(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        driver = null;
    }
}
