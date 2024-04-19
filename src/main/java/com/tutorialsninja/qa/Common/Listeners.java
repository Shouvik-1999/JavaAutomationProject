package com.tutorialsninja.qa.Common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Starting Execution of Test: "+result.getName());
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Failed");
		
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Passed: "+result.getName());
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("********Starting Execution********");
	}
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Execution Ended");
		
	}

}
