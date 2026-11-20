package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Search' or @placeholder='Search products']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[contains(text(),'Search') or contains(@class,'search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//select[contains(@class,'category') or @name='category']")
    private WebElement categoryFilter;

    @FindBy(xpath = "//select[contains(@class,'sort') or @name='sort']")
    private WebElement sortDropdown;

    @FindBy(xpath = "//div[contains(@class,'product-card')]")
    private List<WebElement> productCards;

    @FindBy(xpath = "//div[contains(@class,'product-card')]//a[contains(@href,'/products/')]")
    private List<WebElement> productLinks;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart') or contains(@class,'add-cart')]")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//button[contains(text(),'Wishlist') or contains(@class,'wishlist')]")
    private List<WebElement> wishlistButtons;

    @FindBy(xpath = "//h1[contains(text(),'Products')]")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[contains(text(),'No products') or contains(text(),'No results')]")
    private WebElement noResultsMessage;

    public boolean isProductsPageLoaded() {
        try {
            if (driver.getCurrentUrl().contains("products")) {
                return true;
            }
            return pageTitle != null && pageTitle.isDisplayed();
        } catch (Exception e) {
            return driver.getCurrentUrl().contains("products");
        }
    }

    public void searchProduct(String productName) {
        sendKeys(searchInput, productName);
        click(searchButton);
    }

    public void filterByCategory(String category) {
        categoryFilter.sendKeys(category);
    }

    public void sortBy(String sortOption) {
        sortDropdown.sendKeys(sortOption);
    }

    public int getProductCount() {
        return productCards.size();
    }

    public void clickProduct(int index) {
        if (index < productLinks.size()) {
            click(productLinks.get(index));
        }
    }

    public void addToCart(int index) {
        if (index < addToCartButtons.size()) {
            click(addToCartButtons.get(index));
        }
    }

    public void addToWishlist(int index) {
        if (index < wishlistButtons.size()) {
            click(wishlistButtons.get(index));
        }
    }

    public boolean hasProducts() {
        return !productCards.isEmpty();
    }

    public boolean isNoResultsDisplayed() {
        return isDisplayed(noResultsMessage);
    }
}
