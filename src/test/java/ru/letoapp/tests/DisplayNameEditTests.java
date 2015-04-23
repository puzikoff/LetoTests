package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.utilities.PropertyReader;


public class DisplayNameEditTests extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(DisplayNameEditTests.class);
	
	@Test
	public void displayNameEditPositiveTest() {
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
        appManager.getDashboardScreen().openCard(1);
        Log.info(appManager.getCardScreen().getActionBarTitle());        
        appManager.getCardScreen().getEditDisplayName().getLabelContractState();
        appManager.getCardScreen().getEditDisplayName().getDisplayName();
        appManager.getCardScreen().getEditDisplayName().editDisplayNameBtnClick();
        appManager.getCardScreen().getEditDisplayName().editDisplayName("Momomomomo");
        appManager.getCardScreen().getEditDisplayName().editDisplayNamePopupNextBtnClick();
        appManager.getCardScreen().getEditDisplayName().getDisplayName();
        appManager.getCardScreen().infoTabClick();
        appManager.getCardScreen().managementTabClick();
	}
	
}
