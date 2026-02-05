package com.creatio.crm.application.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.creatio.crm.framework.Base.BasePage;

public class CookiePageTests extends BaseTest {

	
	@Test(dataProvider = "testData", priority = 1)
	public void verifyCookieTextIsValid(String expectedText) {

		cookiePageSteps.lauchApplication();
		cookiePageSteps.verifyCookieTitleIsDisplayed();
		cookiePageSteps.verifyCookieTextIsValid(expectedText);
	}
	@Test(priority = 2)
	public void verifyCookiePageIsDisplayed() {
		cookiePageSteps.lauchApplication();
		cookiePageSteps.verifyCookieTitleIsDisplayed();
	}

	

	@Test(priority = 3)
	public void verifyCookieSelectionButtonsDisplayed() {
		cookiePageSteps.lauchApplication();
		cookiePageSteps.verifyCookieTitleIsDisplayed();
		cookiePageSteps.verifyCookieSelectionButtonsDisplayed();
	}

	@Test(priority = 4)
	public void selectCookieButton() {
		cookiePageSteps.lauchApplication();
		cookiePageSteps.verifyCookieTitleIsDisplayed();
		cookiePageSteps.selectCookieButton("accept all");
	}

	@Test(priority = 5)
	public void verifySwitchButtonIsDisplayed() {
		cookiePageSteps.lauchApplication();
		cookiePageSteps.verifyCookieTitleIsDisplayed();
		cookiePageSteps.verifySwitchButtonIsDisplayed();
	}

	@Test(priority = 6)
	public void verifyCreatioLogoAndCookieBotLinkDisplayed() {
		cookiePageSteps.lauchApplication();
		cookiePageSteps.verifyCookieTitleIsDisplayed();
		cookiePageSteps.verifyCreatioLogoAndCookieBotLinkDisplayed();
	}

}
