package com.epam.kuzora.hometask.tests.common.pageobject.litres.blocks;

import com.epam.kuzora.hometask.core.util.Logger;
import com.epam.kuzora.hometask.tests.common.pageobject.model.BaseBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderMenuBlock extends BaseBlock {
    @FindBy(xpath = "//li[@class = \"header_menu_item\"]/a[contains(@href,\"/novie/\")]")
    private WebElement novieTab;
    @FindBy(xpath = "//li[@class = \"header_menu_item\"]/a[contains(@href, \"/luchshie-knigi\")]")
    private WebElement lucshieTab;

    public HeaderMenuBlock(WebDriver driver) {
        super(driver);
    }

    public HeaderMenuBlock clickOnNewContentTab() {
        Logger.logInConsole("Click on new tab");
        wait.until(ExpectedConditions.elementToBeClickable(novieTab));
        novieTab.click();
        return this;
    }

    public HeaderMenuBlock clickOnBestContentTab() {
        Logger.logInConsole("Click on best tab");
        wait.until(ExpectedConditions.elementToBeClickable(lucshieTab));
        lucshieTab.click();
        return this;
    }
}
