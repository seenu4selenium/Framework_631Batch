package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
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

	public void screenshot() throws Exception {
		Date d = new Date();
		DateFormat abcd = new SimpleDateFormat("ddMMMyyyy_HHmmss");
		String timeStamp = abcd.format(d);
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(abc, new File(".\\screenshots\\QA" + timeStamp + ".png"));
	}

	public void sendKeysByAnyLocator(By locator, String inputdata) throws Exception {
		WebElement element = driver.findElement(locator);

		// Check your locator is displayed?
		if (element.isDisplayed()) {
			// Check your element is in enable state?
			if (element.isEnabled()) {
				System.out.println("Given locator is enable state ***");
				// Clear any existing data
				highlightElement(element);
				element.clear();
				// Send the test data to Edit box
				highlightElement(element);
				element.sendKeys(inputdata);
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}

	public void clickByAnyLocator(By locator) throws Exception {
		WebElement element = driver.findElement(locator);
		// Check your locator is displayed?
		if (element.isDisplayed()) {
			// Check your element is in enable state?
			if (element.isEnabled()) {
				// Click on Button/radiobutton/checkbox/Link...
				highlightElement(element);
				element.click();
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}

	public void highlightElement(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='6px groove green'", element);
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''", element);
		// ((JavascriptExecutor) driver).executeScript("arguments[0].style.border=''",
		// element);
	}

	/****************** Dropdown selection Methods**************************************/

	public void selectByVisibleText(By locater, String visibleText) {

		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(visibleText);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectByIndex(By locater, int index) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByIndex(index);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectByValue(By locater, String value) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByValue(value);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}
	
	public void printAllDropdownValues(By locater) {
		WebElement element = driver.findElement(locater);

		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();
				// Print the size of dropdown values
				System.out.println("*************" + dropdownValues.size());
				// Print the dropdown values
				for (WebElement allvalue : dropdownValues) {
					System.out.println(allvalue.getText());
				}
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}
	
	public void selectCustomiseOptionFromTheDropdownValues(By locater, String visibleText) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {

				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();
				// Print the size of dropdown values
				System.out.println(dropdownValues.size());
				// Print the dropdown values
				for (int i = 0; i < dropdownValues.size(); i++) {
					System.out.println(dropdownValues.get(i).getText());

					// Select given option from the dropdown
					if (dropdownValues.get(i).getText().equals(visibleText)) {
						dropdown.selectByIndex(i);
						break;
					}
				}

			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}
	

	/************ webdriver waits ***********************/
	// explicit wait
	public void explicitwaitForElementToBeClickable(By locator) {
		WebElement loginbutton = driver.findElement(locator);
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(25));
		ww.until(ExpectedConditions.elementToBeClickable(loginbutton));
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		System.out.println("Implicit wait method used***");

	}

	/***
	 * instead of fluent wait use customized While loop statement**@throws Exception
	 *****/

	public void waitforElement(By locater) throws Exception {
		int i = 0;
		while (driver.findElements(locater).size() < 1) {
			Thread.sleep(500);// 05 sec
			System.out.println("Wait for the element***************");
			// Suppose system has not present the element it will repeat 30 time
			// then stop
			// the execution using break
			if (i > 30) {
				System.out.println("Element is not present");
				break;
			}
			i++;
		}
	}
	
	/*********** SwithchToWindow using Tab ***************************/
	public void switchToNewTab() {
		// Get the current window handle
		String windowHandle = driver.getWindowHandle();// abc

	ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));

		// Switch back to original window
		// driver.switchTo().window(windowHandle);
	}
	
	/***********
	 * SwithchToWindow using Tab then close the New Tab againg back to Parent Window
	 ***************************/
	public void switchAndCloseNewTab() {
		// Get the current window handle
		String parentWindow = driver.getWindowHandle();
		ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(allTabs.get(1));
		// Close the newly Opened Window
		driver.close();
		// Switch back to original window
		driver.switchTo().window(parentWindow);
	}
	

	/************
	 * popupHandle
	 * 
	 * @throws InterruptedException
	 *********************************/
	public void popupHandleToCloseTheChildWindow() throws InterruptedException {
		// get the main windown name
		String mainWindowName = driver.getWindowHandle();
		System.out.println("mainWindowName:" + mainWindowName);

		Set<String> allWindowNames = driver.getWindowHandles();
		System.out.println("allWindowNames:" + allWindowNames);

		// Close the child window (popups)
		for (String abc : allWindowNames) {// 2
			// validate the window name is parent window /Child window?
			if (!mainWindowName.equals(abc)) {
				// switch to child window
				driver.switchTo().window(abc);
				Thread.sleep(3000);
				// Close my child window
				driver.close();
			}
		}
		// move cursor point to back to mainwindow
		driver.switchTo().window(mainWindowName);
	}

	public void navigateToPopupWindow() throws InterruptedException {
		// get the main windown name
		String mainWindowName = driver.getWindowHandle();
		System.out.println("mainWindowName:" + mainWindowName);

		Set<String> allWindowNames = driver.getWindowHandles();// 4
		System.out.println("allWindowNames:" + allWindowNames);

		// Close the child window (popups)
		// for (int i = 0; i < array.length; i++) { }
		for (String string : allWindowNames) {
			// validate the window name is parent window /Child window?
			if (!mainWindowName.equals(string)) {
				// switch to child window
				driver.switchTo().window(string);
				Thread.sleep(3000);
			}
		}

	}

	
}
