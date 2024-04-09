package com.tutorialninja.qa.Common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebSetUp {
	public static WebDriver driver;
	public void webSetup(){
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

}
