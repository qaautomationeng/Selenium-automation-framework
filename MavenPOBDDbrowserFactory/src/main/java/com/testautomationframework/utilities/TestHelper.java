package com.testautomationframework.utilities;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.notinuse.cla.EnvPropertyReader;
import com.testautomationframework.browserfactory.BrowserDriverFactory;
import com.testautomationframework.browsersdriver.AutomationGlobalDriverManager;
import com.testautomationframwork.io.InputAndOutputFilePath;
import com.testautomationframwork.io.PropertyReader;

public class TestHelper 
{
	public static Properties objectRepository_properties = null;
	public static Properties envRepository_properties = null;
	public static Logger log = null;
	private static WebDriver driver = null;
	private static AutomationGlobalDriverManager browser_driver = null;
	private static TestHelper testHelper = null;
	
	
	public TestHelper() throws FileNotFoundException, Exception
	{
		PropertyReader.loadEnvironmentPropertyFile(InputAndOutputFilePath.env_Property_File);
		PropertyReader.loadEnvironmentPropertyFile(InputAndOutputFilePath.locator_Property_File);
		browser_driver = BrowserDriverFactory.getBrowserDriver();
		driver = browser_driver.getDriver();		
		log = TestLogger.getLoggerObject(TestHelper.class);
		log.info("Helper Object Properties are Set");
	}
	
	public static TestHelper getCommonHelperInstance() throws Throwable 
	{
		TestHelper helper = null;
		if (testHelper == null)
		{
			helper = new TestHelper();
			testHelper = helper;
		}
		return testHelper;
	}
	
	private static String getObjectDetailFromLocatoryProperty(String locatoryKey) throws IOException
	{
	
		String locatorTypeAndValue = PropertyReader.getData(locatoryKey);
		return locatorTypeAndValue;
	
	}
	
	public static String[] extractLocatorTypeAndLocator(String objLocatorName) throws IOException
	{
		
		String locatorTypeAndValue = getObjectDetailFromLocatoryProperty(objLocatorName); 
		String locatorDetail[] = null;
		if(locatorTypeAndValue != null)
		{			
			locatorDetail=locatorTypeAndValue.split("~");
			locatorDetail[0]=locatorDetail[0].toLowerCase();
			log.info("Object "+locatorDetail[0]+" is existing in the Locator Property File");
			log.info("Locator for Object"+locatorDetail[0]+" is "+locatorDetail[1]);
		}
		else
		{
			log.info("Locator is not available in the Locatory property File");
		}
		return locatorDetail;
	}
	
	public static WebElement locateElement(String objLocator)
	{
		WebElement element = null;
		try{
		String locator[] = extractLocatorTypeAndLocator(objLocator);
		String locatorType = locator[0];
		String locatorValue = locator[1];
		switch (locatorType) {
		case "id":
			element = driver.findElement(By.id(locatorValue));
			log.info(locatorValue +" Object is Found in the Location Property File");
			break;
		default:
			log.info("Invalid Locator Type specified in the Locator object repository");
		
		}		
		}
		catch (IOException e)
		{
			log.error(e);
		}
		return element;
	}
	
	public static void launchURL(String URL)
	{
		driver.get(URL);
		log.info("Launching URL "+URL);
	}
	
	public static String getTitleOfPage() 
	{
	  log.info("Page title is :"+ driver.getTitle());
	  return driver.getTitle();
	}
	public static void closeBrowser()
	{
		browser_driver.quitDriver();
		log.info("Browser closed successfully after the test execution");
		
	}
	
}
