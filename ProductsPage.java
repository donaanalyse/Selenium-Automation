package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    // Page elements
    By pageTitle = By.cssSelector(".title");
    By addToCartButton = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    By cartIcon = By.cssSelector(".shopping_cart_link");
    By cartBadge = By.cssSelector(".shopping_cart_badge");

    // Constructor
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Verify we are on products page
    public boolean isOnProductsPage() {
        String title = wait.until(
            ExpectedConditions.visibilityOfElementLocated(pageTitle)).getText();
        return title.equals("Products");
    }

    // Add first product to cart
    public void addProductToCart() {
        wait.until(
            ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    // Get cart count
    public String getCartCount() {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(cartBadge)).getText();
    }

    // Go to cart
    public void goToCart() {
        driver.findElement(cartIcon).click();
    }
}