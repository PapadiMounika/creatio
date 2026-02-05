package com.creatio.crm.framework.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.creatio.crm.framework.Base.BasePage;
import com.creatio.crm.framework.utilities.Reports;
import com.creatio.crm.framework.webcommons.WebCommons;



public class TestListeners extends Reports implements ITestListener {

	public void onTestStart(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		startTest(testName);
		logger.info("Test Execution for " + testName + " test is started.");
	}

	public void onTestSuccess(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		logger.pass("Test " + testName + " passed successfully.");
		endReport();
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		logger.fail("Test " + testName + " failed.");
		logger.fail("Reason for Failure: " + result.getThrowable().getMessage());
		try {
			logger.addScreenCaptureFromPath(WebCommons.takeScreenshot(BasePage.getDriver(), testName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		endReport();
	}

}