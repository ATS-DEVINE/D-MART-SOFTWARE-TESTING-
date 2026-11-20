package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    protected void click(WebElement element) {
        try {
            if (element != null) {
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
            }
        } catch (Exception e) {
            System.out.println("Element click failed: " + e.getMessage());
        }
    }

    protected void sendKeys(WebElement element, String text) {
        try {
            if (element != null) {
                wait.until(ExpectedConditions.visibilityOf(element));
                element.clear();
                element.sendKeys(text);
            }
        } catch (Exception e) {
            System.out.println("Send keys failed: " + e.getMessage());
        }
    }

    protected String getText(WebElement element) {
        try {
            if (element != null) {
                wait.until(ExpectedConditions.visibilityOf(element));
                return element.getText();
            }
        } catch (Exception e) {
            System.out.println("Get text failed: " + e.getMessage());
        }
        return "";
    }

    protected boolean isDisplayed(WebElement element) {
        try {
            if (element != null) {
                wait.until(ExpectedConditions.visibilityOf(element));
                return element.isDisplayed();
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    protected boolean isEnabled(WebElement element) {
        try {
            if (element != null) {
                return element.isEnabled();
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    protected void waitForPageLoad() {
        try {
            wait.until(webDriver -> org.openqa.selenium.support.ui.ExpectedConditions.jsReturnsValue(
                    "return document.readyState === 'complete'"
            ).apply(webDriver) != null);
        } catch (Exception e) {
            System.out.println("Page load wait failed: " + e.getMessage());
        }
    }

    protected void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
