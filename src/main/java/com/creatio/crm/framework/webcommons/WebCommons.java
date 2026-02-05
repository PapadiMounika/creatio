package com.creatio.crm.framework.webcommons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.http.util.Asserts;
import org.apache.poi.hpsf.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.creatio.crm.framework.Base.BasePage;
import com.creatio.crm.framework.Constants.Constants;
import com.creatio.crm.framework.utilities.PropUtil;

public class WebCommons {

	public  WebDriver driver= BasePage.getDriver();
	public Properties prop = PropUtil.readPropertyFile("config.properties");

	// to launch the application
	//@BeforeTest(alwaysRun = true,dependsOnMethods= {"setUpBrowser"})
	public void lauchApplication() {
		String url = prop.getProperty("APP_URL");
		driver.get(url);
		String expectedTitle = prop.getProperty("APP_TITLE");
		String actualTitle = driver.getTitle();
		if (!actualTitle.contains(expectedTitle)) {
			Assert.fail("Application launch failed, expected title: "+expectedTitle+"actual title: "+actualTitle);
		}

	}

	// scrolldown to element
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// to click on element
	public void elementClick(WebElement element) {
		scrollToElement(element);
		element.click();

	}

	// to click on hidden elements or non clickable ones
	public void jsClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click;", element);

	}

	// double click on element
	public void doubleClick(WebElement element) {
		scrollToElement(element);
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();

	}

	// right click on element
	public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	// commom method to mousehover the element
	public void mouseHover(WebElement elemet) {
		Actions action = new Actions(driver);
		action.moveToElement(elemet).perform();
	}

	// method to get text from element
	public String getText(WebElement element) {
		scrollToElement(element);
		return element.getText();
	}

	// to select the checkbox
	public void selectCheckbox(WebElement element, boolean status) {
		scrollToElement(element);
		if (element.isSelected() != status) {
			element.click();
		}
	}

	// wait
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// implicit wait
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(Constants.Wait_Time));
	}

	// wait till the element found
	public void waitForElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Wait_Time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// wait till the element found
	public void waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Wait_Time));
		wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, Constants.Wait_Time));
	}
	// dropdown selection by visible text

	public void selectDropDown(WebElement element, String value) {
		scrollToElement(element);
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	// settext method
	public void setText(WebElement element, String value) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(value);
	}

	// TO GET THE CURRENT URL
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	// refresh the page
	public void refreshPage() {
		driver.navigate().refresh();
	}

	// Common method to wait for the alert to be present.
	public void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.Wait_Time));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// Common method to switch to the alert and accept /reject it.
	public void handleAlert(boolean accept) {
		waitForAlert();
		if (accept) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
	}

	// screenshot method for full page
	public static String takeScreenshot(WebDriver driver, String fileName) {

		String screenShotPathpath = System.getProperty("user.dir") + "\\Screenshots\\" + fileName + ".png";
		File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Screenshot, new File(screenShotPathpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenShotPathpath;
		// TODO Auto-generated method stub

	}

	// screenshot method for specific element
	public static String takeScreenshot(WebElement element, String screenShotName) {

		String screenShotPathpath = System.getProperty("user.dir") + "\\Screenshots\\" + screenShotName + ".png";
		File Screenshot = element.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(Screenshot, new File(screenShotPathpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenShotPathpath;
		// TODO Auto-generated method stub

	}
}
