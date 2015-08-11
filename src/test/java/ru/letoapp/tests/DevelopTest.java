package ru.letoapp.tests;

import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class DevelopTest extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(DevelopTest.class);

	@Test
	public void developTest() throws UnsupportedEncodingException {		
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
        appManager.getCardScreen().waitForVanishUpdateIndicator();
        appManager.getCardScreen().infoTabClick();
        appManager.getCardScreen().getCardInfoTab().relativeSearch();
        
        /*
        appManager.getTimelineScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getTimelineScreen().isLoadingErrorExist(), "Card operations screen: Loading ERROR");
        appManager.getTimelineScreen().verifyCardOperationsScreen();   
        appManager.getTimelineScreen().navUpBtnClick();
        Log.info(appManager.getCardScreen().getTitleFromActionBar()); 
        */

        
        
        
        
	}
}
