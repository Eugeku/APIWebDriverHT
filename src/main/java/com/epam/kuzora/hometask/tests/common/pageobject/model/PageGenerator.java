package com.epam.kuzora.hometask.tests.common.pageobject.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {
    public WebDriver driver;

    public PageGenerator(WebDriver driver) {
        this.driver = driver;
    }

    public <TPage extends BasePage> TPage getPageInstance(Class<TPage> pageClass) {
        try {
            return PageFactory.initElements(driver, pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public <TPage extends BaseBlock> TPage getBlockInstance(Class<TPage> pageBlocks) {
        try {
            return PageFactory.initElements(driver, pageBlocks);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
