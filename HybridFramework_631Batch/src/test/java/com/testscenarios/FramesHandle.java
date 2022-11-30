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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class FramesHandle extends CommonFunctions {

	Locators loc = new Locators();

	@BeforeClass
	public void beforeClass() {

		chromeBrowserLaunch();

	}

	@Test
	public void f() throws Exception {
		// Develop the test code
		driver.get("http://mis.nyiso.com/public/");
		Thread.sleep(5000);		
		loopAllFramesForElement(By.name("P-24Alist"));		
		clickByAnyLocator(By.name("P-24Alist"));
		Thread.sleep(5000);			
		loopAllFramesForElement(By.linkText("Most recent interval"));
		clickByAnyLocator(By.linkText("Most recent interval"));
	}

	

}
