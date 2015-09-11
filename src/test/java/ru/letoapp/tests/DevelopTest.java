package ru.letoapp.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class DevelopTest extends SetUpForSuiteBase{		
	String walletTitle = "Мой кошелёк";
	
	@Test(priority = 1)
	public void auth(){		
		androidNewVersionPopupHandler();
		greetingPopupHandler();
        appManager.getAuthScreen().verifyAuthScreen();        
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("zeroWalletUsername"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        protectCodeCheckboxUnckeck();
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getDashboardScreen().isLoadingErrorExist(), "Dashboard screen: Loading ERROR");        
	}
	
	@Test(priority = 10, dependsOnMethods = { "auth" } )
	public void openWalletTest(){				
		appManager.getDashboardScreen().openWallet();
		Assert.assertFalse(appManager.getDashboardScreen().isErrorPopupDisplayed(), "Dashboard screen, open wallet: Error popup displayed");
        appManager.getWalletScreen().waitForVanishUpdateIndicator();
	}
	
}
