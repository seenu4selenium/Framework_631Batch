package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepositories.Locators;
import com.utilities.CommonFunctions;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

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
import org.testng.annotations.AfterClass;

public class FB_login extends CommonFunctions {
	
	Locators loc = new Locators();

	@Parameters("browserName")
	@BeforeClass // Pre-condition
	public void beforeClass(@Optional("chrome") String browserName) {
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

	@Test
	public void f() throws Exception {
		driver.get("https://www.facebook.com/");
		driver.findElement(loc.FBLogin_Email_EditBox).sendKeys("h2otestingtools123@gmail.com");
		driver.findElement(loc.FBLogin_Password_EditBox).sendKeys("Testing@123");
		driver.findElement(loc.FBLogin_Login_Button).click();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		screenshot();
	}

	//@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
