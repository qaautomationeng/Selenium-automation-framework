package com.testautomationframework.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.testautomationframwork.io.InputAndOutputFilePath;

public class TestLogger
{

	public static  Logger log = null;
	
	public static Logger getLoggerObject(Class className) 
	{
		BasicConfigurator.configure();
		log = Logger.getLogger(className);
		Properties property = new Properties();
		try	
		{
			property.setProperty("log4j.appender.File.file", InputAndOutputFilePath.execution_Output_File);
			property.load(new FileInputStream(InputAndOutputFilePath.log4j_Property_File));
			PropertyConfigurator.configure(property);
			log.info("Preparing the Logger Instance");
		}
			catch(FileNotFoundException e)
				{
					log.error("Log File :"+InputAndOutputFilePath.log4j_Property_File);
				}
			catch(IOException e)
				{
					log.error(e);
				}
		return log;
	}
	
	
	
}
