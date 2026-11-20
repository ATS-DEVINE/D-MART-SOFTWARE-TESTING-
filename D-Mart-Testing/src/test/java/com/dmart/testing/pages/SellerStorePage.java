package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SellerStorePage extends BasePage {
    public SellerStorePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(@class,'store-name')]")
    private WebElement storeName;

    @FindBy(xpath = "//div[contains(@class,'store-description')]")
    private WebElement storeDescription;

    @FindBy(xpath = "//div[contains(@class,'product-card')]")
    private List<WebElement> productCards;

    @FindBy(xpath = "//div[contains(@class,'product-card')]//a[contains(@href,'/products/')]")
    private List<WebElement> productLinks;

    @FindBy(xpath = "//span[contains(@class,'rating')]")
    private WebElement sellerRating;

    @FindBy(xpath = "//div[contains(@class,'status')]")
    private WebElement sellerStatus;

    public boolean isSellerStorePageLoaded() {
        return isDisplayed(storeName);
    }

    public String getStoreName() {
        return getText(storeName);
    }

    public String getStoreDescription() {
        return getText(storeDescription);
    }

    public int getProductCount() {
        return productCards.size();
    }

    public void clickProduct(int index) {
        if (index < productLinks.size()) {
            click(productLinks.get(index));
        }
    }

    public String getSellerRating() {
        return getText(sellerRating);
    }

    public String getSellerStatus() {
        return getText(sellerStatus);
    }
}
