package com.creatio.crm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.webcommons.WebCommons;

public class LoginPage extends WebCommons {

	
	@FindBy(xpath= "//span[@class='form-title']")
	public WebElement loginTitle;
	
	@FindBy(xpath= "//input[@aria-label='username']")
		public WebElement businessEmail;

	@FindBy(xpath="//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath="//a[@class='forgot-password-link']")
	public WebElement forgotPasswordButton;
	
	@FindBy(xpath="//crt-button[@class='login-button']")
	public WebElement loginButton;

}
