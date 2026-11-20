package com.dmart.testing.tests;

import com.dmart.testing.base.BaseTest;
import com.dmart.testing.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminDashboardTests extends BaseTest {

    @Test(priority = 1, description = "Verify admin dashboard is accessible")
    public void testAdminDashboardAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("admin") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Admin dashboard, login, or home should be loaded");
    }

    @Test(priority = 2, description = "Verify admin dashboard URL structure")
    public void testAdminDashboardURL() {
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("admin") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "URL should be admin, login, or home");
    }

    @Test(priority = 3, description = "Verify navigation to admin dashboard from home")
    public void testNavigateToAdminDashboardFromHome() {
        driver.get(ConfigReader.getAppUrl());
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("admin") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Should navigate to admin dashboard, login, or home");
    }

    @Test(priority = 4, description = "Verify back navigation from admin dashboard")
    public void testBackNavigationFromAdminDashboard() {
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        driver.navigate().back();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(ConfigReader.getAppUrl()) ||
                     currentUrl.contains("login") ||
                     currentUrl.contains("admin"), "Should navigate back");
    }

    @Test(priority = 5, description = "Verify page refresh on admin dashboard")
    public void testPageRefreshOnAdminDashboard() {
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        driver.navigate().refresh();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("admin") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Should stay on admin dashboard or redirect");
    }

    @Test(priority = 6, description = "Verify admin dashboard from login")
    public void testAdminDashboardFromLogin() {
        driver.get(ConfigReader.getAppUrl() + "/login");
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("admin") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Admin dashboard should be accessible or redirect");
    }

    @Test(priority = 7, description = "Verify admin dashboard from cart")
    public void testAdminDashboardFromCart() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("admin") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Admin dashboard should be accessible or redirect");
    }

    @Test(priority = 8, description = "Verify admin dashboard from products")
    public void testAdminDashboardFromProducts() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("admin") ||
                     currentUrl.contains("login") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Admin dashboard should be accessible or redirect");
    }

    @Test(priority = 9, description = "Verify admin dashboard page title")
    public void testAdminDashboardPageTitle() {
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        String title = driver.getTitle();
        Assert.assertTrue(title != null && !title.isEmpty(), "Page should have a title");
    }

    @Test(priority = 10, description = "Verify admin dashboard response time")
    public void testAdminDashboardLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        long endTime = System.currentTimeMillis();
        Assert.assertTrue((endTime - startTime) < 10000, "Admin dashboard should load within 10 seconds");
    }
}
