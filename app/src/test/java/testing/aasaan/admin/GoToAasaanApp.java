package com.example.test1;

import aasaan.testing.util.WebDriverUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoToAasaanApp {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        driver = WebDriverUtil.getDriver();
    }

    @Test
    public void testMethod1() {
        driver.get("https://aasaan.app");
        String title = driver.getTitle();
        assertEquals("Aasaan - Headless commerce using AI", title);
    }

    @AfterAll
    public static void tearDown() {
        WebDriverUtil.quitDriver();
    }
}
