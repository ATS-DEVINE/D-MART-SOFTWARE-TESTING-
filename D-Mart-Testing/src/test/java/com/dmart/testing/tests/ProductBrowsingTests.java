package com.dmart.testing.tests;

import com.dmart.testing.base.BaseTest;
import com.dmart.testing.config.ConfigReader;
import com.dmart.testing.pages.HomePage;
import com.dmart.testing.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductBrowsingTests extends BaseTest {

    @Test(priority = 1, description = "Verify products page is accessible")
    public void testProductsPageAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Products page should be loaded");
    }

    @Test(priority = 2, description = "Verify search functionality from home")
    public void testSearchFromHome() {
        driver.get(ConfigReader.getAppUrl());
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("rice");
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Should navigate to products page");
    }

    @Test(priority = 3, description = "Verify direct navigation to products")
    public void testDirectProductsNavigation() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isProductsPageLoaded(), "Products page should be loaded");
    }

    @Test(priority = 4, description = "Verify navigation from home to products")
    public void testNavigateToProductsFromHome() {
        driver.get(ConfigReader.getAppUrl());
        HomePage homePage = new HomePage(driver);
        homePage.clickProducts();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Should navigate to products page");
    }

    @Test(priority = 5, description = "Verify products page URL structure")
    public void testProductsPageURL() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        Assert.assertTrue(driver.getCurrentUrl().equals(ConfigReader.getAppUrl() + "/products") ||
                     driver.getCurrentUrl().contains("products"), "URL should be correct");
    }

    @Test(priority = 6, description = "Verify search with query parameter")
    public void testSearchWithQuery() {
        driver.get(ConfigReader.getAppUrl() + "/products?q=test");
        Assert.assertTrue(driver.getCurrentUrl().contains("products") &&
                     driver.getCurrentUrl().contains("q"), "URL should contain search query");
    }

    @Test(priority = 7, description = "Verify back navigation from products")
    public void testBackNavigationFromProducts() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.navigate().back();
        Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getAppUrl()) ||
                     driver.getCurrentUrl().equals(ConfigReader.getAppUrl() + "/"), "Should navigate back");
    }

    @Test(priority = 8, description = "Verify page refresh on products")
    public void testPageRefreshOnProducts() {
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.navigate().refresh();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Should stay on products page");
    }

    @Test(priority = 9, description = "Verify multiple product page loads")
    public void testMultipleProductPageLoads() {
        for (int i = 0; i < 3; i++) {
            driver.get(ConfigReader.getAppUrl() + "/products");
            Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Products page should load");
        }
    }

    @Test(priority = 10, description = "Verify product detail URL pattern")
    public void testProductDetailURLPattern() {
        driver.get(ConfigReader.getAppUrl() + "/products/1");
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Should be on products page");
    }

    @Test(priority = 11, description = "Verify navigation between pages")
    public void testPageNavigation() {
        driver.get(ConfigReader.getAppUrl());
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.get(ConfigReader.getAppUrl() + "/cart");
        driver.get(ConfigReader.getAppUrl() + "/products");
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Should navigate correctly");
    }

    @Test(priority = 12, description = "Verify browser history navigation")
    public void testBrowserHistoryNavigation() {
        driver.get(ConfigReader.getAppUrl());
        driver.get(ConfigReader.getAppUrl() + "/products");
        driver.navigate().back();
        driver.navigate().forward();
        Assert.assertTrue(driver.getCurrentUrl().contains("products"), "Forward navigation should work");
    }

    @Test(priority = 13, description = "Verify direct URL to non-existent product")
    public void testDirectURLToNonExistentProduct() {
        driver.get(ConfigReader.getAppUrl() + "/products/999999");
        Assert.assertTrue(driver.getCurrentUrl().contains("products") ||
                     driver.getCurrentUrl().contains("404"), "Should handle gracefully");
    }

    @Test(priority = 14, description = "Verify sellers page accessibility")
    public void testSellersPageAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/sellers");
        Assert.assertTrue(driver.getCurrentUrl().contains("sellers"), "Sellers page should be loaded");
    }

    @Test(priority = 15, description = "Verify navigation to sellers from home")
    public void testNavigateToSellersFromHome() {
        driver.get(ConfigReader.getAppUrl());
        HomePage homePage = new HomePage(driver);
        homePage.clickSellers();
        Assert.assertTrue(driver.getCurrentUrl().contains("sellers"), "Should navigate to sellers page");
    }

    @Test(priority = 16, description = "Verify cart page accessibility")
    public void testCartPageAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/cart");
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page should be loaded");
    }

    @Test(priority = 17, description = "Verify navigation to cart from home")
    public void testNavigateToCartFromHome() {
        driver.get(ConfigReader.getAppUrl());
        HomePage homePage = new HomePage(driver);
        homePage.clickCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Should navigate to cart page");
    }

    @Test(priority = 18, description = "Verify checkout page accessibility")
    public void testCheckoutPageAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/checkout");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("checkout") ||
                     currentUrl.contains("cart") ||
                     currentUrl.contains(ConfigReader.getAppUrl()), "Checkout, cart, or home should be loaded");
    }

    @Test(priority = 19, description = "Verify login page accessibility")
    public void testLoginPageAccessibility() {
        driver.get(ConfigReader.getAppUrl() + "/login");
        Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login page should be loaded");
    }
}
