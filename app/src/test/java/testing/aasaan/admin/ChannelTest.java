package com.example.test1;

import aasaan.testing.util.WebDriverUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

// All the dependencies below is also used for taking screenshots used for debugging headless chrome
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.apache.commons.io.FileUtils;
// import java.io.File;
// import java.io.IOException;

public class ChannelTest {
    private static WebDriver driver;
    static JavascriptExecutor jse;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverUtil.getDriver();
		jse = (JavascriptExecutor) driver;
    }

    @Test
	@Order(1)
    public void createChannel() throws InterruptedException {
        driver = WebDriverUtil.getDriver();
        // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      	driver.get("https://app.lightbooks-dev.io/welcome");
        System.out.println("Application launched successfully");
        driver.manage().window().maximize(); 
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement userID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-helper-text")));	
        userID.sendKeys("5306048675");
        driver.findElement(By.name("password")).sendKeys("India@999");  
        Thread.sleep(500);
        WebElement Login = driver.findElement(By.cssSelector("#save"));
        Login.click();
        Thread.sleep(2000);
        System.out.println("Logged in successfully");
        System.out.println("User is at Home Page");


		// The snippet below can be used to take screenshots to debug headless chrome
		// File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// try {
		// 	FileUtils.copyFile(screenshot, new File("screenshot2.png"));
		// } catch (IOException e) {
		// 	e.printStackTrace();
		// }

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("manage_tab")));
    	WebElement ManageTab = driver.findElement(By.id("manage_tab"));
    	ManageTab.click();
    	Thread.sleep(1000);
    	jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
    	WebElement Channel = driver.findElement(By.id("channel"));
    	Channel.click();
    	Thread.sleep(1000);
    	WebElement addMultichannelButton = driver.findElement(By.id("add-channel"));
    	addMultichannelButton.click();
    	Thread.sleep(2000);
    	WebElement name = driver.findElement(By.name("name"));
    	name.sendKeys("Automation");
    	WebElement slug = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
    	slug.sendKeys("Slug");
    	Thread.sleep(1000);
    	// Find the warehouse dropdown and select a warehouse
    	WebElement warehouseDropdown = driver.findElement(By.id("warehouse-drpdwn"));
    	warehouseDropdown.click();
    	WebElement warehouseOption = driver.findElement(By.id("warehouse-option"));
    	warehouseOption.click();
    	Thread.sleep(3000); 
	
    	driver.findElement(By.id("save-channel")).click();
    	Thread.sleep(1000);
    }

    // @Test
	// @Order(2)
	// public void deleteChannel() throws InterruptedException {
	// 	WebElement Manage = driver.findElement(By.id("manage_tab"));
	// 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	// 	Manage.click();
	// 	Thread.sleep(1000);
	// 	jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	// 	Thread.sleep(3000);
	// 	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("channel")));
    // 	WebElement Channel = driver.findElement(By.id("channel"));
    // 	Channel.click();
    // 	Thread.sleep(1000);
	// 	WebElement moreOptions = driver.findElement(By.xpath("(//div[@id='more-options'])[2]"));
	// 	moreOptions.click();
	// 	Thread.sleep(1000);
	// 	WebElement deleteButton = driver.findElement(By.xpath("(//div[@title='Delete'])[2]"));
	// 	deleteButton.click();
	// 	Thread.sleep(1000);
	// 	WebElement deleteChannel = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
	// 	deleteChannel.click();
	// 	Thread.sleep(3000);
	// }

    @AfterAll
    public static void tearDown() {
        WebDriverUtil.quitDriver();
    }
}
