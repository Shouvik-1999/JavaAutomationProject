package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialsninja.qa.Common.WebSetUp;

public class SearchPage extends WebSetUp {
	
	
	//WebElements
	@FindBy(name="search")
	private static  WebElement searchBar;
	
	@FindBy(xpath="//div[@id='search']/child::span/child::button")
	private static WebElement searchButton;
	
	@FindBy(xpath="//a[text()='HP LP3065']")
	private static WebElement searchHPItem;
	
	@FindBy(xpath="//p[contains(text(),'no product')]")
	private static WebElement noProductFoundMessage;
	
	
	//Constructor
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public static void searchItem(String item) {
		searchBar.sendKeys(item);
		searchButton.click();
	}
	public static boolean searchValidItemResult() {
		return searchHPItem.isDisplayed();
	}
	public static String searchInValidItemResult() {
		return noProductFoundMessage.getText();
	}
	
	
	
	

}
