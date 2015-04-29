package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.utilities.PropertyReader;

public class AuthTests extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(AuthTests.class);
	
	
	@Test
	public void authTests() {		
		if(appManager.getAuthScreen().isGreetingMessageDisplayed()) {
    		appManager.getAuthScreen().getGreetingPopup().verifyGreeting();    	
    		appManager.getAuthScreen().getGreetingPopup().nextBtnClick();     	     
    	}                
		appManager.getAuthScreen().openDrawer();
		Assert.assertFalse(appManager.getAuthScreen().getDrawer().isExitButtonVisible());
		appManager.getAuthScreen().closeDrawer();
		appManager.getAuthScreen().loginBtnClick();
		Assert.assertTrue(appManager.getAuthScreen().isEmptyLoginPopupDisplayed());
		appManager.getAuthScreen().getEmptyLoginPopup().verifyPopup();
		appManager.getAuthScreen().getEmptyLoginPopup().nextBtnClick();
		appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));
		//appManager.getAuthScreen().loginBtnClick();
		//Assert.assertTrue(appManager.getAuthScreen().isEmptyPasswordPopupDisplayed());
		//appManager.getAuthScreen().getEmptyPasswordPopup().verifyPopup();
		//appManager.getAuthScreen().getEmptyPasswordPopup().nextBtnClick();
		appManager.getAuthScreen().enterPassword("qqqqqq");
		appManager.getAuthScreen().loginBtnClick();
		Assert.assertFalse(appManager.getAuthScreen().isErrorPopupDisplayed(), "Auth screen: Error popup displayed");
		appManager.getIncorrectLoginPasswordScreen().verifyScreen();
		appManager.getIncorrectLoginPasswordScreen().tryAgainBtnClick();
		appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));
		appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));
		appManager.getAuthScreen().loginBtnClick();
		Assert.assertFalse(appManager.getAuthScreen().isErrorPopupDisplayed(), "Auth screen: Error popup displayed");
		appManager.getSecurityCodeScreen().clickNumber("1");
		appManager.getSecurityCodeScreen().clickNumber("2");
		appManager.getSecurityCodeScreen().clickNumber("3");
		appManager.getSecurityCodeScreen().clickNumber("4");
		Assert.assertFalse(appManager.getAuthScreen().isErrorPopupDisplayed(), "Auth screen: Error popup displayed");
		appManager.getDashboardScreen().verifyDashboardScreen();
		appManager.getDashboardScreen().openDrawer();
		appManager.getDashboardScreen().getDrawer().exitBtnClick();
		appManager.getSecurityCodeScreen().clickNumber("1");
		appManager.getSecurityCodeScreen().clickNumber("2");
		appManager.getSecurityCodeScreen().clickNumber("3");
		appManager.getSecurityCodeScreen().clickNumber("4");
		appManager.getDashboardScreen().verifyDashboardScreen();
	}

}
