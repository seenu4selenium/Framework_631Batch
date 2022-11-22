package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepositories.Locators;
import com.utilities.CommonFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

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
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class FB_login extends CommonFunctions {
	
	Locators loc = new Locators();

	@BeforeClass
	public void beforeClass() {
		chromeBrowserLaunch();
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

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
