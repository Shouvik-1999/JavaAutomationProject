package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.qa.Common.WebSetUp;

public class HomePage extends WebSetUp {
	
	
	//WebElements
	@FindBy(xpath="//span[text()='My Account']")
	private static WebElement myAccountDropMenu;
	
	@FindBy(linkText="Register")
	private static WebElement registerOption;
	
	@FindBy(linkText="Login")
	private  static WebElement loginOption;
	
	
	
	
	
	
	//Constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action
	public static void clickMyAccntDropDown() {
		myAccountDropMenu.click();
	}
	
	public static void clickLoginOption() {
		loginOption.click();
	}
	
	public static void navigateToLoginPage() {
		myAccountDropMenu.click();
		loginOption.click();
	}
	
	public static void clickRegisterOption() {
		registerOption.click();
	}
	
	public static void navigateToRegisterPage() {
		myAccountDropMenu.click();
		registerOption.click();
	}
	
}
