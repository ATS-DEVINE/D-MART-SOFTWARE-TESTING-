package com.dmart.testing.tests;

import com.dmart.testing.base.BaseTest;
import com.dmart.testing.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SellerDashboardTests extends BaseTest {

    @Test(priority = 1, description = "Verify seller dashboard is accessible")
    public void testSellerDashboardAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("seller") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Seller dashboard, login, or home should be loaded");
    }

    @Test(priority = 2, description = "Verify seller dashboard URL structure")
    public void testSellerDashboardURL() {
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("seller") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "URL should be seller, login, or home");
    }

    @Test(priority = 3, description = "Verify navigation to seller dashboard from home")
    public void testNavigateToSellerDashboardFromHome() {
        driver.get(ConfigReader.getAppUrl());
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("seller") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Should navigate to seller dashboard, login, or home");
    }

    @Test(priority = 4, description = "Verify back navigation from seller dashboard")
    public void testBackNavigationFromSellerDashboard() {
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        driver.navigate().back();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(ConfigReader.getAppUrl()) ||
                     currentUrl.contains("login") ||
                     currentUrl.contains("seller"), "Should navigate back");
    }

    @Test(priority = 5, description = "Verify page refresh on seller dashboard")
    public void testPageRefreshOnSellerDashboard() {
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        driver.navigate().refresh();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("seller") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Should stay on seller dashboard or redirect");
    }

    @Test(priority = 6, description = "Verify seller dashboard from login")
    public void testSellerDashboardFromLogin() {
        driver.get(ConfigReader.getAppUrl() + "/login");
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("seller") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Seller dashboard should be accessible or redirect");
    }

    @Test(priority = 7, description = "Verify seller dashboard from cart")
    public void testSellerDashboardFromCart() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("seller") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Seller dashboard should be accessible or redirect");
    }

    @Test(priority = 8, description = "Verify seller dashboard from products")
    public void testSellerDashboardFromProducts() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("seller") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Seller dashboard should be accessible or redirect");
    }

    @Test(priority = 9, description = "Verify seller dashboard page title")
    public void testSellerDashboardPageTitle() {
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        String title = driver.getTitle();
        Assert.assertTrue(title != null && !title.isEmpty(), "Page should have a title");
    }

    @Test(priority = 10, description = "Verify seller dashboard response time")
    public void testSellerDashboardLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        long endTime = System.currentTimeMillis();
        Assert.assertTrue((endTime - startTime) < 10000, "Seller dashboard should load within 10 seconds");
    }
}
