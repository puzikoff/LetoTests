package ru.letoapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.utilities.PropertyReader;

public class RegistrationQuickTest extends SetUpForEachTestBase{
	
	@Test(priority=1, description = "REGISTRATION BY ACCOUNT")
	public void registrationByAccountTest() {
		Log.info("REGISTRATION BY ACCOUNT");		 
		Log.info("Auth screen");
		chooseEnvironoment(environoment);     
        appManager.getAuthScreen().registerBtnClick();       
        Log.info("Dbo screen");
        appManager.getDboScreen().acceptLicenseTerms();        
        Log.info("Registration method screen");        
        appManager.getRegistrationMethodScreen().chooseAccount();
        Log.info("Account credentials screen");
        appManager.getAccountCredentialsScreen().enterAccountNumber(PropertyReader.getProperty("CorrectAccountNumber"));
        appManager.getAccountCredentialsScreen().enterAccessCode(PropertyReader.getProperty("CorrectAccountAccessCode"));
        appManager.getAccountCredentialsScreen().NextBtnClick();        
        Assert.assertFalse(appManager.getAccountCredentialsScreen().isErrorPopupDisplayed(), "Account credentials screen: Error popup displayed");        
        Log.info("SMS code screen");                        
        appManager.getSmsCodeScreen().enterSmsCode(PropertyReader.getProperty("SmsCode"));
        appManager.getSmsCodeScreen().nextBtnClick();
        Assert.assertFalse(appManager.getSmsCodeScreen().isErrorPopupDisplayed(), "Sms code screen: Error popup displayed");
        Log.info("Set login screen");
        appManager.getSetLoginScreen().enterLogin("u" + PropertyReader.getProperty("crmclientid"));
        appManager.getSetLoginScreen().nextBtnClick();        
        Assert.assertFalse(appManager.getSetLoginScreen().isErrorPopupDisplayed(), "Set login screen: Error popup displayed");
        Log.info("Set password screen");
        appManager.getSetPasswordScreen().enterPassword(PropertyReader.getProperty("password"));        
        appManager.getSetPasswordScreen().confirmPassword(PropertyReader.getProperty("password"));        
        appManager.getSetPasswordScreen().nextBtnClick();        
        Assert.assertFalse(appManager.getSetPasswordScreen().isErrorPopupDisplayed(), "Set password screen: Error popup displayed");        
        Log.info("Set security code screen");
        appManager.getSecurityCodeScreen().dismissBtnClick();      
        Assert.assertFalse(appManager.getSecurityCodeScreen().isErrorPopupDisplayed(), "Security code screen: Error popup displayed");
        Log.info("Dashboard screen");        
        appManager.getDashboardScreen().verifyDashboardScreen();
        appManager.getDashboardScreen().openDrawer();
        appManager.getDashboardScreen().getDrawer().exitBtnClick();
        Log.info("END OF TEST");
	}

}
