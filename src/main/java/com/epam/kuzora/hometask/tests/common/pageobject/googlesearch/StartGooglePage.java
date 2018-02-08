package com.epam.kuzora.hometask.tests.common.pageobject.googlesearch;

import com.epam.kuzora.hometask.tests.common.pageobject.model.BasePage;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartGooglePage extends BasePage {
    @FindBy(xpath = "//div[2]/div/input")
    private WebElement fieldForInput;

    @FindBy(name = "btnK")
    private WebElement buttonConfirmName;

    public StartGooglePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isItStartPageOfGoogle() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(buttonConfirmName));
            buttonConfirmName.isDisplayed();
            return true;
        } catch (TimeoutException ec) {
            System.out.println("Жопа!!");
            return false;
        }
    }

    public StartGooglePage setSearchFieldAndClick(String searchName) {
        fieldForInput.clear();
        fieldForInput.sendKeys(searchName);
        buttonConfirmName.click();
        return this;
    }
}
