package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.utilities.PropertyReader;


public class DisplayNameEditTests extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(DisplayNameEditTests.class);
	
	@Test
	public void displayNameEditPositiveTest() {
		if(appManager.getAuthScreen().isGreetingMessageDisplayed()) {
    		appManager.getAuthScreen().verifyGreeting();    	
    		appManager.getAuthScreen().closeGreetingMessage();     	     
    	}                
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        if(appManager.getAuthScreen().isProtCodeCheckboxSelected()) {
        	appManager.getAuthScreen().setProtCodeCheckbox();
        }
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().openCard(1);
        Log.info(appManager.getCardScreen().getActionBarTitle());
        appManager.getCardScreen().getLabelContractState();
        appManager.getCardScreen().getDisplayName();
        appManager.getCardScreen().editDisplayNameBtnClick();
        appManager.getCardScreen().editDisplayName("Momomomomo");
        appManager.getCardScreen().editDisplayNamePopupNextBtnClick();
        appManager.getCardScreen().getDisplayName();
        appManager.getCardScreen().infoTabClick();
        appManager.getCardScreen().managementTabClick();
	}
	
}
