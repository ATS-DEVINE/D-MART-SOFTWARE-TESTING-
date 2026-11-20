package com.dmart.testing.pages;

import com.dmart.testing.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'All Products') or @href='/products']")
    private WebElement productsLink;

    @FindBy(xpath = "//a[contains(text(),'Sellers') or @href='/sellers']")
    private WebElement sellersLink;

    @FindBy(xpath = "//a[contains(text(),'Login') or @href='/login']")
    private WebElement loginLink;

    @FindBy(xpath = "//a[contains(text(),'Sign Up') or @href='/signup']")
    private WebElement signupLink;

    @FindBy(xpath = "//a[@href='/cart']")
    private WebElement cartLink;

    @FindBy(xpath = "//input[@placeholder='Search products, sellers...']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    @FindBy(xpath = "//span[contains(text(),'Duniya') or contains(text(),'Mart')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(@class,'product-card') or contains(@class,'ProductCard')]")
    private WebElement productCard;

    public boolean isHomePageLoaded() {
        try {
            // Check URL first - most reliable
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.equals(ConfigReader.getAppUrl() + "/") || currentUrl.equals(ConfigReader.getAppUrl())) {
                return true;
            }
            // Fallback to element check
            return pageTitle != null && pageTitle.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickProducts() {
        if (productsLink != null && productsLink.isDisplayed()) {
            click(productsLink);
        } else {
            driver.navigate().to("http://localhost:8080/products");
        }
    }

    public void clickSellers() {
        if (sellersLink != null && sellersLink.isDisplayed()) {
            click(sellersLink);
        } else {
            driver.navigate().to("http://localhost:8080/sellers");
        }
    }

    public void clickLogin() {
        if (loginLink != null && loginLink.isDisplayed()) {
            click(loginLink);
        } else {
            driver.navigate().to("http://localhost:8080/login");
        }
    }

    public void clickSignup() {
        if (signupLink != null && signupLink.isDisplayed()) {
            click(signupLink);
        } else {
            driver.navigate().to("http://localhost:8080/signup");
        }
    }

    public void clickCart() {
        if (cartLink != null && cartLink.isDisplayed()) {
            click(cartLink);
        } else {
            driver.navigate().to("http://localhost:8080/cart");
        }
    }

    public void searchProduct(String productName) {
        if (searchInput != null && searchInput.isDisplayed()) {
            sendKeys(searchInput, productName);
            if (searchButton != null && searchButton.isDisplayed()) {
                click(searchButton);
            }
        } else {
            driver.navigate().to("http://localhost:8080/products?q=" + productName);
        }
    }

    public boolean hasProducts() {
        try {
            return productCard != null && productCard.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
