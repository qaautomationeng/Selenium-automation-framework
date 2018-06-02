package com.testautomationframwork.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.testautomationframework.utilities.TestLogger;


public class PropertyReader {
	private static Properties properties = new Properties();
	private static Logger log = TestLogger.getLoggerObject(PropertyReader.class);
	

		
		public static void loadEnvironmentPropertyFile(String propertyType) 
		{
			InputStream envInputFile = null;
			try{
				File envFile = new File (propertyType);
				envInputFile = new FileInputStream(envFile);
				properties.load(envInputFile);
				log.info("Property File is existing in the specified path");				
			}
				catch(IOException e)
				{
					log.error(e+"Property file does not exist in the Path");
				}	
			finally
			{
				try{
					envInputFile.close();
				}
				catch(IOException e)
				{
				log.error(e+"Not able to close the File");
				}
			}
		}

		
		private static String getProperty(String envKey)
		{
			String detail=null;
			try{
				detail = properties.getProperty(envKey);
				log.info(envKey +" is  existing in the property File with value= "+detail);
			}
			catch (NullPointerException e)
			{
				log.error("Key/Property is missing in the Proerpty file" + e.getMessage());
			}			
				return detail;
			
		}	
						
		public static String getData(String envVariable) throws IOException 
		{	
			
			return getProperty(envVariable);
			
		}
		
}
