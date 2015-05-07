package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.Assert;

import ru.letoapp.utilities.AppManager;
import ru.letoapp.utilities.PropertyReader;
import ru.letoapp.utilities.TestsHelper;

public class TestBase {
public static final Logger Log = Logger.getLogger(TestBase.class);	
	public String environoment;
	AppManager appManager;	
	
	public void chooseEnvironoment(String env) {
		if(env.equals("sb")) {
			Log.info("Choose SB environoment");
			if(appManager.getAuthScreen().isGreetingMessageDisplayed()) {
	    		appManager.getAuthScreen().getGreetingPopup().verifyGreeting();    	
	    		appManager.getAuthScreen().getGreetingPopup().nextBtnClick();	    		
	    	}                
	        appManager.getAuthScreen().verifyAuthScreen();         
	        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
	        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("badPassword"));
	        if(appManager.getAuthScreen().isProtCodeCheckboxSelected()) {
	        	appManager.getAuthScreen().setProtCodeCheckbox();
	        }
	        appManager.getAuthScreen().loginBtnClick();       
	        Assert.assertFalse(appManager.getAuthScreen().isErrorPopupDisplayed(), "Auth screen: Error popup displayed");
	        Log.info("Incorrect email or password screen");
	        appManager.getIncorrectLoginPasswordScreen().verifyScreen();
	        appManager.getIncorrectLoginPasswordScreen().tryAgainBtnClick();			
		}
		
		if(env.equals("mtest")) {
			Log.info("Choose MTEST environoment");
			if(appManager.getAuthScreen().isGreetingMessageDisplayed()) {
	    		appManager.getAuthScreen().getGreetingPopup().verifyGreeting();    	
	    		appManager.getAuthScreen().getGreetingPopup().nextBtnClick();     	     
	    	}                
	        appManager.getAuthScreen().verifyAuthScreen();         
	        appManager.getAuthScreen().enterUsername(TestsHelper.generateString("qwertyuio123456", 5) + "@mtest");        
	        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("badPassword"));
	        if(appManager.getAuthScreen().isProtCodeCheckboxSelected()) {
	        	appManager.getAuthScreen().setProtCodeCheckbox();
	        }
	        appManager.getAuthScreen().loginBtnClick();       
	        Assert.assertFalse(appManager.getAuthScreen().isErrorPopupDisplayed(), "Auth screen: Error popup displayed");
	        Log.info("Incorrect email or password screen");
	        appManager.getIncorrectLoginPasswordScreen().verifyScreen();
	        appManager.getIncorrectLoginPasswordScreen().tryAgainBtnClick();		
		}
		
		if(env.equals("prod")) {
			Log.info("Choose PROD environoment");
		}
		
		if(env.equals("prod2")) {
			Log.info("Choose PROD2 environoment");			
		}
		
		else
			Log.error("Incorrect environoment value: " + env);
	}	

}
