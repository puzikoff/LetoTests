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
        Log.info(appManager.getCardScreenCard().getActionBarTitle());
        appManager.getCardScreenCard().getLabelContractState();
        appManager.getCardScreenCard().getDisplayName();
        appManager.getCardScreenCard().editDisplayNameBtnClick();
        appManager.getCardScreenCard().editDisplayName("Momomomomo");
        appManager.getCardScreenCard().editDisplayNamePopupNextBtnClick();
        appManager.getCardScreenCard().getDisplayName();
        appManager.getCardScreenCard().infoTabClick();
        appManager.getCardScreenCard().managementTabClick();
	}
	
}
