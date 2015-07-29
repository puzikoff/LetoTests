package ru.letoapp.tests;

import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class DevelopTest extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(DevelopTest.class);

	@Test
	public void developTest() {
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
        appManager.getCardScreen().waitForVanoshUpdateIndicator();
        appManager.getCardScreen().verify();
        appManager.getCardScreen().getCardTab().whatIfBtnClick();
        
        
        
	}
}
