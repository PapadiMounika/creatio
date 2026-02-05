package com.creatio.crm.framework.utilities;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Reports {
	
	public static ExtentHtmlReporter html; //to create HTML report (white paper
	public static ExtentReports extent; //to generate the logs in the report (printer)
	public static ExtentTest logger; //to add logs into it with different level of info (pass, fail, skip, fatal, error, info)
	
	@BeforeSuite(alwaysRun = true)
	//method to setup the report
	public static void setupReport() {
		html = new ExtentHtmlReporter(System.getProperty("user.dir") + "\\Reports\\AutomationReport.html");
		extent = new ExtentReports();
		extent.attachReporter(html);
	}
	
	//method to start printing the logs
	public static void startTest(String testName) {
		logger = extent.createTest(testName);
	}
	
	//method to end the report
	public static void endReport() {
		extent.flush();
	}
}
