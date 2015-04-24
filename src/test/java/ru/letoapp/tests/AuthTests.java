package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(AuthTests.class);
	
	@Test
	public void authTests() {
		if(appManager.getAuthScreen().isGreetingMessageDisplayed()) {
    		appManager.getAuthScreen().getGreetingPopup().verifyGreeting();    	
    		appManager.getAuthScreen().getGreetingPopup().nextBtnClick();     	     
    	}                
		appManager.getAuthScreen().loginBtnClick();
		Assert.assertTrue(appManager.getAuthScreen().isEmptyLoginPopupDisplayed());
		appManager.getAuthScreen().getEmptyLoginPopup().verifyPopup();
		appManager.getAuthScreen().getEmptyLoginPopup().nextBtnClick();
		appManager.getAuthScreen().enterUsername("qqqqqq");
		appManager.getAuthScreen().loginBtnClick();
		Assert.assertTrue(appManager.getAuthScreen().isEmptyPasswordPopupDisplayed());
		appManager.getAuthScreen().getEmptyPasswordPopup().verifyPopup();
		appManager.getAuthScreen().getEmptyPasswordPopup().nextBtnClick();
		appManager.getAuthScreen().enterPassword("qqqqqq");
		appManager.getAuthScreen().loginBtnClick();
		appManager.getIncorrectLoginPasswordScreen().contactsBtnClick();
	}

}
