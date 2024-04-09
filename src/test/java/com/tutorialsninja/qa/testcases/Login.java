package com.tutorialsninja.qa.testcases;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
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
		Assert.assertTrue(driver.findElement(By.linkText("Change your password")).isDisplayed());
		driver.quit();
		
	}
	
	@Test(priority = 2)
	public void verifyLoginWithInvalidCreds() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys("krshouvik"+generateTimeStamp()+"@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12334");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String actualWarning=driver.findElement(By.xpath("//div[contains(@class,'alert')]")).getText();
		String expectedWarning="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualWarning, expectedWarning);
		driver.quit();
		
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
		driver.quit();
	}
	
	
	
	public String generateTimeStamp() {
		Date date=new Date();
		return date.toString().replace(" ", "_");
	}


}
