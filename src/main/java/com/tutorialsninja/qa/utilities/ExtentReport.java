package com.tutorialsninja.qa.utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tutorialsninja.qa.Common.WebSetUp;

public class ExtentReport extends WebSetUp {

	public static ExtentReports generateExtentReport() {

		ExtentReports extentReports=new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports");
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
