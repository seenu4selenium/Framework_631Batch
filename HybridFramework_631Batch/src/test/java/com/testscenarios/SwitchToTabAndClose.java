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
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;

public class SwitchToTabAndClose extends CommonFunctions {

	Locators loc = new Locators();

	@BeforeClass
	public void beforeClass() {

		chromeBrowserLaunch();

	}

	@Test
	public void f() throws Exception {
		driver.get("https://myaccount.greenmountain.com/en_US/register");
		Thread.sleep(5000);
		System.out.println(driver.getWindowHandle());
		clickByAnyLocator(By.linkText("Contact Us"));
		System.out.println(driver.getWindowHandles());

		String parentWindow = driver.getWindowHandle();
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
	
		
		//Switch to Child tab, 
		driver.switchTo().window(allTabs.get(1));
		Thread.sleep(5000);
		//then close the child tab
		driver.close();
		
		//Then move cursor pointer to Parent window do some actions on Parent window
		//driver.switchTo().window(allTabs.get(0));
		driver.switchTo().window(parentWindow);
		//Click on cancel button on Parent tab		
		driver.findElement(By.id("cancel")).click();
				
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
