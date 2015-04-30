package ru.letoapp.tests;

import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import ru.letoapp.utilities.AppManager;
import ru.letoapp.utilities.PropertyReader;

public class SetUpForEachTestBase {
	public final static Random random = new Random();
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
		boolean emulator = false;
		appManager = new AppManager();	 
		PropertyReader.init("/testconfig.properties");	
	    appManager.initDriver(PropertyReader.getProperty("appUnderTestId"), PropertyReader.getProperty("serverUrl"), emulator); 
	    appManager.init();
	    PropertyReader.init("/mtestAccount.properties");
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
	
	public static String generateString(String characters, int length)
	{
	    char[] text = new char[length];
	    for (int i = 0; i < length; i++)
	    {
	        text[i] = characters.charAt(random.nextInt(characters.length()));
	    }
	    return new String(text);
	}
	

}
