package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.utilities.PropertyReader;

public class LoanTabsTests extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(LoanTabsTests.class);
	
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
        appManager.getDashboardScreen().openLoan(1);
        appManager.getLoanScreen().infoTabClick();
        appManager.getLoanScreen().getEditDisplayName().editDisplayNameBtnClick();
        appManager.getLoanScreen().getEditDisplayName().editDisplayName("Просроченный кредит");
        appManager.getLoanScreen().getEditDisplayName().editDisplayNamePopupNextBtnClick();
        appManager.getLoanScreen().navUpBtnClick();
        appManager.getDashboardScreen().openDeposit("Вклад Осенне-Весенний");
        appManager.getDepositScreen().depositInfoTabClick();
        appManager.getDepositScreen().depositTabClick();
        appManager.getDepositScreen().getEditDisplayName().editDisplayNameBtnClick();
        appManager.getDepositScreen().getEditDisplayName().editDisplayName("Вклад Осенне-Весенний");
        appManager.getDepositScreen().getEditDisplayName().editDisplayNamePopupNextBtnClick();
        appManager.getDepositScreen().delay();
    }

}
