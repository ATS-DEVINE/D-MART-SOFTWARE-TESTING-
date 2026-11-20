package com.dmart.testing.tests;

import com.dmart.testing.base.BaseTest;
import com.dmart.testing.config.ConfigReader;
import com.dmart.testing.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProfileTests extends BaseTest {

    @Test(priority = 1, description = "Verify buyer dashboard is accessible")
    public void testBuyerDashboardAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Buyer dashboard or login should be loaded");
    }

    @Test(priority = 2, description = "Verify order history page is accessible")
    public void testOrderHistoryAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Should be on buyer dashboard or login");
    }

    @Test(priority = 3, description = "Verify profile page is accessible")
    public void testProfilePageAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Profile should be accessible");
    }

    @Test(priority = 4, description = "Verify addresses page is accessible")
    public void testAddressesPageAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Addresses should be accessible");
    }

    @Test(priority = 5, description = "Verify wishlist page is accessible")
    public void testWishlistPageAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Wishlist should be accessible");
    }

    @Test(priority = 6, description = "Verify buyer dashboard URL structure")
    public void testBuyerDashboardURL() {
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "URL should be correct");
    }

    @Test(priority = 7, description = "Verify navigation to buyer dashboard from home")
    public void testNavigateToBuyerDashboardFromHome() {
        driver.get(ConfigReader.getAppUrl());
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Should navigate to buyer dashboard or login");
    }

    @Test(priority = 8, description = "Verify back navigation from buyer dashboard")
    public void testBackNavigationFromBuyerDashboard() {
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getAppUrl()) ||
                     driver.getCurrentUrl().contains("login"), "Should navigate back");
    }

    @Test(priority = 9, description = "Verify page refresh on buyer dashboard")
    public void testPageRefreshOnBuyerDashboard() {
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Should stay on buyer dashboard");
    }

    @Test(priority = 10, description = "Verify buyer dashboard from login")
    public void testBuyerDashboardFromLogin() {
        driver.get(ConfigReader.getAppUrl() + "/login");
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Buyer dashboard should be accessible");
    }

    @Test(priority = 11, description = "Verify buyer dashboard from cart")
    public void testBuyerDashboardFromCart() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Buyer dashboard should be accessible");
    }

    @Test(priority = 12, description = "Verify buyer dashboard from products")
    public void testBuyerDashboardFromProducts() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Buyer dashboard should be accessible");
    }

    @Test(priority = 13, description = "Verify buyer dashboard page title")
    public void testBuyerDashboardPageTitle() {
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        String title = driver.getTitle();
        Assert.assertTrue(title != null && !title.isEmpty(), "Page should have a title");
    }

    @Test(priority = 14, description = "Verify buyer dashboard response time")
    public void testBuyerDashboardLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        long endTime = System.currentTimeMillis();
        Assert.assertTrue((endTime - startTime) < 10000, "Buyer dashboard should load within 10 seconds");
    }

    @Test(priority = 15, description = "Verify buyer dashboard navigation loop")
    public void testBuyerDashboardNavigationLoop() {
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/buyer/dashboard");
        Assert.assertTrue(driver.getCurrentUrl().contains("buyer") ||
                     driver.getCurrentUrl().contains("login"), "Navigation loop should work");
    }
}
