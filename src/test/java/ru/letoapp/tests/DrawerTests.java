package ru.letoapp.tests;

import org.testng.Assert;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.utilities.PropertyReader;

public class DrawerTests extends SetUpForEachTestBase{
	public static final Logger Log = Logger.getLogger(DrawerTests.class);	
	@Test
	public void drawerTests() {
		if(appManager.getAuthScreen().isGreetingMessageDisplayed()) {
    		appManager.getAuthScreen().verifyGreeting();    	
    		appManager.getAuthScreen().closeGreetingMessage();     	     
    	}                
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        if(appManager.getAuthScreen().isProtCodeCheckboxSelected()) {
        	appManager.getAuthScreen().setProtCodeCheckbox();
        }
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().verifyDashboardScreen();        
        appManager.getDashboardScreen().menuBtnClick();
        appManager.getDashboardScreen().drawerContactsBtnClick();
        Assert.assertEquals(appManager.getContactsScreen().getTitleFromActionBar(),"Контакты");
        appManager.getContactsScreen().navUpBtnClick();
        appManager.getDashboardScreen().menuBtnClick();
        appManager.getDashboardScreen().drawerAboutBankBtnClick();        
        Assert.assertEquals(appManager.getAboutBankScreen().getTitleFromActionBar(), "О банке");
        appManager.getAboutBankScreen().aboutBankAndAppBtnClick();
        appManager.getAboutBankAndAppScreen().navUpBtnClick();
        appManager.getDashboardScreen().menuBtnClick();
        appManager.getDashboardScreen().drawerAboutBankBtnClick();
        appManager.getAboutBankScreen().bankRequisitesBtnClick();
        appManager.getBankRequisitesScreen().verifyScreen();
        appManager.getBankRequisitesScreen().navUpBtnClick();
        appManager.getAboutBankScreen().menuBtnClick();
        appManager.getAboutBankScreen().exitBtnClick();		
	}
}
