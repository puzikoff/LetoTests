package ru.letoapp.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import ru.letoapp.utilities.AppManager;
import ru.letoapp.utilities.PropertyReader;

public class SetUpForSuiteBase extends TestBase{	
		
	@BeforeSuite
	public void setUp() throws Exception 
	{			
		PropertyReader.init("/testconfig.properties");
		appManager = new AppManager();	    	    
		appManager.startServer(PropertyReader.getProperty("appPath"), 
	    		Boolean.valueOf(PropertyReader.getProperty("forceReinstall")), 
	    		Boolean.valueOf(PropertyReader.getProperty("noClearData")));	   
		appManager.initDriver(PropertyReader.getProperty("appUnderTestId"), 
				  PropertyReader.getProperty("serverUrl"), 
				  Boolean.valueOf(PropertyReader.getProperty("emulator"))); 
	    appManager.init();
	    environoment = PropertyReader.getProperty("environoment");
	    PropertyReader.init("/" + environoment + "Account.properties");
	}		
	
	@AfterSuite
	public void tearDown() throws Exception
	{
		appManager.stopDriver();
		appManager.stopServer();
	}	
}
