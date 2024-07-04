package aasaan.testing.util;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtil {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            //     // 1. Setup WebDriverManager (downloads if needed)
            // WebDriverManager.chromedriver().setup(); 

            // // 2. (Optional) Headless Chrome Configuration
            // ChromeOptions options = new ChromeOptions();
            // options.addArguments("--headless=new");
            // options.addArguments("--disable-gpu"); // Might be needed

            // // 3. Instantiate your WebDriver
            // WebDriver driver = new ChromeDriver(options); // Use options if headless

            // To run chrome options in headless
            // ChromeOptions options = new ChromeOptions();
            // options.addArguments("--headless");
            // options.addArguments("--no-sandbox");
            // options.addArguments("--disable-dev-shm-usage");
            // driver = new ChromeDriver(options);
            /////////////////////////////////////////////////
            // To run in normal i.e. non-headless mode  
            driver = new ChromeDriver();
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
