package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.Common.WebSetUp;

public class Search extends WebSetUp{
	
	public Search() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		 webSetup();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void searchWithValidItem() {
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//div[@id='search']/child::span/child::button")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='HP LP3065']")).isDisplayed());
	}
	
	@Test(priority = 2)
	public void serachWithInvalidItem() {
		driver.findElement(By.name("search")).sendKeys("Honda");
		driver.findElement(By.xpath("//div[@id='search']/child::span/child::button")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'no product')]")).getText(), "There is no product that matches the search criteria.");
	}

}
