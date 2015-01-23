package ru.letoapp.selendroidtests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import ru.letoapp.utilities.SelendroidHelper;

public class TestBase {
	
	SelendroidHelper selendroidHelper = new SelendroidHelper();
	
	@BeforeSuite	   
	public void setUp() throws Exception 
	{
		String appPath = "src/main/resources/Prometheus-0.6.9.8.apk";        
	    boolean forceReinstall = true;
	    boolean clearData = true;	    
	    selendroidHelper.startServer(appPath, forceReinstall, clearData);
	    String appUnderTestId = "ru.letobank.Prometheus:0.6.9.8";
	    String serverUrl = "http://localhost:4444/wd/hub";        
	    selendroidHelper.initDriver(appUnderTestId, serverUrl); 
	}
	
	@AfterSuite
	public void tearDown() {
		selendroidHelper.getDriver().quit();
		selendroidHelper.getServer().stopSelendroid();		
	}
	    
}
