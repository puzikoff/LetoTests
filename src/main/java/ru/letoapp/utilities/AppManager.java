package ru.letoapp.utilities;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import io.selendroid.standalone.log.LogLevelEnum;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.letoapp.screens.ActionBar;
import ru.letoapp.screens.AuthScreen;
import ru.letoapp.screens.CommonTimelineScreen;
import ru.letoapp.screens.ContactsScreen;
import ru.letoapp.screens.CreditCardScreen;
import ru.letoapp.screens.CreditCardsListScreen;
import ru.letoapp.screens.DashboardScreen;
import ru.letoapp.screens.LoanScreen;
import ru.letoapp.screens.LoansListScreen;


public class AppManager {	
	SelendroidConfiguration serverConfig;
	SelendroidLauncher server;
	SelendroidCapabilities capabilities;
	protected static WebDriver driver = null;
	protected static WebDriverWait waitDriver = null;
	private AuthScreen authScreen;
	private DashboardScreen dashboardScreen;
	private ContactsScreen contactsScreen;
	private CommonTimelineScreen commonTimelineScreen;
	private LoansListScreen loansListScreen;
	private LoanScreen loanScreen;
	private CreditCardsListScreen creditCardsListScreen;
	private CreditCardScreen creditCardScreen;
	private ActionBar actionBar;	
		
	public void init() {
		actionBar = new ActionBar(driver);
		authScreen = new AuthScreen(driver);
		dashboardScreen = new DashboardScreen(driver);
		contactsScreen = new ContactsScreen(driver);
		commonTimelineScreen = new CommonTimelineScreen(driver);
		loansListScreen = new LoansListScreen(driver);
		loanScreen = new LoanScreen(driver);
		creditCardsListScreen = new CreditCardsListScreen(driver);
		creditCardScreen = new CreditCardScreen(driver);
		
	}
	
	public AuthScreen getAuthScreen() {
		return authScreen;
	}
	
	public DashboardScreen getDashboardScreen() {
		return dashboardScreen;
	}
	
	public ContactsScreen getContactsScreen() {
		return contactsScreen;
	}
	
	public CommonTimelineScreen getCommonTimelineScreen() {
		return commonTimelineScreen;
	}
	
	public LoansListScreen getLoansListScreen() {
		return loansListScreen;
	}
	
	public LoanScreen getLoanScreen() {
		return loanScreen;
	}
	
	public CreditCardsListScreen getCreditCardsListScreen() {
		return creditCardsListScreen;
	}
	
	public CreditCardScreen getCreditCardScreen() {
		return creditCardScreen;
	}
	
	public void startServer(String appPath, boolean forceReinstall, boolean noClearData) 
	{
		serverConfig = new SelendroidConfiguration();
	    serverConfig.addSupportedApp(appPath);
	    serverConfig.setPort(4444);
	    serverConfig.setSelendroidServerPort(38080);
	    serverConfig.setForceReinstall(forceReinstall);
	    serverConfig.setNoClearData(noClearData);
	    serverConfig.setShouldKeepAdbAlive(true);
	    serverConfig.setPrintHelp(true);
	    serverConfig.setLogLevel(LogLevelEnum.ERROR);
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
	    waitDriver = new WebDriverWait(driver, 90);
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
	
	public void stopServer() {
		
	}
	
	public void stopDriver() {
		if(driver != null) {
			driver.quit();
		}		
		if(server != null) {
			server.stopSelendroid();
		}
	}

	
}
