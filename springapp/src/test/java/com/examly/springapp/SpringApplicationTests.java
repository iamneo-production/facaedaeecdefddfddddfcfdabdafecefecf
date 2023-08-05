package com.examly.springapp;
import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChrmeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SpringApplicationTests{

    WebDriver driver = null;

    @BeforeTest
    public void beforeTest() throws Exception {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized"); // Maximize the window on startup
        driver = new FirefoxDriver(firefoxOptions);
        }

    @Test
    public void iamNeo() throws InterruptedException {
        driver.navigate().to("http://iamneo.ai");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Learning and assessment solution for Universities and Enterprises");
    }

    @Test
    public void nextPage() throws InterruptedException {
        driver.navigate().to("https://www.facebook.com");
        String title = driver.getTitle();
        Assert.assertEquals(title, "Facebook – log in or sign up");
    }

    @Test
    public void backPage() throws InterruptedException {
        driver.navigate().back();
        String title = driver.getTitle();
        Assert.assertEquals(title, "Learning and assessment solution for Universities and Enterprises");
    }

    @Test
    public void currentURL() throws InterruptedException {
        String title = driver.getCurrentUrl();
        System.out.println(title);
        // You can add an Assert here if you want to validate the current URL
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }

    // Main method to run the test class directly
    public static void main(String[] args) {
        // Create an instance of the test class
        SpringappApplication test = new SpringappApplication();

        try {
            // Execute the setup method
            test.beforeTest();

            // Execute the test methods
            test.iamNeo();
            test.nextPage();
            test.backPage();
            test.currentURL();

            // Execute the tear down method
            test.afterTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
