package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.utilities.PropertyReader;

public class ServiceTest extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(ServiceTest.class);

	@Test
	public void serviceTest() {
		greetingPopupHandler();
		appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        protectCodeCheckboxUnckeck();
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().verifyDashboardScreen();
        appManager.getDashboardScreen().openLoan(PropertyReader.getProperty("creditname"));
        appManager.getLoanScreen().managementTabClick();
        appManager.getLoanScreen().getLoanManagementTab().serviceDetailsClick("Уменьшить платёж");
        appManager.getReducePaymentScreen().verify();
        appManager.getReducePaymentScreen().connectBtnClick();
        appManager.getVerificationCodeScreen().openDrawer();
		
		
	}
}
