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
	
	@Test(priority = 10, dependsOnMethods = { "openCardTest" })
	public void changeDisplayNameTest() {
		appManager.getCardScreen().getEditDisplayName().editDisplayNameBtnClick(); 
		appManager.getCardScreen().getEditDisplayName().getDisplayNameFromEditPopup();
		appManager.getCardScreen().getEditDisplayName().editDisplayName(PropertyReader.getProperty("newCardName"));
		appManager.getCardScreen().getEditDisplayName().editDisplayNamePopupNextBtnClick();
		Assert.assertEquals(appManager.getCardScreen().getEditDisplayName().getDisplayName(), PropertyReader.getProperty("newCardName"));
		appManager.getCardScreen().getEditDisplayName().editDisplayNameBtnClick();
		appManager.getCardScreen().getEditDisplayName().editDisplayName(PropertyReader.getProperty("cardName"));
		appManager.getCardScreen().getEditDisplayName().editDisplayNamePopupNextBtnClick();
		Assert.assertEquals(appManager.getCardScreen().getEditDisplayName().getDisplayName(), PropertyReader.getProperty("cardName")); 
	}
	
	@Test(priority = 20, dependsOnMethods = { "openCardTest" })
	public void blockedFundsScreenTest() {		
        appManager.getCardScreen().getCardTab().expandBtnClick();
        Log.info(appManager.getCardScreen().getCardTab().getOwnFunds());
        Log.info("Open holds");
        appManager.getCardScreen().getCardTab().holdsBtnClick();
        appManager.getTimelineScreen().waitForVanishUpdateSpiner();
        appManager.getTimelineScreen().verifyHoldsScreen();
	}
	
	@Test(priority = 30, dependsOnMethods = { "openCardTest" })
	public void blockFundsTest() {
		appManager.getTimelineScreen().navUpBtnClick();	    
	    appManager.getCardScreen().getCardTab().blockFundsSwitchClick();		
	}
	
	@Test(priority = 40, dependsOnMethods = { "openCardTest" })
	public void unblockFundsTest() {			    
	    appManager.getCardScreen().getCardTab().blockFundsSwitchClick();		
	}	
	
	@Test(priority = 50, dependsOnMethods = { "openCardTest" })
	public void howWorksBlockFundsScreenTest() {
		appManager.getCardScreen().getCardTab().howWorksBlockFundsBtnClick();
		appManager.getHowWorksBlockFundsScreen().verify();
	}

	@Test(priority = 60, dependsOnMethods = { "openCardTest" })
	public void cardOperationsScreenTest() {
		appManager.getTimelineScreen().navUpBtnClick();
        appManager.getCardScreen().getCardTab().cardOperationsClick();
        appManager.getTimelineScreen().waitForVanishUpdateSpiner();
        appManager.getTimelineScreen().verifyCardOperationsScreen();        
	}
	
	@Test(priority = 70, dependsOnMethods = { "openCardTest" })
	public void mandatoryPaymentClickabilityTest() {
		appManager.getTimelineScreen().navUpBtnClick();   
		if(appManager.getCardScreen().getCardTab().isMandatoryPaymentClickable()) {
			appManager.getCardScreen().getCardTab().mandatoryPaymentClick();
			appManager.getCreditDetailsScreen().waitForVanishLoadingIndicator();
			appManager.getCreditDetailsScreen().verify();		
			appManager.getCreditDetailsScreen().navUpBtnClick();			
		}
	}	
	
	@Test(priority = 80, dependsOnMethods = { "openCardTest" })
	public void whatIfScreenTest() throws Exception {		
	    appManager.getCardScreen().getCardTab().whatIfBtnClick();
	   // appManager.getWhatIfCardScreen().verify();
	} 
	    
	@Test(priority = 90, dependsOnMethods = { "openCardTest" })
	public void howToUseCardScreenTest() {
		appManager.getCardScreen().navUpBtnClick();
	    appManager.getCardScreen().infoTabClick();
	    appManager.getCardScreen().getCardInfoTab().verify();
	    appManager.getCardScreen().getCardInfoTab().howToUseCardClick();
	    appManager.getHowToUseCardScreen().verify();
	}
	
	@Test(priority = 100, dependsOnMethods = { "openCardTest" })
	public void cardOperationsFromInfoTabTest() {
		appManager.getCardScreen().navUpBtnClick();
	    appManager.getCardScreen().getCardInfoTab().cardOperationsClick();
	    appManager.getTimelineScreen().waitForVanishUpdateSpiner();
	    appManager.getTimelineScreen().verifyCardOperationsScreen();
	}
	
	@Test(priority = 110, dependsOnMethods = { "openCardTest" })
	public void blockFundsFromManagementTabTest() {
		appManager.getTimelineScreen().navUpBtnClick();
	    appManager.getCardScreen().managementTabClick();
	    appManager.getCardScreen().getCardManagementTab().verify();
	    appManager.getCardScreen().getCardManagementTab().blockFundsSwitchClick();
	}
	
	@Test(priority = 120, dependsOnMethods = { "openCardTest" })
	public void unblockFundsFromManagementTabTest() {
	    appManager.getCardScreen().getCardManagementTab().blockFundsSwitchClick();
	}
	
	@Test(priority = 130, dependsOnMethods = { "openCardTest" })
	public void howWorksBlockFundsScreenFromManagementTabTest() {
		appManager.getCardScreen().getCardManagementTab().howWorksBlockFundsBtnClick();
		appManager.getHowWorksBlockFundsScreen().verify();
	}
	
	@Test(priority = 135, dependsOnMethods = { "openCardTest" })
	public void changePaymentDateTest() {
		appManager.getHowWorksBlockFundsScreen().navUpBtnClick();
		appManager.getCardScreen().getCardManagementTab().changePayDateWidgetArrowClick();
        appManager.getCardScreen().getCardManagementTab().changePaymentDateBtnClick();
        Assert.assertFalse(appManager.getCardScreen().getCardManagementTab().isErrorPopupDisplayed(), "Card screen, management tab: Error popup displayed");
        appManager.getChangePaymentDateScreen().verifyBeforeCalculation();
        appManager.getChangePaymentDateScreen().chooseNewDate(8);
        appManager.getChangePaymentDateScreen().verifyAfterCalculation();
        appManager.getChangePaymentDateScreen().navUpBtnClick();
	}
	
	@Test(priority = 140, dependsOnMethods = { "openCardTest" })
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
