package com.tutorialsninja.qa.testcases;

import java.util.Date;
import static com.tutorialsninja.qa.utilities.Utilities.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.qa.Common.WebSetUp;

public class Login extends WebSetUp {

	
	@BeforeMethod
	public void setup() {
		webSetup();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1)
	public void verfyLoginWithValidCreds() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("krshouvik@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Skar@1999");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed(),"Login Failed");
		
		
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCreds() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(generateEmailWithTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("12334");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarning=driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();
		String expectedWarning="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualWarning, expectedWarning);
		
		
	}
	
	@Test(priority = 4)
	public void verifyLoginWithInvalidPass() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("krshouvik@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12334");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarning=driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();
		String expectedWarning="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualWarning, expectedWarning);
		
	}
	


}
