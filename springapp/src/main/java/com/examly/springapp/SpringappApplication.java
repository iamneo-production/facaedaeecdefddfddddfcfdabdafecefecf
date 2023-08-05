package com.examly.springapp;

import org.testng.annotations.Test;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class SpringappApplication {

	ChromeOptions chromeOptions = new ChromeOptions();
	WebDriver driver = null;

	@BeforeTest
	public void beforeTest() throws Exception
	 {
		driver = new RemoteWebDriver(new URL("http://localhost:4444"), chromeOptions);
	    driver.manage().window().maximize();
	}

	@Test
//Checking the title of iamNeo (Home - iamneo)
	public void iamNeo() throws InterruptedException 
	{
        driver.navigate().to("http://iamneo.ai");
		 String title =driver.getTitle();
		Assert.assertEquals(title, "Learning and assessment solution for Universities and Enterprises");
	}
	@Test
//Moving to FACEBOOK
	public void nextPage() throws InterruptedException 
	{
	    driver.navigate().to("https://www.facebook.com");
		 String title =driver.getTitle();
		// Assert.assertEquals(title, "Facebook â€“ log in or sign up");

	}
	@Test
//Back to iamNeo
	public void backPage() throws InterruptedException 
	{
		driver.navigate().back();
		String title =driver.getTitle();
		// Assert.assertEquals(title, "Learning and assessment solution for Universities and Enterprises");

	}
	@Test
//Current URL
public void currentURL() throws InterruptedException 
{
		 String title =driver.getCurrentUrl();
		 System.out.println(title);
		// Assert.assertEquals(title, "");
		driver.navigate().forward();
		driver.navigate().refresh();

}

	@AfterTest
	public void afterTest() 
	{
		driver.quit();
	}

}
