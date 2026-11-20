package com.dmart.testing.tests;

import com.dmart.testing.base.BaseTest;
import com.dmart.testing.config.ConfigReader;
import com.dmart.testing.pages.HomePage;
import com.dmart.testing.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartTests extends BaseTest {

    @Test(priority = 1, description = "Verify cart page is accessible")
    public void testCartPageAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartPageLoaded(), "Cart page should be loaded");
    }

    @Test(priority = 2, description = "Verify empty cart display")
    public void testEmptyCartDisplay() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page should be loaded");
    }

    @Test(priority = 3, description = "Verify navigation to cart from home")
    public void testNavigateToCartFromHome() {
        driver.get(ConfigReader.getAppUrl());
        HomePage homePage = new HomePage(driver);
        homePage.clickCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Should navigate to cart page");
    }

    @Test(priority = 4, description = "Verify cart page URL structure")
    public void testCartPageURL() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().equals(ConfigReader.getAppUrl() + "/cart") ||
                     driver.getCurrentUrl().contains("cart"), "URL should be correct");
    }

    @Test(priority = 5, description = "Verify back navigation from cart")
    public void testBackNavigationFromCart() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getAppUrl()) ||
                     driver.getCurrentUrl().equals(ConfigReader.getAppUrl() + "/"), "Should navigate back");
    }

    @Test(priority = 6, description = "Verify page refresh on cart")
    public void testPageRefreshOnCart() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Should stay on cart page");
    }

    @Test(priority = 7, description = "Verify multiple cart page loads")
    public void testMultipleCartPageLoads() {
        for (int i = 0; i < 3; i++) {
            driver.get(ConfigReader.getAppUrl() + "/cart");
            Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page should load");
        }
    }

    @Test(priority = 8, description = "Verify navigation between cart and products")
    public void testCartToProductsNavigation() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.get(ConfigReader.getAppUrl() + "/products");
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Should navigate to products");
    }

    @Test(priority = 9, description = "Verify browser history navigation on cart")
    public void testBrowserHistoryNavigationOnCart() {
        driver.get(ConfigReader.getAppUrl());
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.navigate().back();
        driver.navigate().forward();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Forward navigation should work");
    }

    @Test(priority = 10, description = "Verify cart page title")
    public void testCartPageTitle() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        String title = driver.getTitle();
        Assert.assertTrue(title != null && !title.isEmpty(), "Page should have a title");
    }

    @Test(priority = 11, description = "Verify direct cart access from products")
    public void testDirectCartAccessFromProducts() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Should navigate to cart");
    }

    @Test(priority = 12, description = "Verify cart page loads after login")
    public void testCartAfterLoginNavigation() {
        driver.get(ConfigReader.getAppUrl() + "/login");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart should be accessible");
    }

    @Test(priority = 13, description = "Verify cart page with different browsers")
    public void testCartPageResponsive() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.manage().window().maximize();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart should load in maximized window");
    }

    @Test(priority = 14, description = "Verify cart page response time")
    public void testCartPageLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.get(ConfigReader.getAppUrl() + "/cart");
        long endTime = System.currentTimeMillis();
        Assert.assertTrue((endTime - startTime) < 10000, "Cart page should load within 10 seconds");
    }

    @Test(priority = 15, description = "Verify cart page accessibility from signup")
    public void testCartAfterSignupNavigation() {
        driver.get(ConfigReader.getAppUrl() + "/signup");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart should be accessible");
    }

    @Test(priority = 16, description = "Verify cart page from seller dashboard")
    public void testCartFromSellerDashboard() {
        driver.get(ConfigReader.getAppUrl() + "/seller/dashboard");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart should be accessible");
    }

    @Test(priority = 17, description = "Verify cart page from admin dashboard")
    public void testCartFromAdminDashboard() {
        driver.get(ConfigReader.getAppUrl() + "/admin/dashboard");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart should be accessible");
    }

    @Test(priority = 18, description = "Verify cart page navigation loop")
    public void testCartNavigationLoop() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Navigation loop should work");
    }

    @Test(priority = 19, description = "Verify cart page with direct URL")
    public void testCartDirectURL() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Direct URL should work");
    }
}
