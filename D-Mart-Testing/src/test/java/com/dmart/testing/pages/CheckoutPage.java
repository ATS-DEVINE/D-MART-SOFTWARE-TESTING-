package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//input[@name='fullName' or @placeholder='Full Name']")
    private WebElement fullNameInput;

    @FindBy(xpath = "//input[@name='phone' or @placeholder='Phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@name='address' or @placeholder='Address']")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@name='city' or @placeholder='City']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@name='zipCode' or @placeholder='Zip']")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//input[@name='coupon' or @placeholder='Coupon']")
    private WebElement couponInput;

    @FindBy(xpath = "//button[contains(text(),'Apply') or contains(@class,'apply-coupon')]")
    private WebElement applyCouponButton;

    @FindBy(xpath = "//button[contains(text(),'Place Order') or contains(text(),'Confirm Order')]")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//div[contains(@class,'address-list')]//button[contains(text(),'Select')]")
    private WebElement selectAddressButton;

    @FindBy(xpath = "//span[contains(@class,'order-total')]")
    private WebElement orderTotal;

    @FindBy(xpath = "//span[contains(@class,'discount')]")
    private WebElement discountAmount;

    @FindBy(xpath = "//div[contains(text(),'Coupon applied') or contains(text(),'Discount')]")
    private WebElement couponSuccessMessage;

    @FindBy(xpath = "//div[contains(text(),'Invalid coupon')]")
    private WebElement couponErrorMessage;

    @FindBy(xpath = "//select[@name='address']")
    private WebElement addressSelect;

    public boolean isCheckoutPageLoaded() {
        try {
            if (driver.getCurrentUrl().contains("checkout")) {
                return true;
            }
            return pageTitle != null && pageTitle.isDisplayed();
        } catch (Exception e) {
            return driver.getCurrentUrl().contains("checkout");
        }
    }

    public void enterShippingDetails(String fullName, String phone, String address, String city, String zipCode) {
        sendKeys(fullNameInput, fullName);
        sendKeys(phoneInput, phone);
        sendKeys(addressInput, address);
        sendKeys(cityInput, city);
        sendKeys(zipCodeInput, zipCode);
    }

    public void applyCoupon(String couponCode) {
        sendKeys(couponInput, couponCode);
        click(applyCouponButton);
    }

    public void selectAddress(int index) {
        addressSelect.sendKeys(String.valueOf(index));
    }

    public void placeOrder() {
        click(placeOrderButton);
    }

    public String getOrderTotal() {
        return getText(orderTotal);
    }

    public String getDiscountAmount() {
        return getText(discountAmount);
    }

    public boolean isCouponApplied() {
        return isDisplayed(couponSuccessMessage);
    }

    public boolean isCouponErrorDisplayed() {
        return isDisplayed(couponErrorMessage);
    }
}
