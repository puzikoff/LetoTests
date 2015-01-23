package ru.letoapp.utilities;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;

import java.net.URL;

import org.openqa.selenium.WebDriver;

public class SelendroidHelper {
	
	SelendroidConfiguration serverConfig;
	SelendroidLauncher server;
	SelendroidCapabilities capabilities;
	WebDriver driver;   
	
	public void startServer(String appPath, boolean forceReinstall, boolean clearData) 
	{
		serverConfig = new SelendroidConfiguration();
	    serverConfig.addSupportedApp(appPath);
	    serverConfig.setPort(4444);
	    serverConfig.setSelendroidServerPort(38080);
	    serverConfig.setForceReinstall(forceReinstall);
	    serverConfig.setNoClearData(clearData);
	    serverConfig.setShouldKeepAdbAlive(true);
	    serverConfig.setPrintHelp(true);        
	    server = new SelendroidLauncher(serverConfig);
	    server.launchSelendroid();        
	}

	public void initDriver(String appUnderTestId, String serverUrl, String appActivity) throws Exception 
	{
	    capabilities = new SelendroidCapabilities();        
	    capabilities.setAut(appUnderTestId);      
	    capabilities.setLaunchActivity(appActivity);
	    this.driver = new SelendroidDriver(new URL(serverUrl), capabilities);
	} 
	    
	public void initDriver(String appUnderTestId, String serverUrl) throws Exception
	{
	    capabilities = new SelendroidCapabilities();
	    capabilities.setAut(appUnderTestId);      
	    this.driver = new SelendroidDriver(new URL(serverUrl), capabilities);	    
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public SelendroidLauncher getServer() {
		return this.server;
	}

}
