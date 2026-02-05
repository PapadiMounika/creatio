package com.creatio.crm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.webcommons.WebCommons;

public class CookiePageElements extends WebCommons {

	
	@FindBy(xpath= "//div[@id='CybotCookiebotDialogBodyContentTitle']")
	public WebElement cookieTitle;
	
	@FindBy(xpath="//div[@id='CybotCookiebotDialogBodyContentText']")
	public WebElement cookieText;
	
	@FindBy(xpath="//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")
	public WebElement acceptAllButton;
	
	@FindBy(xpath="//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowallSelection']")
	public WebElement allowSelectedButton;
	
	@FindBy(xpath="//button[@id='CybotCookiebotDialogBodyButtonDecline']")
	public WebElement denyButton;
	
	@FindBy(xpath="//input[@id='CybotCookiebotDialogBodyLevelButtonNecessary']")
	//input[@id='CybotCookiebotDialogBodyLevelButtonNecessary']
	public WebElement necessaryCheckbox;
	
	@FindBy(xpath="//input[@id='CybotCookiebotDialogBodyLevelButtonPreferences']")
	public WebElement preferenceCheckbox;
	
	@FindBy(xpath="//input[@id='CybotCookiebotDialogBodyLevelButtonStatistics']")
	public WebElement statisticsCheckbox;
	
	@FindBy(xpath="//input[@id='CybotCookiebotDialogBodyLevelButtonMarketing']")
	public WebElement marketingCheckbox;
	
	@FindBy(xpath="//a[@id='CybotCookiebotDialogBodyEdgeMoreDetailsLink']")
	public WebElement showAllDetailsLink;
	
	@FindBy(xpath="//img[@id='CybotCookiebotDialogPoweredbyImage']")
	public WebElement creatioLogo;
	
	@FindBy(xpath="//a[@id='CybotCookiebotDialogPoweredbyCybot']")
	public WebElement cookieBot;
	
	@FindBy(xpath = "//a[@id='CybotCookiebotDialogNavDetails']")
	public WebElement cokkiesPopUpExpandedView;
}
