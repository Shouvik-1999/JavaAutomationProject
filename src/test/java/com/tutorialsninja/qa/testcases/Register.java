package com.tutorialsninja.qa.testcases;

import static com.tutorialsninja.qa.utilities.Utilities.generateEmailWithTimeStamp;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.Common.WebSetUp;

public class Register extends WebSetUp{
	
	public Register() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		webSetup();
	}

	
	@Test(priority = 1)
	public void verifyRegisteringAccountWithMandatoryFields() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("Shouvik");
		driver.findElement(By.id("input-lastname")).sendKeys("Kar");
		driver.findElement(By.id("input-email")).sendKeys(generateEmailWithTimeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.name("password")).sendKeys("Skar@1234");
		driver.findElement(By.name("confirm")).sendKeys("Skar@1234");
		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		String Actual=driver.findElement(By.xpath("//div[@id='content']//h1")).getText();
		Assert.assertEquals(Actual, "Your Account Has Been Created!");
	}

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
