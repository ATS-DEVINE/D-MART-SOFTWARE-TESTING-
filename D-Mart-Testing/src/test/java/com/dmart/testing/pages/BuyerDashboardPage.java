package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BuyerDashboardPage extends BasePage {
    public BuyerDashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Dashboard') or contains(text(),'My Account')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[contains(text(),'Orders') or contains(@href,'orders')]")
    private WebElement ordersLink;

    @FindBy(xpath = "//a[contains(text(),'Profile') or contains(@href,'profile')]")
    private WebElement profileLink;

    @FindBy(xpath = "//a[contains(text(),'Addresses') or contains(@href,'addresses')]")
    private WebElement addressesLink;

    @FindBy(xpath = "//a[contains(text(),'Wishlist') or contains(@href,'wishlist')]")
    private WebElement wishlistLink;

    @FindBy(xpath = "//div[contains(@class,'order-card')]")
    private List<WebElement> orderCards;

    @FindBy(xpath = "//button[contains(text(),'Logout') or contains(@class,'logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//input[@name='fullName']")
    private WebElement fullNameInput;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[contains(text(),'Save') or contains(text(),'Update')]")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(@class,'wishlist-item')]")
    private List<WebElement> wishlistItems;

    public boolean isBuyerDashboardLoaded() {
        return isDisplayed(pageTitle);
    }

    public void clickOrders() {
        click(ordersLink);
    }

    public void clickProfile() {
        click(profileLink);
    }

    public void clickAddresses() {
        click(addressesLink);
    }

    public void clickWishlist() {
        click(wishlistLink);
    }

    public void logout() {
        click(logoutButton);
    }

    public int getOrderCount() {
        return orderCards.size();
    }

    public void updateProfile(String fullName, String phone) {
        sendKeys(fullNameInput, fullName);
        sendKeys(phoneInput, phone);
        click(saveButton);
    }

    public int getWishlistCount() {
        return wishlistItems.size();
    }
}
