package ru.letoapp.tests;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class DevelopTest extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(DevelopTest.class);
	
	String paymentDate = "";

	@Test(priority=1)
	public void auth() throws UnsupportedEncodingException {		
		androidNewVersionPopupHandler();
		greetingPopupHandler();
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        protectCodeCheckboxUnckeck();
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getDashboardScreen().isLoadingErrorExist(), "Dashboard screen: Loading ERROR");        
        appManager.getDashboardScreen().openCard(PropertyReader.getProperty("cardName"));
        Assert.assertFalse(appManager.getDashboardScreen().isErrorPopupDisplayed(), "Dashboard screen, open loan: Error popup displayed");
        appManager.getCardScreen().waitForVanishUpdateIndicator();
        
	}
	
	@Test(priority = 2)
	public void developTest() throws UnsupportedEncodingException {
		 appManager.getCardScreen().getCardTab().inLetoBankOfficesClick();
		 appManager.getCardScreen().getCardTab().verify();
		    
	}
}
