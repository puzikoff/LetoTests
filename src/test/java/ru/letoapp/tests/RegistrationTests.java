package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import ru.letoapp.utilities.PropertyReader;

public class RegistrationTests extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(RegistrationTests.class);	
	
	@Test(priority=1, description = "REGISTRATION BY CARD. POSITIVE TEST")
	public void registrationByCardPositiveTest() {
		Log.info("REGISTRATION BY CARD POSITIVE TEST STARTS");		 
		Log.info("Auth screen");
    	if(appManager.getAuthScreen().isGreetingMessageDisplayed()) {
    		appManager.getAuthScreen().verifyGreeting();    	
    		appManager.getAuthScreen().closeGreetingMessage();     	     
    	}                
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("badPassword"));
        if(appManager.getAuthScreen().isProtCodeCheckboxSelected()) {
        	appManager.getAuthScreen().setProtCodeCheckbox();
        }
        appManager.getAuthScreen().loginBtnClick();
        Log.info("Incorrect email or password screen");
        appManager.getIncorrectLoginPasswordScreen().tryAgainBtnClick();
        appManager.getAuthScreen().registerBtnClick();
        Log.info("Dbo screen");
        appManager.getDboScreen().contextMenuBtnClick();
        appManager.getDboScreen().sendEmailBtnClick();        
        Log.info("Send email screen");
        appManager.getSendEmailScreen().sendBtnClick();
        appManager.getSendEmailScreen().emptyEmailPopupNextBtnClick();
        appManager.getSendEmailScreen().enterEmail("mail@mail.ru");
        appManager.getSendEmailScreen().sendBtnClick();
        Log.info("Dbo screen"); 
        appManager.getDboScreen().acceptLicenseTerms();
        Log.info("Registration method screen");
        appManager.getRegistrationMethodScreen().chooseCard();        
        Log.info("Card credentials screen");
        appManager.getCardCredentialsScreen().enterCardNumber(PropertyReader.getProperty("sbCorrectCardNumber")); 
        appManager.getCardCredentialsScreen().enterAccessCode(PropertyReader.getProperty("sbCorrectCardAccessCode")); 
        appManager.getCardCredentialsScreen().NextBtnClick();
        Log.info("SMS code screen");
        //appManager.getSmsCodeScreen().sendSmsAgainBtnClick();
        //appManager.getSmsCodeScreen().nextBtnClick();
        //appManager.getSmsCodeScreen().emptyFieldNextBtnClick();
        appManager.getSmsCodeScreen().enterSmsCode(PropertyReader.getProperty("sbSmsCode"));
        appManager.getSmsCodeScreen().nextBtnClick();
        Log.info("Set login screen");
        appManager.getSetLoginScreen().enterLogin("newLogin");
        appManager.getSetLoginScreen().nextBtnClick();
        Log.info("Set password screen");
        appManager.getSetPasswordScreen().enterPassword("qwerty");
        appManager.getSetPasswordScreen().isWeakPasswordErrorDisplayed();
        appManager.getSetPasswordScreen().enterPassword("qwerty123");
        appManager.getSetPasswordScreen().confirmPassword("qwerty12");
        appManager.getSetPasswordScreen().isWrongConfirmPasswordErrorDisplayed();
        appManager.getSetPasswordScreen().confirmPassword("qwerty123");
        appManager.getSetPasswordScreen().nextBtnClick();
        Log.info("Set security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");        
        appManager.getDashboardScreen().verifyDashboardScreen();
        appManager.getDashboardScreen().openDrawer();
        appManager.getDashboardScreen().getDrawer().exitBtnClick();
        Log.info("END OF TEST");
	}
	
	@Test(priority=2, description = "REGISTRATION BY ACCOUNT. POSITIVE TEST")
	public void registrationByAccountPositiveTest() {
		Log.info("REGISTRATION BY ACCOUNT POSITIVE TEST STARTS");		 
		Log.info("Security code screen");                
        appManager.getSecurityCodeScreen().remindSecurityCodeBtnClick();
        Log.info("Remind security code screen screen");
        appManager.getResetSecurityCodeScreen().resetSecurityCodeBtnClick();
        Log.info("Auth screen");
        appManager.getAuthScreen().registerBtnClick();
        Log.info("Dbo screen");
        appManager.getDboScreen().acceptLicenseTerms();
        Log.info("Registration method screen");        
        appManager.getRegistrationMethodScreen().chooseAccount();
        Log.info("Account credentials screen");
        appManager.getAccountCredentialsScreen().enterAccountNumber(PropertyReader.getProperty("sbCorrectAccountNumber"));
        appManager.getAccountCredentialsScreen().enterAccessCode(PropertyReader.getProperty("sbCorrectAccountAccessCode"));
        appManager.getAccountCredentialsScreen().NextBtnClick();
        Log.info("SMS code screen");
        //appManager.getSmsCodeScreen().sendSmsAgainBtnClick();
        //appManager.getSmsCodeScreen().nextBtnClick();
        //appManager.getSmsCodeScreen().emptyFieldNextBtnClick();
        appManager.getSmsCodeScreen().enterSmsCode("334500");
        appManager.getSmsCodeScreen().nextBtnClick();
        Log.info("Set login screen");
        appManager.getSetLoginScreen().enterLogin("newLogin");
        appManager.getSetLoginScreen().nextBtnClick();
        Log.info("Set password screen");
        appManager.getSetPasswordScreen().enterPassword("qwerty123");        
        appManager.getSetPasswordScreen().confirmPassword("qwerty123");        
        appManager.getSetPasswordScreen().nextBtnClick();
        Log.info("Set security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");        
     appManager.getDashboardScreen().verifyDashboardScreen();
        appManager.getDashboardScreen().openDrawer();
        appManager.getDashboardScreen().getDrawer().exitBtnClick();
        Log.info("END OF TEST");
	}
	
	@Test(priority=2, description = "FORGOT PASSWORD. REGISTRATION BY CARD. POSITIVE TEST")
	public void forgotPswByCardPositiveTest() {
		Log.info("FORGOT PASSWORD BY CARD POSITIVE TEST STARTS");
		Log.info("Security code screen");                
        appManager.getSecurityCodeScreen().remindSecurityCodeBtnClick();
        Log.info("Remind security code screen screen");
        appManager.getResetSecurityCodeScreen().resetSecurityCodeBtnClick();
		Log.info("Auth screen");		
        appManager.getAuthScreen().remindLogPasBtnClick();
        Log.info("Forgot password/login screen");
        appManager.getForgotPswScreen().getNewCredentialsBtnClick();
        Log.info("Registration method screen");
        appManager.getRegistrationMethodScreen().chooseCard();
        Log.info("Card credentials screen");
        appManager.getCardCredentialsScreen().enterCardNumber(PropertyReader.getProperty("sbCorrectCardNumber")); 
        appManager.getCardCredentialsScreen().enterAccessCode(PropertyReader.getProperty("sbCorrectCardAccessCode")); 
        appManager.getCardCredentialsScreen().NextBtnClick();
        Log.info("Dbo screen"); 
        appManager.getDboScreen().acceptLicenseTerms();
        Log.info("SMS code screen");        
        appManager.getSmsCodeScreen().enterSmsCode("334500");
        appManager.getSmsCodeScreen().nextBtnClick();
        Log.info("Set login screen");
        appManager.getSetLoginScreen().enterLogin("newLogin");
        appManager.getSetLoginScreen().nextBtnClick();
        Log.info("Set password screen");
        appManager.getSetPasswordScreen().enterPassword("qwerty123");        
        appManager.getSetPasswordScreen().confirmPassword("qwerty123");
        appManager.getSetPasswordScreen().nextBtnClick();
        Log.info("Set security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");        
       appManager.getDashboardScreen().verifyDashboardScreen();
        appManager.getDashboardScreen().openDrawer();
        appManager.getDashboardScreen().getDrawer().exitBtnClick();
        Log.info("END OF TEST");		
	}
	
	@Test(priority=2, description = "FORGOT PASSWORD, REGISTRATION BY ACCOUNT. POSITIVE TEST")
	public void forgotPswByAccountPositiveTest() {
		Log.info("FORGOT PASSWORD BY ACCOUNT POSITIVE TEST STARTS");
		Log.info("Security code screen");                
        appManager.getSecurityCodeScreen().remindSecurityCodeBtnClick();
        Log.info("Remind security code screen screen");
        appManager.getResetSecurityCodeScreen().resetSecurityCodeBtnClick();
		Log.info("Auth screen");		
        appManager.getAuthScreen().remindLogPasBtnClick();
        Log.info("Forgot password/login screen");
        appManager.getForgotPswScreen().getNewCredentialsBtnClick();
        Log.info("Registration method screen");
        appManager.getRegistrationMethodScreen().chooseAccount();
        Log.info("Account credentials screen");
        appManager.getAccountCredentialsScreen().enterAccountNumber(PropertyReader.getProperty("sbCorrectAccountNumber"));
        appManager.getAccountCredentialsScreen().enterAccessCode(PropertyReader.getProperty("sbCorrectAccountAccessCode"));
        appManager.getAccountCredentialsScreen().NextBtnClick();
        Log.info("Dbo screen"); 
        appManager.getDboScreen().acceptLicenseTerms();
        Log.info("SMS code screen");        
        appManager.getSmsCodeScreen().enterSmsCode("334500");
        appManager.getSmsCodeScreen().nextBtnClick();
        Log.info("Set login screen");
        appManager.getSetLoginScreen().enterLogin("newLogin");
        appManager.getSetLoginScreen().nextBtnClick();
        Log.info("Set password screen");
        appManager.getSetPasswordScreen().enterPassword("qwerty123");     
        appManager.getSetPasswordScreen().confirmPassword("qwerty123");
        appManager.getSetPasswordScreen().nextBtnClick();
        Log.info("Set security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");        
       appManager.getDashboardScreen().verifyDashboardScreen();
        appManager.getDashboardScreen().openDrawer();
        appManager.getDashboardScreen().getDrawer().exitBtnClick();
        Log.info("END OF TEST");		
	}
	
	@Test(priority=2, description = "REGISTRATION BY ACCOUNT. FORGOT ACCOUNT NUMBER OR ACCES CODE. POSITIVE TEST")
	public void forgotAccesOrAccountPositiveTest() {
		Log.info("REGISTRATION. FORGOT ACCOUNT OR ACCES CODE POSITIVE TEST STARTS");
		Log.info("Security code screen");                
        appManager.getSecurityCodeScreen().remindSecurityCodeBtnClick();
        Log.info("Remind security code screen screen");
        appManager.getResetSecurityCodeScreen().resetSecurityCodeBtnClick();
		Log.info("Auth screen");	
        appManager.getAuthScreen().registerBtnClick();        
        Log.info("Dbo screen"); 
        appManager.getDboScreen().acceptLicenseTerms();
        Log.info("Registration method screen");        
        appManager.getRegistrationMethodScreen().chooseAccount();
        Log.info("Account credentials screen");
        appManager.getAccountCredentialsScreen().forgotAccountBtnClick();
        Log.info("Forget account or acces code registration screen");
        appManager.getForgotAccountOrAccesCodeScreen().enterAccountNumber(PropertyReader.getProperty("sbCorrectAccountNumber"));
        appManager.getForgotAccountOrAccesCodeScreen().enterAccessCode(PropertyReader.getProperty("sbCorrectAccountAccessCode"));
        appManager.getForgotAccountOrAccesCodeScreen().NextBtnClick();       
        Log.info("SMS code screen");        
        appManager.getSmsCodeScreen().enterSmsCode("334500");
        appManager.getSmsCodeScreen().nextBtnClick();
        Log.info("Set login screen");
        appManager.getSetLoginScreen().enterLogin("newLogin");
        appManager.getSetLoginScreen().nextBtnClick();
        Log.info("Set password screen");
        appManager.getSetPasswordScreen().enterPassword("qwerty123");     
        appManager.getSetPasswordScreen().confirmPassword("qwerty123");
        appManager.getSetPasswordScreen().nextBtnClick();
        Log.info("Set security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");        
       appManager.getDashboardScreen().verifyDashboardScreen();
        appManager.getDashboardScreen().openDrawer();
        appManager.getDashboardScreen().getDrawer().exitBtnClick();
        Log.info("END OF TEST");		
	}
	
	@Test(priority=2, description = "REGISTRATION BY CARD. FORGOT CARD NUMBER OR ACCESS CODE. POSITIVE TEST")
	public void forgotAccesOrCardPositiveTest() {
		Log.info("REGISTRATION. FORGOT CARD NUMBER OR ACCES CODE POSITIVE TEST STARTS");
		Log.info("Security code screen");                
        appManager.getSecurityCodeScreen().remindSecurityCodeBtnClick();
        Log.info("Remind security code screen screen");
        appManager.getResetSecurityCodeScreen().resetSecurityCodeBtnClick();
		Log.info("Auth screen");		
        appManager.getAuthScreen().registerBtnClick();        
        Log.info("Dbo screen"); 
        appManager.getDboScreen().acceptLicenseTerms();
        Log.info("Registration method screen");        
        appManager.getRegistrationMethodScreen().chooseCard();
        Log.info("Account credentials screen");
        appManager.getCardCredentialsScreen().forgotCardNumberBtnClick();
        Log.info("Forget account or acces code registration screen");
        appManager.getForgotCardNumberOrAccessCodeScreen().enterCardNumber(PropertyReader.getProperty("sbCorrectCardNumber")); 
        appManager.getForgotCardNumberOrAccessCodeScreen().enterAccessCode(PropertyReader.getProperty("sbCorrectCardAccessCode")); 
        appManager.getForgotCardNumberOrAccessCodeScreen().NextBtnClick();       
        Log.info("SMS code screen");        
        appManager.getSmsCodeScreen().enterSmsCode("334500");
        appManager.getSmsCodeScreen().nextBtnClick();
        Log.info("Set login screen");
        appManager.getSetLoginScreen().enterLogin("newLogin");
        appManager.getSetLoginScreen().nextBtnClick();
        Log.info("Set password screen");
        appManager.getSetPasswordScreen().enterPassword("qwerty123");       
        appManager.getSetPasswordScreen().confirmPassword("qwerty123");
        appManager.getSetPasswordScreen().nextBtnClick();
        Log.info("Set security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getSecurityCodeScreen().clickNumber("1");
        appManager.getSecurityCodeScreen().clickNumber("2");
        appManager.getSecurityCodeScreen().clickNumber("3");
        appManager.getSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");        
       appManager.getDashboardScreen().verifyDashboardScreen();
        appManager.getDashboardScreen().openDrawer();
        appManager.getDashboardScreen().getDrawer().exitBtnClick();
        Log.info("END OF TEST");		
	}

}
