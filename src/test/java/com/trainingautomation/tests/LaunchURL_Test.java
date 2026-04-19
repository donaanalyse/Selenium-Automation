package com.trainingautomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchURL_Test {

	 public static void main(String[] args) {
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.google.com");
	        driver.manage().window().maximize();

	        Actions actions = new Actions(driver);
	        actions.scrollByAmount(0, 300);
	        actions.perform();

	        WebElement acceptButton = driver.findElement(By.xpath("//button[contains(., 'Accept all')]"));
	        acceptButton.click();
	    }
	

	}


