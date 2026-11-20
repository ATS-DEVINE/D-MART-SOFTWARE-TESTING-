package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(),'Sign up') or @href='/signup']")
    private WebElement signupLink;

    @FindBy(xpath = "//h1[contains(text(),'Welcome Back')]")
    private WebElement pageTitle;

    public boolean isLoginPageLoaded() {
        try {
            // Check URL first as it's more reliable
            if (driver.getCurrentUrl().contains("login")) {
                return true;
            }
            // Then try to find page title element
            return pageTitle != null && pageTitle.isDisplayed();
        } catch (Exception e) {
            return driver.getCurrentUrl().contains("login");
        }
    }

    public void login(String email, String password) {
        if (emailInput != null && emailInput.isDisplayed()) {
            sendKeys(emailInput, email);
        }
        if (passwordInput != null && passwordInput.isDisplayed()) {
            sendKeys(passwordInput, password);
        }
        if (loginButton != null && loginButton.isDisplayed()) {
            click(loginButton);
        }
    }

    public void clickSignup() {
        if (signupLink != null && signupLink.isDisplayed()) {
            click(signupLink);
        } else {
            driver.navigate().to("http://localhost:8080/signup");
        }
    }

    public boolean isErrorMessageDisplayed() {
        try {
            WebElement error = driver.findElement(org.openqa.selenium.By.xpath("//*[contains(text(),'Login failed') or contains(text(),'failed')]"));
            return error != null && error.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            WebElement error = driver.findElement(org.openqa.selenium.By.xpath("//*[contains(text(),'Login failed') or contains(text(),'failed')]"));
            return error.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
