package com.dmart.testing.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(@class,'product-title') or contains(@class,'title')]")
    private WebElement productTitle;

    @FindBy(xpath = "//span[contains(@class,'price') or contains(text(),'$')]")
    private WebElement productPrice;

    @FindBy(xpath = "//div[contains(@class,'description')]")
    private WebElement productDescription;

    @FindBy(xpath = "//input[@type='number' or contains(@class,'quantity')]")
    private WebElement quantityInput;

    @FindBy(xpath = "//button[contains(text(),'Add to Cart') or contains(@class,'add-cart')]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[contains(text(),'Buy Now') or contains(@class,'buy-now')]")
    private WebElement buyNowButton;

    @FindBy(xpath = "//button[contains(text(),'Wishlist') or contains(@class,'wishlist')]")
    private WebElement wishlistButton;

    @FindBy(xpath = "//img[contains(@class,'product-image')]")
    private WebElement productImage;

    @FindBy(xpath = "//select[contains(@class,'tier') or @name='pricing']")
    private WebElement pricingTierSelect;

    @FindBy(xpath = "//div[contains(@class,'seller')]")
    private WebElement sellerInfo;

    @FindBy(xpath = "//a[contains(@href,'/sellers/')]")
    private WebElement sellerLink;

    public boolean isProductDetailPageLoaded() {
        return isDisplayed(productTitle);
    }

    public String getProductTitle() {
        return getText(productTitle);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public String getProductDescription() {
        return getText(productDescription);
    }

    public void setQuantity(int quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(String.valueOf(quantity));
    }

    public void addToCart() {
        click(addToCartButton);
    }

    public void buyNow() {
        click(buyNowButton);
    }

    public void addToWishlist() {
        click(wishlistButton);
    }

    public void selectPricingTier(String tier) {
        pricingTierSelect.sendKeys(tier);
    }

    public void clickSellerLink() {
        click(sellerLink);
    }

    public boolean isProductImageDisplayed() {
        return isDisplayed(productImage);
    }
}
