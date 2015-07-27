package ru.letoapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class DevCardScreensTest extends SetUpForSuiteBase{	
	
	@Test(priority = 1)
	public void openCardTest() {
		greetingPopupHandler();
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        if(appManager.getAuthScreen().isProtCodeCheckboxSelected()) {
        	appManager.getAuthScreen().setProtCodeCheckbox();
        }
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getDashboardScreen().isLoadingErrorExist(), "Dashboard screen: Loading ERROR");
        Log.info("OpenCard");
        appManager.getDashboardScreen().openCard(PropertyReader.getProperty("cardName"));    
        appManager.getCardScreen().waitForVanoshUpdateIndicator();
        appManager.getCardScreen().verify();
        appManager.getCardScreen().getCardTab().verify();
	}
	
	@Test(priority = 2, dependsOnMethods = { "openCardTest" })
	public void blockedFundsScreenTest() {		
        appManager.getCardScreen().getCardTab().expandBtnClick();
        Log.info(appManager.getCardScreen().getCardTab().getOwnFunds());
        Log.info("Open holds");
        appManager.getCardScreen().getCardTab().holdsBtnClick();
        appManager.getTimelineScreen().waitForVanishUpdateSpiner();
        appManager.getTimelineScreen().verifyHoldsScreen();
	}
	
	@Test(priority = 3, dependsOnMethods = { "openCardTest" })
	public void blockFundsTest() {
		appManager.getTimelineScreen().navUpBtnClick();	    
	    appManager.getCardScreen().getCardTab().blockFundsSwitchClick();		
	}
	
	@Test(priority = 4, dependsOnMethods = { "openCardTest" })
	public void unblockFundsTest() {			    
	    appManager.getCardScreen().getCardTab().blockFundsSwitchClick();		
	}	
	
	@Test(priority = 5, dependsOnMethods = { "openCardTest" })
	public void howWorksBlockFundsScreenTest() {
		appManager.getCardScreen().getCardTab().howWorksBlockFundsBtnClick();
		appManager.getHowWorksBlockFundsScreen().verify();
	}

	@Test(priority = 6, dependsOnMethods = { "openCardTest" })
	public void cardOperationsScreenTest() {
		appManager.getTimelineScreen().navUpBtnClick();
        appManager.getCardScreen().getCardTab().cardOperationsClick();
        appManager.getTimelineScreen().waitForVanishUpdateSpiner();
        appManager.getTimelineScreen().verifyCardOperationsScreen();        
	}
	
	@Test(priority = 7, dependsOnMethods = { "openCardTest" })
	public void mandatoryPaymentClickabilityTest() {
		Assert.assertTrue(appManager.getCardScreen().getCardTab().isMandatoryPaymentClickable());
	}
	
	@Test(priority = 8, dependsOnMethods = { "mandatoryPaymentClickabilityTest" })
	public void creditDetailsScreenTest() {
		appManager.getCardScreen().getCardTab().mandatoryPaymentClick();
		//appManager.getCreditDetailsScreen().verify();		
		appManager.getTimelineScreen().navUpBtnClick();
	}	
	
	@Test(priority = 9, dependsOnMethods = { "openCardTest" })
	public void whatIfScreenTest() throws Exception {
		appManager.getCardScreen().getCardTab().scroll();
	    appManager.getCardScreen().getCardTab().whatIfBtnClick();
	   // appManager.getWhatIfCardScreen().verify();
	} 
	    
	@Test(priority = 10, dependsOnMethods = { "openCardTest" })
	public void howToUseCardScreenTest() {
		appManager.getCardScreen().navUpBtnClick();
	    appManager.getCardScreen().infoTabClick();
	    appManager.getCardScreen().getCardInfoTab().verify();
	    appManager.getCardScreen().getCardInfoTab().howToUseCardClick();
	    appManager.getHowToUseCardScreen().verify();
	}
	
	@Test(priority = 11, dependsOnMethods = { "openCardTest" })
	public void cardOperationsFromInfoTabTest() {
		appManager.getCardScreen().navUpBtnClick();
	    appManager.getCardScreen().getCardInfoTab().cardOperationsClick();
	    appManager.getTimelineScreen().waitForVanishUpdateSpiner();
	    appManager.getTimelineScreen().verifyCardOperationsScreen();
	}
	
	@Test(priority = 12, dependsOnMethods = { "openCardTest" })
	public void blockFundsFromManagementTabTest() {
		appManager.getTimelineScreen().navUpBtnClick();
	    appManager.getCardScreen().managementTabClick();
	    appManager.getCardScreen().getCardManagementTab().blockFundsSwitchClick();
	}
	
	@Test(priority = 13, dependsOnMethods = { "openCardTest" })
	public void unblockFundsFromManagementTabTest() {
	    appManager.getCardScreen().getCardManagementTab().blockFundsSwitchClick();
	}
	
	@Test(priority = 14, dependsOnMethods = { "openCardTest" })
	public void howWorksBlockFundsScreenFromManagementTabTest() {
		appManager.getCardScreen().getCardManagementTab().howWorksBlockFundsBtnClick();
		appManager.getHowWorksBlockFundsScreen().verify();
	}
	
	@Test(priority = 15, dependsOnMethods = { "openCardTest" })
	public void connectingServicesScreenTest() {
		appManager.getCardScreen().navUpBtnClick();
	    appManager.getCardScreen().getCardManagementTab().connectingServiceHistoryBtnClick();
	    appManager.getTimelineScreen().waitForVanishUpdateSpiner();
	    appManager.getTimelineScreen().verifyConnectionServicesHistoryScreen();
	    appManager.getTimelineScreen().navUpBtnClick();
	    appManager.getCardScreen().navUpBtnClick();
	    appManager.getDashboardScreen().openDrawer();
	    appManager.getDashboardScreen().getDrawer().exitBtnClick();
	} 

}
