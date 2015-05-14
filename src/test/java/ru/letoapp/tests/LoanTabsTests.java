package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.utilities.PropertyReader;

public class LoanTabsTests extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(LoanTabsTests.class);
	
	@Test
	public void loanTests() {
		greetingPopupHandler();		                
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        protectCodeCheckboxUnckeck();
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().openLoan("Рабочие сервисы");
        appManager.getLoanScreen().infoTabClick();
        appManager.getLoanScreen().getLoanInfoTab().openDrawer();
        
            }

}
