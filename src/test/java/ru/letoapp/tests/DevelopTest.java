package ru.letoapp.tests;

import org.apache.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class DevelopTest extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(DevelopTest.class);

	@Test
	public void developTest() {
		greetingPopupHandler();
		appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        protectCodeCheckboxUnckeck();
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().verifyDashboardScreen();
        appManager.getDashboardScreen().openWallet();
        appManager.getWalletScreen().getWalletTab().paymentBtnClick();
        appManager.getMenuScreen().categoryClick(PropertyReader.getProperty("paymentCategory"));
        appManager.getMenuScreen().delay(6000);
        Assert.assertFalse(appManager.getMenuScreen().isErrorPopupDisplayed(), "Menu screen: Error popup displayed");
      //  appManager.getMenuScreen().searchBy(PropertyReader.getProperty("payment"));        		
        appManager.getMenuScreen().paymentClick(PropertyReader.getProperty("payment"));
        Assert.assertFalse(appManager.getMenuScreen().isErrorPopupDisplayed(), "Menu screen: Error popup displayed");
		appManager.getAccountInfoScreen().enterAccount("9819819898");
		appManager.getAccountInfoScreen().nextBtnClick();
		Assert.assertFalse(appManager.getAccountInfoScreen().isErrorPopupDisplayed(), "Account info screen: Error popup displayed");
		appManager.getAmountScreen().hundredRubBtnClick();
		appManager.getAmountScreen().nextBtnClick();
		Assert.assertFalse(appManager.getAmountScreen().isErrorPopupDisplayed(), "Amount screen: Error popup displayed");
		appManager.getPaymentToolScreen().choosePaymentTool("Мой кошелек");
		appManager.getPaymentToolScreen().nextBtnClick();
		appManager.getPaymentToolScreen().delay();
	}
}
