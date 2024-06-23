package com.example.test1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass1 {
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        System.out.println("Setting up WebDriver");
        System.setProperty("webdriver.chrome.driver", "/Users/pramodkalidindi/Downloads/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testMethod1() {
        System.out.println("Starting testMethod1");
        driver.get("https://aasaan.app");
        System.out.println("Navigated to URL");
        String title = driver.getTitle();
        System.out.println("Title: " + title);
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("Quitting WebDriver");
    }
}
