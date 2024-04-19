package com.tutorialsninja.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.qa.Common.WebSetUp;

public class LoginPage extends WebSetUp {
	
	//WebElements
	@FindBy(id="input-email")
	private static WebElement emailField;
	
	@FindBy(id="input-password")
	private static WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private static WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert')]")
	private static WebElement emailPasswordNotMatchingWarning;
	
	
	
	
	//Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public static void enterEmailID(String email) {
		emailField.sendKeys(email);
	}
	
	public static void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public static void clickLoginButton() {
		loginButton.click();
	}
	
	public static String retrieveEmailPasswordNotMatchingWarning() {
		
		String actualWarning= emailPasswordNotMatchingWarning.getText();
		return actualWarning;
	}
	
	
	

}
