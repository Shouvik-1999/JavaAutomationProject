package com.tutorialninja.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialninja.qa.Common.WebSetUp;

public class RegisterPage extends WebSetUp {

	//WebElements
	@FindBy(linkText="Register")
	private static WebElement registerOption;

	@FindBy(id="input-firstname")
	private static WebElement registerFirstNameField;

	@FindBy(id="input-lastname")
	private static WebElement registerLastNameField;

	@FindBy(id="input-telephone")
	private static WebElement registerTelePhoneField;

	@FindBy(name="password")
	private static WebElement registerPasswordPhoneField ;

	@FindBy(name="confirm")
	private static WebElement registerconfirmPasswordField ;

	@FindBy(name="agree")
	private static WebElement registerAgreeCheckBox ;

	@FindBy(xpath="//input[@type='submit']")
	private static WebElement registerSubmitButton ;


	//Constructor
	public RegisterPage() {
		PageFactory.initElements(driver , this);
	}

	//Actions
	public static void enterFirstname(String firstName) {
		registerFirstNameField.sendKeys(firstName);
	}

	public static void enterlastname(String lastName) {
		registerLastNameField.sendKeys(lastName);
	}

	public static void enterTelePhone(String telePhone) {
		registerTelePhoneField.sendKeys(telePhone);
	}

	public static void enterRegisterPassword(String password) {
		registerPasswordPhoneField.sendKeys(password);
	}

	public static void enterRegisterConfirmPassword(String password) {
		registerconfirmPasswordField.sendKeys(password);
	}

	public static void clickAgreeCheckBox() {
		registerAgreeCheckBox.click();
	}

	public static void clickRegisterSubmitButton() {
		registerSubmitButton.click();
	}
	public static void registerUserWithMandatoryFields(String firstName,String lastName,String emailId, String telePhone,String password) {
		registerFirstNameField.sendKeys(firstName);
		registerLastNameField.sendKeys(lastName);
		LoginPage.enterEmailID(emailId);
		registerTelePhoneField.sendKeys(telePhone);
		registerPasswordPhoneField.sendKeys(password);
		registerconfirmPasswordField.sendKeys(password);
		clickAgreeCheckBox();
		clickRegisterSubmitButton();

	}

}
