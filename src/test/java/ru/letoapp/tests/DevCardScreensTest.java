package ru.letoapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class DevCardScreensTest extends SetUpForSuiteBase{	
	
	@Test(priority = 1)
	public void openCardTest() {
		greetingPopupHandler();
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        if(appManager.getAuthScreen().isProtCodeCheckboxSelected()) {
        	appManager.getAuthScreen().setProtCodeCheckbox();
        }
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getDashboardScreen().isLoadingErrorExist(), "Dashboard screen: Loading ERROR");
        Log.info("OpenCard");
        appManager.getDashboardScreen().openCard(PropertyReader.getProperty("cardName"));    
        appManager.getCardScreen().verify();
       // appManager.getCardScreen().getCardTab().verify();
	}
	
	@Test(priority = 2, dependsOnMethods = { "openCardTest" })
	public void blockedFundsScreenTest() {		
        appManager.getCardScreen().getCardTab().expandBtnClick();
        Log.info(appManager.getCardScreen().getCardTab().getOwnFunds());
        Log.info("Open holds");
        appManager.getCardScreen().getCardTab().holdsBtnClick();
        appManager.getTimelineScreen().verifyHoldsScreen();
	}
	
	@Test(priority = 3, dependsOnMethods = { "openCardTest" })
	public void cardOperationsScreenTest() {
		appManager.getTimelineScreen().navUpBtnClick();
        appManager.getCardScreen().getCardTab().cardOperationsClick();
        appManager.getTimelineScreen().verifyCardOperationsScreen();        
	}

}
