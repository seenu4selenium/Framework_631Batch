package com.testscenarios;

import org.testng.annotations.Test;

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

public class FB_login {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void f() throws Exception {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("h2otestingtools123@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("Testing@123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		Date d = new Date();
		DateFormat abcd = new SimpleDateFormat("ddMMMyyyy_HHmmss");
		String timeStamp = abcd.format(d);
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(abc, new File(".\\screenshots\\QA" + timeStamp + ".png"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
