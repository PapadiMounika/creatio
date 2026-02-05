package com.creatio.crm.application.tests;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.creatio.crm.application.steps.CookiePageSteps;
import com.creatio.crm.framework.Base.BasePage;
import com.creatio.crm.framework.utilities.PropUtil;
import com.creatio.crm.framework.webcommons.WebCommons;
import com.creatio.crm.framework.utilities.ExcelUtil;

public class BaseTest extends BasePage {

	WebCommons webCommons = new WebCommons();
	public WebDriver driver;
	public CookiePageSteps cookiePageSteps;

	@BeforeMethod(alwaysRun = true, dependsOnMethods = { "setUpBrowser" })
	public void intializeAllPages() {
		driver = BasePage.getDriver();
		cookiePageSteps = new CookiePageSteps(driver);

	}

	@DataProvider(name = "testData")
	public String[][] testData(Method method) {
		String[][] data = ExcelUtil.readExcelFile("ExcelData.xlsx", method.getName());
		return data;
	}
}
