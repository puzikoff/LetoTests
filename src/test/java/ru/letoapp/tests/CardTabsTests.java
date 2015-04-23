package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.utilities.PropertyReader;

public class CardTabsTests extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(CardTabsTests.class);
	
	@Test
	public void cardTabsPositiveTest() {
		if(appManager.getAuthScreen().isGreetingMessageDisplayed()) {
    		appManager.getAuthScreen().getGreetingPopup().verifyGreeting();    	
    		appManager.getAuthScreen().getGreetingPopup().nextBtnClick();     	     
    	}                
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        if(appManager.getAuthScreen().isProtCodeCheckboxSelected()) {
        	appManager.getAuthScreen().setProtCodeCheckbox();
        }
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().openCard("Visa Gold Zero11");
        appManager.getCardScreen().infoTabClick();
        appManager.getCardScreen().managementTabClick();
        appManager.getCardScreen().cardTabClick();
        appManager.getCardScreen().getCardTab().expandBtnClick();
        Log.info(appManager.getCardScreen().getCardTab().getOwnFunds());
	}

}
