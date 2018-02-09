package com.epam.kuzora.hometask.tests.common.pageobject.litres.blocks;

import com.epam.kuzora.hometask.tests.common.pageobject.model.BaseBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ContentBlock extends BaseBlock {
    @FindBy(xpath = "//div[@class='art-item__info']")
    private List<WebElement> books;
    @FindBy(xpath = "//span[contains(@class, \"simple-price\")]")
    private List<WebElement> prices;

    public ContentBlock(WebDriver driver) {
        super(driver);
    }

    public double findMaxBookPrice() {
        double maxPrice = 0;
        for (WebElement price : prices) {
            String p = price.getAttribute("textContent");
            p = p.replaceAll("[^0-9,.]+", "").replaceFirst(",", ".");
            double ip = Double.parseDouble(p);
            if (ip > maxPrice) {
                maxPrice = ip;
            }
        }
        return maxPrice;
    }

    public String nameOfBookByPrice(double price) {
        for (WebElement book : books) {
            String outerText = book.getAttribute("outerText");
            String priceInString = outerText.split("\n")[3].replaceAll("[^0-9,.]+", "").replaceFirst(",", ".");
            double p = Double.parseDouble(priceInString);
            if (price == p) {
                return outerText.split("\n")[0];
            }
        }
        return "";
    }

    public List<String> getListOfBooksFromContent() {
        List<String> listBooks = new ArrayList<>();
        for (WebElement book : books) {
            String outerText = book.getAttribute("outerText");
            listBooks.add(outerText.split("\n")[0]);
        }
        return listBooks;
    }
}
