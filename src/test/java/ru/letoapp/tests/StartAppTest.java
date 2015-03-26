package ru.letoapp.tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.TestBase;
import ru.letoapp.utilities.DashboardJsonHelper;
import ru.letoapp.utilities.PropertyReader;
import org.apache.log4j.Logger;


public class StartAppTest extends TestBase {
	public static final Logger Log = Logger.getLogger(StartAppTest.class);	
    
    @Test
    public void test() throws Exception {    	
    	String sum = null;
    	String sumJson = null;
    	String holdJson = null;
    	
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
        Log.info("Click Log In");
        appManager.getAuthScreen().loginBtnClick();
        Log.info("Dashboard screen");
        sum = appManager.getDashboardScreen().getCardSum("Картаff");
        Log.error("App Card sum:" + sum);
        sumJson = DashboardJsonHelper.getCardSum("Картаff");        
        Log.error("Json Card sum:" + sumJson);       
        Assert.assertEquals(sum, sumJson);
        appManager.getDashboardScreen().cardsListBtnClick();
        Thread.sleep(1000);
        appManager.getCreditCardsListScreen().navUpBtnClick();
        Thread.sleep(1000);
        appManager.getDashboardScreen().loansListBtnClick();
        Thread.sleep(1000);
        appManager.getLoansListScreen().navUpBtnClick();
        Thread.sleep(1000);
        appManager.getDashboardScreen().depositsListBtnClick();
        Thread.sleep(1000);
        appManager.getLoansListScreen().navUpBtnClick();
        Thread.sleep(1000);
        appManager.getDashboardScreen().timelineBtnClick();
        Thread.sleep(1000);
        
        
            
    } 
}