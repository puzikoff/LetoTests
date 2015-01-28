package ru.letoapp.utilities;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelendroidHelper {
	
	SelendroidConfiguration serverConfig;
	SelendroidLauncher server;
	SelendroidCapabilities capabilities;
	protected static WebDriver driver = null;
	protected static WebDriverWait waitDriver = null;
	
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
	    driver = new SelendroidDriver(new URL(serverUrl), capabilities);
	    waitDriver = new WebDriverWait(driver, 90);
	} 
	    
	public void initDriver(String appUnderTestId, String serverUrl) throws Exception
	{
	    capabilities = new SelendroidCapabilities();
	    capabilities.setAut(appUnderTestId);      
	    driver = new SelendroidDriver(new URL(serverUrl), capabilities);	    
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebDriverWait getWaitDriver() {
		return waitDriver;
	}
	
	public SelendroidLauncher getServer() {
		return this.server;
	}

}
