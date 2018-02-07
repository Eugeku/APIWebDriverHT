package com.epam.kuzora.hometask.tests.common.pageobject.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {
    public WebDriver driver;

    public PageGenerator(WebDriver driver) {
        this.driver = driver;
    }

    public <TPage extends BasePage> TPage GetInstance(Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
