package com.creatio.crm.framework.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.creatio.crm.framework.utilities.Reports;

/**
 * 
 */
public class BasePage extends Reports {

	private static WebDriver driver=null;
	
	//set the browser
	@BeforeMethod(alwaysRun = true)
	@Parameters ("BROWSER")
	public static void setUpBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		} else {
			//Assert.fail("Invalid browser name, please pass the correct browser name");
			System.out.println("Invalid browser name, please pass the correct browser name");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	//get driver instance
	public static WebDriver getDriver() {
		return driver;
	}
	
	@AfterMethod(alwaysRun = true)
	//end the browser
	public static void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
	//set driver instance
	 public static void setDriverInstance(WebDriver driver) {
	      BasePage.driver= driver;
	    }
}
