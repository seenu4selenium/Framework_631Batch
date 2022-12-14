package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepositories.Locators;
import com.utilities.CommonFunctions;

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

public class ClassTemplate extends CommonFunctions {

	Locators loc = new Locators();

	@BeforeClass
	public void beforeClass() {

		chromeBrowserLaunch();

	}

	@Test
	public void f() throws Exception {
		// Develop the test code
		driver.get("URL of the Page");
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
