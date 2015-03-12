package ru.letoapp.tests;

import org.testng.annotations.Test;

import ru.letoapp.tests.TestBase;
import ru.letoapp.utilities.PropertyReader;
import org.apache.log4j.Logger;


public class StartAppTest extends TestBase {
	public static final Logger Log = Logger.getLogger(StartAppTest.class);	
    
    @Test
    public void test() throws Exception {    	
    	if(appManager.getAuthScreen().isGreetingMessageDisplayed()) {
    		Log.info("Verify greeting window");
    		appManager.getAuthScreen().verifyGreeting();
    		Log.info("Click on confirm button");
    		appManager.getAuthScreen().closeGreetingMessage();
    	}                
        Log.info("Verify auth screen");
        appManager.getAuthScreen().verifyAuthScreen();
        Log.info("Check checkbox");
        appManager.getAuthScreen().setProtCodeCheckbox();
        Log.info("Enter username: " + PropertyReader.getProperty("username"));
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));
        Log.info("Enter password: " + PropertyReader.getProperty("password"));
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));
        Log.error(appManager.getAuthScreen().getTitleFromActionBar());
        Log.info("Click Log In");
        appManager.getAuthScreen().loginBtnClick();
        Log.info("Dashboard screen");    
        //appManager.getDashboardScreen().cardBtnClick();
        //appManager.getCreditCardsListScreen().navUpBtnClick();
        //appManager.getDashboardScreen().swipeOpenDrawer();        
    } 
}