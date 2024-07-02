import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import aasaan.testing.util.WebDriverUtil;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Channel {
	WebDriver driver;
    JavascriptExecutor jse;

    @BeforeClass
    public void AddChannel() throws InterruptedException {
    	// System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = WebDriverUtil.getDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
      	driver.get("https://admin.aasaan.app");
        System.out.println("Application launched successfully");
        driver.manage().window().maximize(); 
        Thread.sleep(500);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
        WebElement userID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email-helper-text")));	
        userID.sendKeys("8332066652");
        driver.findElement(By.name("password")).sendKeys("India@999"); 
        Thread.sleep(500);
        WebElement Login = driver.findElement(By.cssSelector("#save"));
        Login.click();
        Thread.sleep(1000);
        System.out.println("Logged in successfully");
        jse = (JavascriptExecutor) driver;
        System.out.println("User is at Home Page");
       
    }

    @Test (priority=1)
    public void addChannel() throws InterruptedException {
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
    
    @Test (priority=2)
	public void deleteChannel() throws InterruptedException {
		WebElement Manage = driver.findElement(By.id("manage_tab"));
		Manage.click();
		Thread.sleep(1000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
    	WebElement Channel = driver.findElement(By.id("channel"));
    	Channel.click();
    	Thread.sleep(1000);
		WebElement moreOptions = driver.findElement(By.xpath("(//div[@id='more-options'])[2]"));
		moreOptions.click();
		Thread.sleep(1000);
		WebElement deleteButton = driver.findElement(By.xpath("(//div[@title='Delete'])[2]"));
		deleteButton.click();
		Thread.sleep(1000);
		WebElement deleteChannel = driver.findElement(By.xpath("//button[normalize-space()='Delete']"));
		deleteChannel.click();
		Thread.sleep(3000);
	}

    @AfterClass
    public void afterClass() {
    	driver.quit();
    }
}
