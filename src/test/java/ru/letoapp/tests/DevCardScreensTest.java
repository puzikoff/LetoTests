package ru.letoapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class DevCardScreensTest extends SetUpForSuiteBase{	

	String cardScreenTitle = "Карта";
	
	@Test(priority = 1)
	public void openCardTest() {
		androidNewVersionPopupHandler();
		greetingPopupHandler();
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        protectCodeCheckboxUnckeck();
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getDashboardScreen().isLoadingErrorExist(), "Dashboard screen: Loading ERROR");        
        appManager.getDashboardScreen().openCard(PropertyReader.getProperty("cardName"));
        Assert.assertFalse(appManager.getDashboardScreen().isErrorPopupDisplayed(), "Dashboard screen, open card: Error popup displayed");
        appManager.getCardScreen().waitForVanishUpdateIndicator();
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
        appManager.getCardScreen().getCardTab().holdsBtnClick();
        appManager.getTimelineScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getTimelineScreen().isLoadingErrorExist(), "Blocked funds screen: Loading ERROR");
        appManager.getTimelineScreen().verifyHoldsScreen();
	}
	
	@Test(priority = 30, dependsOnMethods = { "openCardTest" })
	public void blockFundsTest() {
		if(!appManager.getTimelineScreen().getTitleFromActionBar().equals(cardScreenTitle)) {
			appManager.getTimelineScreen().navUpBtnClick();
			appManager.getCardScreen().waitForVanishUpdateIndicator();
		}
	    appManager.getCardScreen().getCardTab().blockFundsSwitchClick();
	    Assert.assertFalse(appManager.getCardScreen().isErrorPopupDisplayed(), "Card screen, turn on block funds: Error popup displayed");
	}
	
	@Test(priority = 40, dependsOnMethods = { "openCardTest" })
	public void unblockFundsTest() {			    
	    appManager.getCardScreen().getCardTab().blockFundsSwitchClick();
	    Assert.assertFalse(appManager.getCardScreen().isErrorPopupDisplayed(), "Card screen, turn on block funds: Error popup displayed");
	}	
	
	@Test(priority = 50, dependsOnMethods = { "openCardTest" })
	public void howWorksBlockFundsScreenTest() {
		appManager.getCardScreen().getCardTab().howWorksBlockFundsBtnClick();
		appManager.getHowWorksBlockFundsScreen().verify();
	}

	@Test(priority = 60, dependsOnMethods = { "openCardTest" })
	public void cardOperationsScreenTest() {
		if(!appManager.getTimelineScreen().getTitleFromActionBar().equals(cardScreenTitle)) {
			appManager.getTimelineScreen().navUpBtnClick();
			appManager.getCardScreen().waitForVanishUpdateIndicator();
		}
        appManager.getCardScreen().getCardTab().cardOperationsClick();
        appManager.getTimelineScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getTimelineScreen().isLoadingErrorExist(), "Card operations screen: Loading ERROR");
        appManager.getTimelineScreen().verifyCardOperationsScreen();        
	}
	
	@Test(priority = 70, dependsOnMethods = { "openCardTest" })
	public void mandatoryPaymentClickabilityTest() {
		if(!appManager.getTimelineScreen().getTitleFromActionBar().equals(cardScreenTitle)) {
			appManager.getTimelineScreen().navUpBtnClick();
			appManager.getCardScreen().waitForVanishUpdateIndicator();
		}   
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
	    appManager.getWhatIfScreen().whatIfCardLostWidgetClick();
        appManager.getWhatIfScreen().whatIfCardBrokenWidgetClick();
        appManager.getWhatIfScreen().whatIfCardAbroadWidgetClick();
        appManager.getWhatIfScreen().whatIfNoAdditionWidgetClick();
        appManager.getWhatIfScreen().whatIfForgotPINWidgetClick();
        appManager.getWhatIfScreen().whatIfCardNotReturnedWidgetClick();
        appManager.getWhatIfScreen().verifyCardWhatIfScreen();
	} 
	    
	@Test(priority = 90, dependsOnMethods = { "openCardTest" })
	public void howToUseCardScreenTest() {
		if(!appManager.getWhatIfScreen().getTitleFromActionBar().equals(cardScreenTitle)) {
			appManager.getWhatIfScreen().navUpBtnClick();
			appManager.getCardScreen().waitForVanishUpdateIndicator();
		}		
	    appManager.getCardScreen().infoTabClick();
	    appManager.getCardScreen().getCardInfoTab().verify();
	    appManager.getCardScreen().getCardInfoTab().howToUseCardClick();
	    appManager.getHowToUseCardScreen().verify();
	}
	
	@Test(priority = 100, dependsOnMethods = { "openCardTest" })
	public void cardOperationsFromInfoTabTest() {
		if(!appManager.getHowToUseCardScreen().getTitleFromActionBar().equals(cardScreenTitle)) {
			appManager.getHowToUseCardScreen().navUpBtnClick();
			appManager.getCardScreen().waitForVanishUpdateIndicator();
		}		
	    appManager.getCardScreen().getCardInfoTab().cardOperationsClick();
	    appManager.getTimelineScreen().waitForVanishUpdateSpiner();
	    Assert.assertFalse(appManager.getTimelineScreen().isLoadingErrorExist(), "Card operations screen: Loading ERROR");
	    appManager.getTimelineScreen().verifyCardOperationsScreen();
	}
	
	@Test(priority = 110, dependsOnMethods = { "openCardTest" })
	public void blockFundsFromManagementTabTest() {
		if(!appManager.getTimelineScreen().getTitleFromActionBar().equals(cardScreenTitle)) {
			appManager.getTimelineScreen().navUpBtnClick();
			appManager.getCardScreen().waitForVanishUpdateIndicator();
		}
	    appManager.getCardScreen().managementTabClick();
	    appManager.getCardScreen().waitForVanishUpdateIndicator();
	    appManager.getCardScreen().getCardManagementTab().verify();
	    appManager.getCardScreen().getCardManagementTab().blockFundsSwitchClick();
	    Assert.assertFalse(appManager.getCardScreen().isErrorPopupDisplayed(), "Card screen, turn on block funds: Error popup displayed");
	}
	
	@Test(priority = 120, dependsOnMethods = { "openCardTest" })
	public void unblockFundsFromManagementTabTest() {
	    appManager.getCardScreen().getCardManagementTab().blockFundsSwitchClick();
	    Assert.assertFalse(appManager.getCardScreen().isErrorPopupDisplayed(), "Card screen, turn on block funds: Error popup displayed");
	}
	
	@Test(priority = 130, dependsOnMethods = { "openCardTest" })
	public void howWorksBlockFundsScreenFromManagementTabTest() {
		appManager.getCardScreen().getCardManagementTab().howWorksBlockFundsBtnClick();
		appManager.getHowWorksBlockFundsScreen().verify();
	}
	
	@Test(priority = 135, dependsOnMethods = { "openCardTest" })
	public void changePaymentDateTest() {
		if(!appManager.getHowWorksBlockFundsScreen().getTitleFromActionBar().equals(cardScreenTitle)) {
			appManager.getHowWorksBlockFundsScreen().navUpBtnClick();
			appManager.getCardScreen().waitForVanishUpdateIndicator();
		}		
		appManager.getCardScreen().getCardManagementTab().changePayDateWidgetArrowClick();
        appManager.getCardScreen().getCardManagementTab().changePaymentDateBtnClick();
        Assert.assertFalse(appManager.getCardScreen().getCardManagementTab().isErrorPopupDisplayed(), "Card screen, management tab: Error popup displayed");
        appManager.getChangePaymentDateScreen().verifyBeforeCalculation();
        appManager.getChangePaymentDateScreen().chooseNewDate(PropertyReader.getProperty("newCardPaymentDate"));
        appManager.getChangePaymentDateScreen().verifyAfterCalculation();        
	}
	
	@Test(priority = 136, dependsOnMethods = { "changePaymentDateTest" }) 
		public void changePaymentDateCalculationTest() {
			appManager.getChangePaymentDateScreen().chooseNewDate(PropertyReader.getProperty("newCardPaymentDate"));
			appManager.getChangePaymentDateScreen().verifyAfterCalculation();     
	}
	
	@Test(priority = 140, dependsOnMethods = { "openCardTest" })
	public void connectingServicesScreenTest() {
		if(!appManager.getChangePaymentDateScreen().getTitleFromActionBar().equals(cardScreenTitle)) {
			appManager.getChangePaymentDateScreen().navUpBtnClick();
			appManager.getCardScreen().waitForVanishUpdateIndicator();
		}
	    appManager.getCardScreen().getCardManagementTab().connectingServiceHistoryBtnClick();
	    appManager.getTimelineScreen().waitForVanishUpdateSpiner();
	    Assert.assertFalse(appManager.getTimelineScreen().isLoadingErrorExist(), "Connecting services screen: Loading ERROR");
	    appManager.getTimelineScreen().verifyConnectionServicesHistoryScreen();
	    appManager.getTimelineScreen().navUpBtnClick();
	    appManager.getCardScreen().navUpBtnClick();
	    appManager.getDashboardScreen().openDrawer();
	    appManager.getDashboardScreen().getDrawer().exitBtnClick();
	} 

}
