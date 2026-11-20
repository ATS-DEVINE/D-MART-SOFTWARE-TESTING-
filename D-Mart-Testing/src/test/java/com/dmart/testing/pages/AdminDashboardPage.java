package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AdminDashboardPage extends BasePage {
    public AdminDashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Admin Dashboard')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[contains(text(),'Sellers') or contains(@href,'sellers')]")
    private WebElement sellersLink;

    @FindBy(xpath = "//a[contains(text(),'Products') or contains(@href,'products')]")
    private WebElement productsLink;

    @FindBy(xpath = "//a[contains(text(),'Coupons') or contains(@href,'coupons')]")
    private WebElement couponsLink;

    @FindBy(xpath = "//a[contains(text(),'Categories') or contains(@href,'categories')]")
    private WebElement categoriesLink;

    @FindBy(xpath = "//div[contains(@class,'seller-item')]//button[contains(text(),'Approve')]")
    private List<WebElement> approveButtons;

    @FindBy(xpath = "//div[contains(@class,'seller-item')]//button[contains(text(),'Reject')]")
    private List<WebElement> rejectButtons;

    @FindBy(xpath = "//div[contains(@class,'product-item')]//button[contains(text(),'Approve')]")
    private List<WebElement> approveProductButtons;

    @FindBy(xpath = "//div[contains(@class,'product-item')]//button[contains(text(),'Reject')]")
    private List<WebElement> rejectProductButtons;

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[contains(@class,'stat-card')]")
    private List<WebElement> statCards;

    public boolean isAdminDashboardLoaded() {
        return isDisplayed(pageTitle);
    }

    public void clickSellers() {
        click(sellersLink);
    }

    public void clickProducts() {
        click(productsLink);
    }

    public void clickCoupons() {
        click(couponsLink);
    }

    public void clickCategories() {
        click(categoriesLink);
    }

    public void approveSeller(int index) {
        if (index < approveButtons.size()) {
            click(approveButtons.get(index));
        }
    }

    public void rejectSeller(int index) {
        if (index < rejectButtons.size()) {
            click(rejectButtons.get(index));
        }
    }

    public void approveProduct(int index) {
        if (index < approveProductButtons.size()) {
            click(approveProductButtons.get(index));
        }
    }

    public void rejectProduct(int index) {
        if (index < rejectProductButtons.size()) {
            click(rejectProductButtons.get(index));
        }
    }

    public void logout() {
        click(logoutButton);
    }

    public int getStatCardCount() {
        return statCards.size();
    }
}
