

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class GoogleSearchTest {

    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleSearch() throws Exception {

        // Accept cookies
        try {
            Actions actions = new Actions(driver);
            actions.scrollByAmount(0, 300);
            actions.perform();
            WebElement acceptButton = driver.findElement(By.xpath("//button[contains(., 'Accept all')]"));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("No cookie banner found, continuing...");
        }

        // Search for Selenium WebDriver
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // Wait for results
        Thread.sleep(2000);

        // Verify results appear
        WebElement results = driver.findElement(By.id("search"));
        Assert.assertTrue("Search results should be displayed", results.isDisplayed());

        // Take a screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screenshots/GoogleSearch.png"));
        System.out.println("TEST PASSED!");
    }

    @After
    public void teardown() {
        driver.quit();
    }
}