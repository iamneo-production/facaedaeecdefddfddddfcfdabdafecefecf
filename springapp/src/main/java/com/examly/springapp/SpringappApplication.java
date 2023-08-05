package com.examly.springapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class SpringappApplication {

	// Creating an instance of Firefox Browser
	FirefoxDriver driver;
	String qatechhubUrl = "http://qatechhub.com";
	String facebookUrl = "https://www.facebook.com";

	public void invokeBrowser() {

		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Saurabh Dhingra\\workspace\\libs\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		driver.get(qatechhubUrl);

		String titleOfThePage = driver.getTitle();

		if (titleOfThePage.equals("QA Automation Tools Trainings and Tutorials | QA Tech Hub")) {
			System.out.println("Test case PASS");
		} else {
			System.out.println("Test case FAIL");
		}

	}

	public void navigateCommands() {
		driver.navigate().to(facebookUrl);

		String currentUrl = driver.getCurrentUrl();

		System.out.println("Current URL :: " + currentUrl);
		driver.navigate().back();

		driver.navigate().refresh();

		driver.navigate().refresh();
	}

	public static void main(String[] args) {
		SpringappApplication assignment = new SpringappApplication();

		assignment.invokeBrowser();

	}

}