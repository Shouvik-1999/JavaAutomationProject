package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.qa.Common.WebSetUp;

public class AccountSuccessPage extends WebSetUp{
	//WebElements
		@FindBy(xpath="//div[@id='content']//h1")
		private static WebElement accountCreationSuccessMessage;
		
		
	//Constructor
	 public AccountSuccessPage() {
			// TODO Auto-generated constructor stub
			PageFactory.initElements(driver , this);
	 }
	 
	 //Actions
	 public static String getAccountCreationSuccessMessage() {
		 String actualMessage=accountCreationSuccessMessage.getText();
		 return actualMessage;
	 }
		

}
