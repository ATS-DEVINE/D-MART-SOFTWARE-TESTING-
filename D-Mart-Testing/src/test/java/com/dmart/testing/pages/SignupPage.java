package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage extends BasePage {
    public SignupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='email' or @name='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@type='password' or @name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@name='confirmPassword' or @type='password']")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[@name='fullName' or @placeholder='Full Name']")
    private WebElement fullNameInput;

    @FindBy(xpath = "//input[@name='phone' or @placeholder='Phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//select[@name='role']")
    private WebElement roleSelect;

    @FindBy(xpath = "//button[contains(text(),'Sign Up') or contains(text(),'Register')]")
    private WebElement signupButton;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement loginLink;

    @FindBy(xpath = "//h2[contains(text(),'Sign Up') or contains(text(),'Register')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(text(),'already exists') or contains(text(),'error')]")
    private WebElement errorMessage;

    public boolean isSignupPageLoaded() {
        try {
            // Check URL first as it's more reliable
            if (driver.getCurrentUrl().contains("signup")) {
                return true;
            }
            // Then try to find page title element
            return pageTitle != null && pageTitle.isDisplayed();
        } catch (Exception e) {
            return driver.getCurrentUrl().contains("signup");
        }
    }

    public void signup(String email, String password, String fullName, String phone, String role) {
        sendKeys(emailInput, email);
        sendKeys(passwordInput, password);
        sendKeys(confirmPasswordInput, password);
        sendKeys(fullNameInput, fullName);
        sendKeys(phoneInput, phone);
        if (role != null && !role.isEmpty()) {
            roleSelect.sendKeys(role);
        }
        click(signupButton);
    }

    public void clickLogin() {
        click(loginLink);
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }

    public String getErrorMessage() {
        return getText(errorMessage);
    }
}
