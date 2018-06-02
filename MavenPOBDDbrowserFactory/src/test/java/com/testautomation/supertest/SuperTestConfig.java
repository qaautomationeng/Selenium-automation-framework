package com.testautomation.supertest;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.testautomationframework.utilities.TestHelper;

public class SuperTestConfig 
{
	public static TestHelper testHelper = null;
	public static ExtentHtmlReporter  extenthtmlreporter;
	public static ExtentReports extent;
	public static ExtentTest testlog ;
	//public static ExtentTestNGReportBuilder extentReportbuilder;
	
	@BeforeClass
    public void beforeTest() throws Throwable
    {	
		extenthtmlreporter = new ExtentHtmlReporter(".\\test-output\\extent_Report.html");
		extenthtmlreporter.loadXMLConfig(".\\extent-config.xml");
		extent = new ExtentReports();
		extent.setSystemInfo("Env", "QA");
		extent.attachReporter(extenthtmlreporter);
		// testlog=extent.createTest(testName);
		testHelper = TestHelper.getCommonHelperInstance();
		//extentReportbuilder.
		
		       
    }
	
	@AfterClass
    public void afterMethod() {
       testHelper.closeBrowser();
       extent.flush();
    }
	
	
}
