package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SellerDashboardPage extends BasePage {
    public SellerDashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Seller Dashboard')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//a[contains(text(),'Products') or contains(@href,'products')]")
    private WebElement productsLink;

    @FindBy(xpath = "//a[contains(text(),'Orders') or contains(@href,'orders')]")
    private WebElement ordersLink;

    @FindBy(xpath = "//a[contains(text(),'Settings') or contains(@href,'settings')]")
    private WebElement settingsLink;

    @FindBy(xpath = "//button[contains(text(),'Add Product') or contains(text(),'New Product')]")
    private WebElement addProductButton;

    @FindBy(xpath = "//div[contains(@class,'product-item')]")
    private List<WebElement> productItems;

    @FindBy(xpath = "//div[contains(@class,'order-item')]")
    private List<WebElement> orderItems;

    @FindBy(xpath = "//select[@name='orderStatus']")
    private WebElement orderStatusSelect;

    @FindBy(xpath = "//button[contains(text(),'Update Status')]")
    private WebElement updateStatusButton;

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    private WebElement logoutButton;

    @FindBy(xpath = "//div[contains(@class,'status')]")
    private WebElement storeStatus;

    public boolean isSellerDashboardLoaded() {
        return isDisplayed(pageTitle);
    }

    public void clickProducts() {
        click(productsLink);
    }

    public void clickOrders() {
        click(ordersLink);
    }

    public void clickSettings() {
        click(settingsLink);
    }

    public void clickAddProduct() {
        click(addProductButton);
    }

    public int getProductCount() {
        return productItems.size();
    }

    public int getOrderCount() {
        return orderItems.size();
    }

    public void updateOrderStatus(String status) {
        orderStatusSelect.sendKeys(status);
        click(updateStatusButton);
    }

    public void logout() {
        click(logoutButton);
    }

    public String getStoreStatus() {
        return getText(storeStatus);
    }
}
