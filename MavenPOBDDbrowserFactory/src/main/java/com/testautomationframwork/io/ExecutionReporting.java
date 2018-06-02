package com.testautomationframwork.io;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExecutionReporting {

	ExtentHtmlReporter  extenthtmlreporter;
	ExtentReports extent;
	ExtentTest test;
	
	
	@BeforeTest
	public void startReport()
	{
		extenthtmlreporter = new ExtentHtmlReporter (".\\test-output\\extent_Report.html");
		extenthtmlreporter.loadXMLConfig(".\\extent-config.xml");
		extent = new ExtentReports();
		extent.setSystemInfo("Env", "QA");
		extent.attachReporter(extenthtmlreporter);
				
	}
			
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
}
