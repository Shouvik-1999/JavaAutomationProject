package com.tutorialsninja.qa.testcases;


import static com.tutorialsninja.qa.pages.SearchPage.*;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.Common.WebSetUp;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends WebSetUp{
	
	public SearchTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		 webSetup();
		 new SearchPage();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void searchWithValidItem() {
		searchItem(dataProp.getProperty("validSearchItem"));
		Assert.assertTrue(searchValidItemResult(),"No such item found");
	}
	
	@Test(priority = 2)
	public void searchWithInvalidItem() {
		searchItem(dataProp.getProperty("invalidSearchItem"));
		Assert.assertEquals(searchInValidItemResult(), dataProp.getProperty("invalidSearchMessage"));
	}

}
