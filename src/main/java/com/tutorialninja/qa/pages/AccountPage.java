package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialninja.qa.Common.WebSetUp;

public class AccountPage extends WebSetUp {
	
	//WebElements
	@FindBy(linkText="Change your password")
	private static WebElement changeYourPasswordLink;
	
	
	
	
	
	
	//Constructor
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public static boolean validateUserLogin() {
		boolean actual=changeYourPasswordLink.isDisplayed();
		return actual;
	}

}
