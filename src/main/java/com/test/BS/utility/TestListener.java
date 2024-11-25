package com.test.BS.utility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestListener extends Utility implements ITestListener{
	public ExtentSparkReporter sparkreporter; //UI of report
	public ExtentReports extent; //update information in the report
	public ExtentTest test; //create  and update test case entries in the report
	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/MyReport.html");
		sparkreporter.config().setDocumentTitle("Automation testing Report");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("Tester name", "Akshat Rana");
	}
	


	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("The testcase has started = "+result.getName());
	}



	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent.createTest(result.getName());
		test.log(Status.PASS, "The Testcase is passed  "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent.createTest(result.getName());
		test.log(Status.SKIP, "The Testcase is skipped  "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			takeScreenshotAtEndOfTest(result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test= extent.createTest(result.getName());
		test.log(Status.FAIL, "The Testcase is failed  "+result.getName());		
		
	}
	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}
	
	

}
