package ru.letoapp.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class DevelopTest extends SetUpForSuiteBase{	
	
	String paymentDate = "";

	@Test(priority=1)
	public void auth(){		
		androidNewVersionPopupHandler();
		greetingPopupHandler();
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("openPaymentsUsername"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        protectCodeCheckboxUnckeck();
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getDashboardScreen().isLoadingErrorExist(), "Dashboard screen: Loading ERROR");        
	}
	
	@Test(priority = 2, dependsOnMethods = { "auth" } )
	public void openPaymentsAndTransfersScreenTest(){		
		 appManager.getDashboardScreen().paymentsBtnClik();
		 appManager.getPaymentsAndTransfersScreen().systemBackBtnClick();
		 appManager.getDashboardScreen().delay(3000);
	}
}
