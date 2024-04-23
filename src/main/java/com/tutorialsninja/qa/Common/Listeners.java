package com.tutorialsninja.qa.Common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utilities.ExtentReport;


public class Listeners implements ITestListener{
	ExtentReports extentReport;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test=extentReport.createTest(result.getName());
		 test.log(Status.INFO, result.getName()+ " Starting Execution");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getName()+ " execution is Successful");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, result.getName()+ " got failed");
	}

	public void onStart(ITestContext context) {
		 extentReport=ExtentReport.generateExtentReport();
		
	}

	public void onFinish(ITestContext context) {
		extentReport.flush();
		
	}
	

}
