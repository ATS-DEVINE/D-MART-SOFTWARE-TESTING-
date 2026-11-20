package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SellersPage extends BasePage {
    public SellersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Sellers')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(@class,'seller-card')]")
    private List<WebElement> sellerCards;

    @FindBy(xpath = "//div[contains(@class,'seller-card')]//a[contains(@href,'/sellers/')]")
    private List<WebElement> sellerLinks;

    @FindBy(xpath = "//input[@placeholder='Search sellers']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(text(),'No sellers')]")
    private WebElement noSellersMessage;

    public boolean isSellersPageLoaded() {
        return isDisplayed(pageTitle);
    }

    public int getSellerCount() {
        return sellerCards.size();
    }

    public void clickSeller(int index) {
        if (index < sellerLinks.size()) {
            click(sellerLinks.get(index));
        }
    }

    public void searchSeller(String sellerName) {
        sendKeys(searchInput, sellerName);
        click(searchButton);
    }

    public boolean hasSellers() {
        return !sellerCards.isEmpty();
    }
}
