package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.CookiePageElements;

public class CookiePageSteps extends CookiePageElements {

	public CookiePageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verifyCookieTitleIsDisplayed() {
		waitForElement(cookieTitle);

	}

	public void verifyCookieTextIsValid(String expectedText) {
		waitForElement(cookieText);
		String actualText = cookieText.getText();
		Assert.assertEquals(actualText, expectedText, "Cookie text is valid");
	}

	public void verifyCookieSelectionButtonsDisplayed() {
		waitForElement(acceptAllButton);
		waitForElement(allowSelectedButton);
		waitForElement(denyButton);
	}

	public void selectCookieButton(String cookieSelection) {
		switch (cookieSelection.toLowerCase()) {
		case "accept all":
			elementClick(acceptAllButton);
			break;
		case "allow selection":
			elementClick(allowSelectedButton);
			break;
		case "deny":
			elementClick(denyButton);
			break;
		default:
			throw new IllegalArgumentException("Invalid cookie selection: " + cookieSelection);
		}
	}

	public void verifySwitchButtonIsDisplayed() {

		scrollToElement(necessaryCheckbox);
		waitForElement(necessaryCheckbox);
		waitForElement(preferenceCheckbox);
		waitForElement(statisticsCheckbox);
		waitForElement(marketingCheckbox);

	}

	public void verifyCreatioLogoAndCookieBotLinkDisplayed() {
		waitForElement(creatioLogo);
		waitForElement(cookieBot);
	}
	
	public void clickOnShowAllDetailsLink() {
		elementClick(showAllDetailsLink);
	}

	public void verifyCookiesPopUpExpandedViewIsDisplayed() {
		waitForElement(cokkiesPopUpExpandedView);
	}
}
