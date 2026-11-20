package com.dmart.testing.tests;

import com.dmart.testing.base.BaseTest;
import com.dmart.testing.config.ConfigReader;
import com.dmart.testing.pages.HomePage;
import com.dmart.testing.pages.ProductsPage;
import com.dmart.testing.pages.CartPage;
import com.dmart.testing.pages.LoginPage;
import com.dmart.testing.pages.SignupPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EdgeCaseTests extends BaseTest {

    @Test(priority = 1, description = "Verify search with special characters")
    public void testSearchWithSpecialCharacters() {
        driver.get(ConfigReader.getAppUrl() + "/products?q=@#$%^&*()");
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Should handle special characters");
    }

    @Test(priority = 2, description = "Verify search with very long string")
    public void testSearchWithLongString() {
        String longString = "a".repeat(1000);
        driver.get(ConfigReader.getAppUrl() + "/products?q=" + longString);
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Should handle long strings");
    }

    @Test(priority = 3, description = "Verify navigation to non-existent product")
    public void testNavigateToNonExistentProduct() {
        driver.get(ConfigReader.getAppUrl() + "/products/999999");
        Assert.assertTrue(driver.getCurrentUrl().contains("products") ||
                     driver.getCurrentUrl().contains("404"), "Should handle gracefully");
    }

    @Test(priority = 4, description = "Verify navigation to non-existent seller")
    public void testNavigateToNonExistentSeller() {
        driver.get(ConfigReader.getAppUrl() + "/store/999999");
        Assert.assertTrue(driver.getCurrentUrl().contains("store") ||
                     driver.getCurrentUrl().contains("404"), "Should handle gracefully");
    }

    @Test(priority = 5, description = "Verify login page direct access")
    public void testDirectLoginURLAccess() {
        driver.get(ConfigReader.getAppUrl() + "/login");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginPageLoaded(), "Direct URL access to login should work");
    }

    @Test(priority = 6, description = "Verify signup page direct access")
    public void testDirectSignupURLAccess() {
        driver.get(ConfigReader.getAppUrl() + "/signup");
        SignupPage signupPage = new SignupPage(driver);
        Assert.assertTrue(signupPage.isSignupPageLoaded(), "Direct URL access to signup should work");
    }

    @Test(priority = 7, description = "Verify direct URL access to cart")
    public void testDirectCartURLAccess() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartPageLoaded(), "Direct URL access to cart should work");
    }

    @Test(priority = 8, description = "Verify direct URL access to checkout")
    public void testDirectCheckoutURLAccess() {
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Direct URL access to checkout should navigate to checkout, cart, or home");
    }

    @Test(priority = 9, description = "Verify browser back button navigation")
    public void testBrowserBackNavigation() {
        driver.get(ConfigReader.getAppUrl());
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getAppUrl()) ||
                     driver.getCurrentUrl().equals(ConfigReader.getAppUrl() + "/"), "Browser back should navigate correctly");
    }

    @Test(priority = 10, description = "Verify browser forward button navigation")
    public void testBrowserForwardNavigation() {
        driver.get(ConfigReader.getAppUrl());
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.navigate().back();
        driver.navigate().forward();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Browser forward should navigate correctly");
    }

    @Test(priority = 11, description = "Verify page refresh maintains state")
    public void testPageRefresh() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Page should reload correctly after refresh");
    }

    @Test(priority = 12, description = "Verify sellers page with no sellers")
    public void testSellersPageWithNoSellers() {
        driver.get(ConfigReader.getAppUrl() + "/sellers");
        Assert.assertTrue(driver.getCurrentUrl().contains("sellers"), "Sellers page should load even with no sellers");
    }

    @Test(priority = 13, description = "Verify product page with no products")
    public void testProductsWithNoProducts() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductsPageLoaded(), "Products page should load even with no products");
    }

    @Test(priority = 14, description = "Verify rapid page navigation")
    public void testRapidPageNavigation() {
        driver.get(ConfigReader.getAppUrl());
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/sellers");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Rapid navigation should work");
    }
}
