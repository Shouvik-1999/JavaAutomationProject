package com.tutorialsninja.qa.testcases;

import static com.tutorialsninja.qa.utilities.Utilities.*;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.qa.Common.WebSetUp;
import com.tutorialninja.qa.pages.HomePage;
import com.tutorialninja.qa.pages.LoginPage;
import com.tutorialninja.qa.pages.AccountPage;


import static com.tutorialninja.qa.pages.HomePage.*;
import static com.tutorialninja.qa.pages.LoginPage.*;
import static com.tutorialninja.qa.pages.AccountPage.*;

public class Login extends WebSetUp {

	public Login() {
		super();
	}

	@BeforeMethod
	public void setup() {
		webSetup();
		new HomePage();
		new LoginPage();
		new AccountPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
	@Test(priority = 1)
	public void verfyLoginWithValidCreds() {
		navigateToLoginPage();
		enterEmailID(prop.getProperty("userName"));
		enterPassword(prop.getProperty("validPassword"));
		clickLoginButton();
		Assert.assertTrue(validateUserLogin(),"Login Failed");
	}

	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCreds() {
		navigateToLoginPage();
		enterEmailID(generateEmailWithTimeStamp());
		enterPassword(dataProp.getProperty("invalidPassword"));
		clickLoginButton();
		String actualWarning=retrieveEmailPasswordNotMatchingWarning();
		String expectedWarning=dataProp.getProperty("errorLoginMessage");
		Assert.assertEquals(actualWarning, expectedWarning,"Warning Message Mismatch");
	}

	
	@Test(priority = 3,dataProvider = "getDataProvider")
	public void verifyLoginWithInvalidCreds2(String ID,String Password) {
		navigateToLoginPage();
		enterEmailID(ID);
		enterPassword(Password);
		clickLoginButton();
		String actualWarning=retrieveEmailPasswordNotMatchingWarning();
		String expectedWarning=dataProp.getProperty("errorLoginMessage");
		Assert.assertEquals(actualWarning, expectedWarning,"Warning Message Mismatch");
	}


	@DataProvider
	public  Object[][] getDataProvider() {
		Object[][] data=getData();
		return data;
	}


	@Test(priority = 4)
	public void verifyLoginWithInvalidPass() {
		navigateToLoginPage();
		enterEmailID(prop.getProperty("userName"));
		enterPassword(dataProp.getProperty("invalidPassword"));
		clickLoginButton();
		String actualWarning=retrieveEmailPasswordNotMatchingWarning();
		String expectedWarning=dataProp.getProperty("errorLoginMessage");
		Assert.assertEquals(actualWarning, expectedWarning,"Warning Message Mismatch");
	}



}
