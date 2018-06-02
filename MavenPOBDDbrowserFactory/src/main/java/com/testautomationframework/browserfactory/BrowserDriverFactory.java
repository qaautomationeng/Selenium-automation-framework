package com.testautomationframework.browserfactory;


//import com.notinuse.cla.EnvPropertyReader;
import com.testautomationframework.browsersdriver.ChromeDriverManager;
import com.testautomationframework.browsersdriver.EdgeDriverManager;
import com.testautomationframework.browsersdriver.GeckoDriverManager;
import com.testautomationframework.browsersdriver.AutomationGlobalDriverManager;
import com.testautomationframwork.io.PropertyReader;

/*
 * Class to Manage the New Browser Driver 
 * */

public class BrowserDriverFactory {
	public static AutomationGlobalDriverManager getBrowserDriver() throws Exception 
	{
		AutomationGlobalDriverManager driverManager;
		String type =BrowserDriverFactory.getBrowser();		
        switch (type) {
            case "CHROME":
                driverManager = new ChromeDriverManager();
                break;
            case "FIREFOX":
                driverManager = new GeckoDriverManager();
                break;                
            default:
                driverManager = new EdgeDriverManager();
                break;
        }
        return driverManager;
	}
	
	private static String getBrowser() throws Exception
	{
		String driverName ; 
		driverName = PropertyReader.getData("BROWSER");
		return driverName;
	}
	
}


