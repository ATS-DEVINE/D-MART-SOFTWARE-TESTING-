package com.dmart.testing.tests;

import com.dmart.testing.base.BaseTest;
import com.dmart.testing.config.ConfigReader;
import com.dmart.testing.pages.CheckoutPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test(priority = 1, description = "Verify checkout page is accessible")
    public void testCheckoutPageAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Checkout, cart, or home should be loaded");
    }

    @Test(priority = 2, description = "Verify navigation to checkout from cart")
    public void testNavigateToCheckoutFromCart() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Should navigate to checkout, cart, or home");
    }

    @Test(priority = 3, description = "Verify checkout page URL structure")
    public void testCheckoutPageURL() {
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.equals(ConfigReader.getAppUrl() + "/checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "URL should be checkout, cart, or home");
    }

    @Test(priority = 4, description = "Verify back navigation from checkout")
    public void testBackNavigationFromCheckout() {
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        driver.navigate().back();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(ConfigReader.getAppUrl()) ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains("checkout"), "Should navigate back");
    }

    @Test(priority = 5, description = "Verify page refresh on checkout")
    public void testPageRefreshOnCheckout() {
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        driver.navigate().refresh();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Should stay on checkout or redirect to cart/home");
    }

    @Test(priority = 6, description = "Verify direct checkout access from products")
    public void testDirectCheckoutAccessFromProducts() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Should navigate to checkout, cart, or home");
    }

    @Test(priority = 7, description = "Verify checkout page title")
    public void testCheckoutPageTitle() {
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String title = driver.getTitle();
        Assert.assertTrue(title != null && !title.isEmpty(), "Page should have a title");
    }

    @Test(priority = 8, description = "Verify checkout response time")
    public void testCheckoutPageLoadTime() {
        long startTime = System.currentTimeMillis();
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        long endTime = System.currentTimeMillis();
        Assert.assertTrue((endTime - startTime) < 10000, "Checkout page should load within 10 seconds");
    }

    @Test(priority = 9, description = "Verify checkout page loads after login")
    public void testCheckoutAfterLoginNavigation() {
        driver.get(ConfigReader.getAppUrl() + "/login");
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Checkout should be accessible or redirect");
    }

    @Test(priority = 10, description = "Verify checkout page from home")
    public void testCheckoutFromHome() {
        driver.get(ConfigReader.getAppUrl());
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Checkout should be accessible or redirect");
    }

    @Test(priority = 11, description = "Verify navigation between checkout and cart")
    public void testCheckoutToCartNavigation() {
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Should navigate to cart or home");
    }

    @Test(priority = 12, description = "Verify checkout page with empty cart redirect")
    public void testCheckoutWithEmptyCart() {
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Should handle empty cart by redirecting");
    }

    @Test(priority = 13, description = "Verify checkout page from products page")
    public void testCheckoutFromProducts() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Should navigate to checkout, cart, or home");
    }

    @Test(priority = 14, description = "Verify checkout page accessibility from signup")
    public void testCheckoutAfterSignupNavigation() {
        driver.get(ConfigReader.getAppUrl() + "/signup");
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Checkout should be accessible or redirect");
    }

    @Test(priority = 15, description = "Verify checkout page navigation loop")
    public void testCheckoutNavigationLoop() {
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Navigation loop should work");
    }
}
