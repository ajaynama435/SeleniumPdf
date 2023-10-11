package com.qa.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.qa.testscript.TestBase;

public class Reporting extends TestBase implements ITestListener {

	private static String getTestMethodName(ITestResult res) {

		return res.getMethod().getConstructorOrMethod().getName();

	}

	@Override
	public void onStart(ITestContext tcon) {
		System.out.println("Iam in OnStart Method " + tcon.getName());
		tcon.setAttribute("WebDriver", this.driver);
	}

	@Override
	public void onFinish(ITestContext tcon) {
		System.out.println("Iam in OnFinish method" + tcon.getName());
		ExtentManager.extentrep.flush();
	}

	@Override
	public void onTestStart(ITestResult tr) {
		System.out.println("OnTestStart Method is Started " + getTestMethodName(tr));

	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		System.out.println(getTestMethodName(tr) + " test is succeed");

		ExtentTestManager.getTest().log(Status.PASS, "Test Passed");

	}

	
	  @Override 
	  public void onTestFailure(ITestResult tr) {
	  System.out.println(getTestMethodName(tr) + "Test is failed "); 
	  
	  //ExtentTestManager.getTest().log(Status.FAIL," Test Failed ");
	 
	  
	  }
	 
	 

	@Override
	public void onTestSkipped(ITestResult tr) {
		System.out.println("Iam in OnTestSkipped method " + getTestMethodName(tr));

		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

}
