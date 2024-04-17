package com.tutorialsninja.qa.testcases;


import static com.tutorialsninja.qa.utilities.Utilities.generateEmailWithTimeStamp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.Common.WebSetUp;
import com.tutorialninja.qa.pages.AccountSuccessPage;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.LoginPage;
import com.tutorialninja.qa.pages.RegisterPage;

import static com.tutorialninja.qa.pages.HomePage.*;
import static com.tutorialninja.qa.pages.LoginPage.*;
import static com.tutorialninja.qa.pages.RegisterPage.*;
import static com.tutorialninja.qa.pages.AccountSuccessPage.*;




public class Register extends WebSetUp{
	
	public Register() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		webSetup();
		new HomePage();
		new LoginPage();
		new RegisterPage();
		new AccountSuccessPage();
		
	}

	
	@Test(priority = 1)
	public void verifyRegisteringAccountWithMandatoryFields() {
		navigateToRegisterPage();
		registerUserWithMandatoryFields(dataProp.getProperty("firstName"), 
										dataProp.getProperty("lastName"), 
										generateEmailWithTimeStamp(), 
										dataProp.getProperty("telephone"), 
										prop.getProperty("validPassword")
										);
		
		String Actual = getAccountCreationSuccessMessage();
		Assert.assertEquals(Actual,dataProp.getProperty("accountCreationSuccessMessage"),"Account creation Unsuccessful");
	}

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
