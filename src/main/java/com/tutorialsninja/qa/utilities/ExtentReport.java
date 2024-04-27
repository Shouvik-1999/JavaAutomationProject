package com.tutorialsninja.qa.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tutorialsninja.qa.Common.WebSetUp;
import static com.tutorialsninja.qa.utilities.Utilities.*;

public class ExtentReport extends WebSetUp {
	public static String resultPath; 
	
	public static ExtentReports generateExtentReport() {

		ExtentReports extentReports=new ExtentReports();
		resultPath=System.getProperty("user.dir")+"\\results\\"+generateRandomPath();
		File extentReportFile=new File(resultPath);
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Tutorials Ninja Automation Results");
		sparkReporter.config().setDocumentTitle("TN Automation Report");

		extentReports.attachReporter(sparkReporter);


		extentReports.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", prop.getProperty("browser"));
		extentReports.setSystemInfo("Username", prop.getProperty("userName"));
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentReports;
	}
}
