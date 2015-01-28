package ru.letoapp.selendroidtests;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import ru.letoapp.screens.AuthScreen;
import ru.letoapp.utilities.SelendroidHelper;

public class TestBase {
	
	SelendroidHelper selendroidHelper = new SelendroidHelper();
	AuthScreen authScreen = new AuthScreen();	

	
	@BeforeSuite	   
	public void setUp() throws Exception 
	{
		String appPath = "src/main/resources/Prometheus-0.6.9.11.apk";        
	    boolean forceReinstall = true;
	    boolean clearData = true;	    
	    selendroidHelper.startServer(appPath, forceReinstall, clearData);
	    String appUnderTestId = "ru.letobank.Prometheus:0.6.9.11";
	    String serverUrl = "http://localhost:4444/wd/hub";        
	    selendroidHelper.initDriver(appUnderTestId, serverUrl); 
	}
	
	@AfterSuite
	public void tearDown() {
		if(selendroidHelper.getDriver() != null) {
			selendroidHelper.getDriver().quit();
		}		
		if(selendroidHelper.getServer() != null) {
			selendroidHelper.getServer().stopSelendroid();
		}
	}
	    
}
