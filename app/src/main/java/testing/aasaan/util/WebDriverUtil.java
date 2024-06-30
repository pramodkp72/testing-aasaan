package aasaan.testing.util;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtil {
    private static WebDriver driver; // This driver was shadowed!

    public static WebDriver getDriver() {
        if (driver == null) { 
            WebDriverManager.chromedriver().setup(); 

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu"); 

            // Assign to the class-level driver variable
            driver = new ChromeDriver(options);  

            // ... rest of your initialization code
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}