package com.trainingautomation.tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleSearchTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        // Wait up to 10 seconds for elements to appear
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testGoogleSearch() throws Exception {

        // Accept cookies if it appears
        try {
            Actions actions = new Actions(driver);
            actions.scrollByAmount(0, 300);
            actions.perform();
            WebElement acceptButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Accept all')]")));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("No cookie banner found, continuing...");
        }

        // Wait for search box and type
        WebElement searchBox = wait.until(
            ExpectedConditions.elementToBeClickable(By.name("q")));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // Wait for results to appear
        WebElement results = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        Assert.assertTrue("Search results should be displayed", results.isDisplayed());

        System.out.println("TEST PASSED!");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}