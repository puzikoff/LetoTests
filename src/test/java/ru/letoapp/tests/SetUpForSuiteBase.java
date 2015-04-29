package ru.letoapp.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import ru.letoapp.utilities.AppManager;
import ru.letoapp.utilities.PropertyReader;

public class SetUpForSuiteBase {	
	AppManager appManager;	
	
	@BeforeSuite
	public void setUp() throws Exception 
	{		
		boolean forceReinstall = true;
		boolean noClearData = false;
		boolean emulator = false;
		PropertyReader.init("/testconfig.properties");
		appManager = new AppManager();	    	    
	    appManager.startServer(PropertyReader.getProperty("appPath"), forceReinstall, noClearData);	 
	    appManager.initDriver(PropertyReader.getProperty("appUnderTestId"), PropertyReader.getProperty("serverUrl"), emulator); 
	    appManager.init();
	    PropertyReader.init("/sbAccount.properties");
	}		
	
	@AfterSuite
	public void tearDown() throws Exception
	{
		appManager.stopDriver();
		appManager.stopServer();
	}

}
