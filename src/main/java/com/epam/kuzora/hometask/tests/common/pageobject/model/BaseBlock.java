package com.epam.kuzora.hometask.tests.common.pageobject.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseBlock extends PageGenerator {
    public WebDriverWait wait = new WebDriverWait(this.driver, 20);

    public BaseBlock(WebDriver driver) {
        super(driver);
    }
}
