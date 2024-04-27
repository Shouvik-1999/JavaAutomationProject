package com.tutorialsninja.qa.utilities;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.tutorialsninja.qa.Common.WebSetUp;


public class TakeScreenShots extends WebSetUp {
	
	public static void getScreenShot() {
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshot, new File(ExtentReport.resultPath+"\\image.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
