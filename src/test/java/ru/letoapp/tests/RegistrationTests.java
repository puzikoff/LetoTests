package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import ru.letoapp.utilities.PropertyReader;

public class RegistrationTests extends SetUpForEachTestBase {
	public static final Logger Log = Logger.getLogger(RegistrationTests.class);
	
	@Test(priority=1, description = "REGISTRATION BY CARD. POSITIVE TEST")
	public void registrationByCardPositiveTest() {
		Log.info("REGISTRATION BY CARD POSITIVE TEST STARTS");		 
		Log.info("Auth screen");
    	appManager.getAuthScreen().verifyGreeting();    	
    	appManager.getAuthScreen().closeGreetingMessage();     	                     
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));        
        appManager.getAuthScreen().loginBtnClick();
        Log.info("Incorrect email or password screen");
        appManager.getIncorrectLoginPasswordScreen().tryAgainBtnClick();
        appManager.getAuthScreen().registerBtnClick();
        Log.info("Dbo screen");
        appManager.getDboScreen().menuBtnClick();
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
        appManager.getCardCredentialsScreen().enterCardNumber("0000000000000001"); // correct card number
        appManager.getCardCredentialsScreen().enterAccessCode("010101"); // correct access code for card
        appManager.getCardCredentialsScreen().NextBtnClick();
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
        appManager.getSetPasswordScreen().enterPassword("qwerty");
        appManager.getSetPasswordScreen().isWeakPasswordErrorDisplayed();
        appManager.getSetPasswordScreen().enterPassword("qwerty123");
        appManager.getSetPasswordScreen().confirmPassword("qwerty12");
        appManager.getSetPasswordScreen().isWrongConfirmPasswordErrorDisplayed();
        appManager.getSetPasswordScreen().confirmPassword("qwerty123");
        appManager.getSetPasswordScreen().nextBtnClick();
        Log.info("Set security code screen");
        appManager.getSetSecurityCodeScreen().clickNumber("1");
        appManager.getSetSecurityCodeScreen().clickNumber("2");
        appManager.getSetSecurityCodeScreen().clickNumber("3");
        appManager.getSetSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getConfirmSecurityCodeScreen().clickNumber("1");
        appManager.getConfirmSecurityCodeScreen().clickNumber("2");
        appManager.getConfirmSecurityCodeScreen().clickNumber("3");
        appManager.getConfirmSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");
        appManager.getDashboardScreen().verifyDashboardScreen();
        Log.info("END OF TEST");
	}
	
	@Test(priority=1, description = "REGISTRATION BY ACCOUNT. POSITIVE TEST")
	public void registrationByAccountPositiveTest() {
		Log.info("REGISTRATION BY ACCOUNT POSITIVE TEST STARTS");		 
		Log.info("Auth screen");
    	appManager.getAuthScreen().verifyGreeting();    	
    	appManager.getAuthScreen().closeGreetingMessage();     	                     
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));        
        appManager.getAuthScreen().loginBtnClick();
        Log.info("Incorrect email or password screen");
        appManager.getIncorrectLoginPasswordScreen().tryAgainBtnClick();
        appManager.getAuthScreen().registerBtnClick();
        Log.info("Dbo screen");
        appManager.getDboScreen().menuBtnClick();
        appManager.getDboScreen().sendEmailBtnClick();        
        Log.info("Send email screen");
        appManager.getSendEmailScreen().sendBtnClick();
        appManager.getSendEmailScreen().emptyEmailPopupNextBtnClick();
        appManager.getSendEmailScreen().enterEmail("mail@mail.ru");
        appManager.getSendEmailScreen().sendBtnClick();
        Log.info("Dbo screen"); 
        appManager.getDboScreen().acceptLicenseTerms();
        Log.info("Registration method screen");        
        appManager.getRegistrationMethodScreen().chooseAccount();
        Log.info("Account credentials screen");
        appManager.getAccountCredentialsScreen().enterAccountNumber("0817810000000000005"); // correct account number
        appManager.getAccountCredentialsScreen().enterAccessCode("000000"); // correct access code for account
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
        appManager.getSetPasswordScreen().enterPassword("qwerty");
        appManager.getSetPasswordScreen().isWeakPasswordErrorDisplayed();
        appManager.getSetPasswordScreen().enterPassword("qwerty123");
        appManager.getSetPasswordScreen().confirmPassword("qwerty12");
        appManager.getSetPasswordScreen().isWrongConfirmPasswordErrorDisplayed();
        appManager.getSetPasswordScreen().confirmPassword("qwerty123");
        appManager.getSetPasswordScreen().nextBtnClick();
        Log.info("Set security code screen");
        appManager.getSetSecurityCodeScreen().clickNumber("1");
        appManager.getSetSecurityCodeScreen().clickNumber("2");
        appManager.getSetSecurityCodeScreen().clickNumber("3");
        appManager.getSetSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getConfirmSecurityCodeScreen().clickNumber("1");
        appManager.getConfirmSecurityCodeScreen().clickNumber("2");
        appManager.getConfirmSecurityCodeScreen().clickNumber("3");
        appManager.getConfirmSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");
        appManager.getDashboardScreen().verifyDashboardScreen();
        Log.info("END OF TEST");
	}
	
	@Test(priority=2, description = "FORGOT PASSWORD. REGISTRATION BY CARD. POSITIVE TEST")
	public void forgotPswByCardPositiveTest() {
		Log.info("FORGOT PASSWORD BY CARD POSITIVE TEST STARTS");
		Log.info("Auth screen");
    	appManager.getAuthScreen().verifyGreeting();    	
    	appManager.getAuthScreen().closeGreetingMessage();     	                     
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));        
        appManager.getAuthScreen().loginBtnClick();
        Log.info("Incorrect email or password screen");
        appManager.getIncorrectLoginPasswordScreen().tryAgainBtnClick();
        Log.info("Auth screen");
        appManager.getAuthScreen().remindLogPasBtnClick();
        Log.info("Forgot password/login screen");
        appManager.getForgotPswScreen().getNewCredentialsBtnClick();
        Log.info("Registration method screen");
        appManager.getRegistrationMethodScreen().chooseCard();
        Log.info("Card credentials screen");
        appManager.getCardCredentialsScreen().enterCardNumber("0000000000000001"); // corect card number
        appManager.getCardCredentialsScreen().enterAccessCode("010101"); // correct access code for card
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
        appManager.getSetPasswordScreen().enterPassword("qwerty");
        appManager.getSetPasswordScreen().isWeakPasswordErrorDisplayed();
        appManager.getSetPasswordScreen().enterPassword("qwerty123");
        appManager.getSetPasswordScreen().confirmPassword("qwerty12");
        appManager.getSetPasswordScreen().isWrongConfirmPasswordErrorDisplayed();
        appManager.getSetPasswordScreen().confirmPassword("qwerty123");
        appManager.getSetPasswordScreen().nextBtnClick();
        Log.info("Set security code screen");
        appManager.getSetSecurityCodeScreen().clickNumber("1");
        appManager.getSetSecurityCodeScreen().clickNumber("2");
        appManager.getSetSecurityCodeScreen().clickNumber("3");
        appManager.getSetSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getConfirmSecurityCodeScreen().clickNumber("1");
        appManager.getConfirmSecurityCodeScreen().clickNumber("2");
        appManager.getConfirmSecurityCodeScreen().clickNumber("3");
        appManager.getConfirmSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");
        appManager.getDashboardScreen().verifyDashboardScreen();
        Log.info("END OF TEST");		
	}
	
	@Test(priority=2, description = "FORGOT PASSWORD, REGISTRATION BY ACCOUNT. POSITIVE TEST")
	public void forgotPswByAccountPositiveTest() {
		Log.info("FORGOT PASSWORD BY ACCOUNT POSITIVE TEST STARTS");
		Log.info("Auth screen");
    	appManager.getAuthScreen().verifyGreeting();    	
    	appManager.getAuthScreen().closeGreetingMessage();     	                     
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));        
        appManager.getAuthScreen().loginBtnClick();
        Log.info("Incorrect email or password screen");
        appManager.getIncorrectLoginPasswordScreen().tryAgainBtnClick();
        Log.info("Auth screen");
        appManager.getAuthScreen().remindLogPasBtnClick();
        Log.info("Forgot password/login screen");
        appManager.getForgotPswScreen().getNewCredentialsBtnClick();
        Log.info("Registration method screen");
        appManager.getRegistrationMethodScreen().chooseAccount();
        Log.info("Account credentials screen");
        appManager.getAccountCredentialsScreen().enterAccountNumber("0817810000000000005"); // correct account number
        appManager.getAccountCredentialsScreen().enterAccessCode("000000"); // correct access code for account
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
        appManager.getSetPasswordScreen().enterPassword("qwerty");
        appManager.getSetPasswordScreen().isWeakPasswordErrorDisplayed();
        appManager.getSetPasswordScreen().enterPassword("qwerty123");
        appManager.getSetPasswordScreen().confirmPassword("qwerty12");
        appManager.getSetPasswordScreen().isWrongConfirmPasswordErrorDisplayed();
        appManager.getSetPasswordScreen().confirmPassword("qwerty123");
        appManager.getSetPasswordScreen().nextBtnClick();
        Log.info("Set security code screen");
        appManager.getSetSecurityCodeScreen().clickNumber("1");
        appManager.getSetSecurityCodeScreen().clickNumber("2");
        appManager.getSetSecurityCodeScreen().clickNumber("3");
        appManager.getSetSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getConfirmSecurityCodeScreen().clickNumber("1");
        appManager.getConfirmSecurityCodeScreen().clickNumber("2");
        appManager.getConfirmSecurityCodeScreen().clickNumber("3");
        appManager.getConfirmSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");
        appManager.getDashboardScreen().verifyDashboardScreen();
        Log.info("END OF TEST");		
	}
	
	@Test(priority=2, description = "REGISTRATION BY ACCOUNT. FORGOT ACCOUNT NUMBER OR ACCES CODE. POSITIVE TEST")
	public void forgotAccesOrAccountPositiveTest() {
		Log.info("REGISTRATION. FORGOT ACCOUNT OR ACCES CODE POSITIVE TEST STARTS");
		Log.info("Auth screen");
    	appManager.getAuthScreen().verifyGreeting();    	
    	appManager.getAuthScreen().closeGreetingMessage();     	                     
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));        
        appManager.getAuthScreen().loginBtnClick();
        Log.info("Incorrect email or password screen");
        appManager.getIncorrectLoginPasswordScreen().tryAgainBtnClick();
        appManager.getAuthScreen().registerBtnClick();        
        Log.info("Dbo screen"); 
        appManager.getDboScreen().acceptLicenseTerms();
        Log.info("Registration method screen");        
        appManager.getRegistrationMethodScreen().chooseAccount();
        Log.info("Account credentials screen");
        appManager.getAccountCredentialsScreen().forgotAccountBtnClick();
        Log.info("Forget account or acces code registration screen");
        appManager.getForgotAccountOrAccesCodeScreen().enterAccountNumber("0817810000000000005"); // correct account number
        appManager.getForgotAccountOrAccesCodeScreen().enterAccessCode("000000"); // correct access code for account
        appManager.getForgotAccountOrAccesCodeScreen().NextBtnClick();       
        Log.info("SMS code screen");        
        appManager.getSmsCodeScreen().enterSmsCode("334500");
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
        appManager.getSetSecurityCodeScreen().clickNumber("1");
        appManager.getSetSecurityCodeScreen().clickNumber("2");
        appManager.getSetSecurityCodeScreen().clickNumber("3");
        appManager.getSetSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getConfirmSecurityCodeScreen().clickNumber("1");
        appManager.getConfirmSecurityCodeScreen().clickNumber("2");
        appManager.getConfirmSecurityCodeScreen().clickNumber("3");
        appManager.getConfirmSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");
        appManager.getDashboardScreen().verifyDashboardScreen();
        Log.info("END OF TEST");		
	}
	
	@Test(priority=2, description = "REGISTRATION BY CARD. FORGOT CARD NUMBER OR ACCESS CODE. POSITIVE TEST")
	public void forgotAccesOrCardPositiveTest() {
		Log.info("REGISTRATION. FORGOT CARD NUMBER OR ACCES CODE POSITIVE TEST STARTS");
		Log.info("Auth screen");
    	appManager.getAuthScreen().verifyGreeting();    	
    	appManager.getAuthScreen().closeGreetingMessage();     	                     
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));        
        appManager.getAuthScreen().loginBtnClick();
        Log.info("Incorrect email or password screen");
        appManager.getIncorrectLoginPasswordScreen().tryAgainBtnClick();
        appManager.getAuthScreen().registerBtnClick();        
        Log.info("Dbo screen"); 
        appManager.getDboScreen().acceptLicenseTerms();
        Log.info("Registration method screen");        
        appManager.getRegistrationMethodScreen().chooseCard();
        Log.info("Account credentials screen");
        appManager.getCardCredentialsScreen().forgotCardNumberBtnClick();
        Log.info("Forget account or acces code registration screen");
        appManager.getForgotCardNumberOrAccessCodeScreen().enterCardNumber("0000000000000001"); // correct account number
        appManager.getForgotCardNumberOrAccessCodeScreen().enterAccessCode("010101"); // correct access code for account
        appManager.getForgotCardNumberOrAccessCodeScreen().NextBtnClick();       
        Log.info("SMS code screen");        
        appManager.getSmsCodeScreen().enterSmsCode("334500");
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
        appManager.getSetSecurityCodeScreen().clickNumber("1");
        appManager.getSetSecurityCodeScreen().clickNumber("2");
        appManager.getSetSecurityCodeScreen().clickNumber("3");
        appManager.getSetSecurityCodeScreen().clickNumber("4");
        Log.info("Confirm security code screen");
        appManager.getConfirmSecurityCodeScreen().clickNumber("1");
        appManager.getConfirmSecurityCodeScreen().clickNumber("2");
        appManager.getConfirmSecurityCodeScreen().clickNumber("3");
        appManager.getConfirmSecurityCodeScreen().clickNumber("4");
        Log.info("Dashboard screen");
        appManager.getDashboardScreen().verifyDashboardScreen();
        Log.info("END OF TEST");		
	}

}
