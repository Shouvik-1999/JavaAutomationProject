package com.tutorialninja.qa.Common;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static com.tutorialsninja.qa.utilities.Utilities.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebSetUp {
	public static WebDriver driver;
	public static Properties prop;
	public static Properties dataProp;
	
	public WebSetUp() {
		try {
			FileInputStream fis=new FileInputStream(".\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
			FileInputStream data_fis=new FileInputStream(".\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testData.properties");
			
			prop=new Properties();
			dataProp=new Properties();
			prop.load(fis);
			dataProp.load(data_fis);
		}catch(Exception E) {
			System.out.println(E);
		}
	}
	
	public void webSetup(){
		String browser=prop.getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("Edge")) {
			System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
			}
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT_TIME,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

}
