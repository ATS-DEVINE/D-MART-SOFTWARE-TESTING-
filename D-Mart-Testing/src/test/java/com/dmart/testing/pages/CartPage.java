package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Cart') or contains(text(),'Shopping Cart')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(@class,'cart-item')]")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//button[contains(text(),'Checkout') or contains(@class,'checkout')]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//button[contains(text(),'Remove') or contains(@class,'remove')]")
    private List<WebElement> removeButtons;

    @FindBy(xpath = "//input[@type='number' or contains(@class,'quantity')]")
    private List<WebElement> quantityInputs;

    @FindBy(xpath = "//span[contains(@class,'total') or contains(text(),'Total')]")
    private WebElement cartTotal;

    @FindBy(xpath = "//div[contains(text(),'Your cart is empty') or contains(text(),'No items')]")
    private WebElement emptyCartMessage;

    @FindBy(xpath = "//button[contains(text(),'Continue Shopping')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[contains(@class,'seller-group')]")
    private List<WebElement> sellerGroups;

    public boolean isCartPageLoaded() {
        try {
            if (driver.getCurrentUrl().contains("cart")) {
                return true;
            }
            return pageTitle != null && pageTitle.isDisplayed();
        } catch (Exception e) {
            return driver.getCurrentUrl().contains("cart");
        }
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public boolean isCartEmpty() {
        return isDisplayed(emptyCartMessage);
    }

    public void clickCheckout() {
        click(checkoutButton);
    }

    public void removeItem(int index) {
        if (index < removeButtons.size()) {
            click(removeButtons.get(index));
        }
    }

    public void updateQuantity(int index, int quantity) {
        if (index < quantityInputs.size()) {
            WebElement input = quantityInputs.get(index);
            input.clear();
            input.sendKeys(String.valueOf(quantity));
        }
    }

    public String getCartTotal() {
        return getText(cartTotal);
    }

    public void clickContinueShopping() {
        click(continueShoppingButton);
    }

    public int getSellerGroupCount() {
        return sellerGroups.size();
    }
}
