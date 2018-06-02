package com.testautomation.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testautomation.supertest.SuperTestConfig;

public class GoogleTest extends SuperTestConfig
{
	
     @Test
    public void launchTestAutomationGuruTest() {
    //	testlog = extent.createTest("launchTestAutomationGuruTest","Launching Google");
    	 //extentReportbuilder.g
    	testHelper.launchURL("http://google.com");
        testHelper.locateElement("Search_Bar");
        assertEquals("Google",testHelper.getTitleOfPage(),"Page title is matching with expected value");
   //     testlog.log(Status.INFO, "Google1 Test");       
        
        
    }
    
		
		}

