package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class CommonFunctions {
//QA will create re-usable methods(Functions)/ variables 

	public WebDriver driver;

	public void chromeBrowserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Parameters("browserName")
	@BeforeClass // Pre-condition
	public void beforeClass(@Optional("edge") String browserName) {
		if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else {
			System.out.println("Please give browser name chrome/edge/firefox only......");
		}

	}

	public void screenshot() throws Exception {
		Date d = new Date();
		DateFormat abcd = new SimpleDateFormat("ddMMMyyyy_HHmmss");
		String timeStamp = abcd.format(d);
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(abc, new File(".\\screenshots\\QA" + timeStamp + ".png"));
	}

	public void sendKeysByAnyLocator(By locator, String inputdata) {
		// Check your locator is displayed?
		if (driver.findElement(locator).isDisplayed()) {
			// Check your element is in enable state?
			if (driver.findElement(locator).isEnabled()) {
				// Clear any existing data
				driver.findElement(locator).clear();
				// Send the test data to Edit box
				driver.findElement(locator).sendKeys(inputdata);
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}

	public void clickByAnyLocator(By locator) {
		// Check your locator is displayed?
		if (driver.findElement(locator).isDisplayed()) {
			// Check your element is in enable state?
			if (driver.findElement(locator).isEnabled()) {
				// Click on Button/radiobutton/checkbox/Link...
				driver.findElement(locator).click();
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}

}
