package ru.letoapp.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import ru.letoapp.utilities.AppManager;
import ru.letoapp.utilities.PropertyReader;

public class SetUpForEachTestBase {	
	AppManager appManager;	
	
	@BeforeSuite
	public void setUpSuite() throws Exception 
	{		
		boolean forceReinstall = true;
		boolean noClearData = false;
		PropertyReader.init("/testconfig.properties");
		appManager = new AppManager();	    	    
	    appManager.startServer(PropertyReader.getProperty("appPath"), forceReinstall, noClearData);	    
	}
			
	@BeforeMethod	   
	public void setUpMethod() throws Exception 
	{		
		appManager = new AppManager();	 
		PropertyReader.init("/testconfig.properties");	
	    appManager.initDriver(PropertyReader.getProperty("appUnderTestId"), PropertyReader.getProperty("serverUrl")); 
	    appManager.init();
	}	
	
	@AfterMethod
	public void tearDownMethod() throws Exception
	{
		appManager.stopDriver();		
	}
	
	@AfterSuite
	public void tearDownSuite() throws Exception
	{		
		appManager.stopServer();
	}

}
