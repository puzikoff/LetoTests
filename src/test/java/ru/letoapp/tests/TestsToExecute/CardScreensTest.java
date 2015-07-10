package ru.letoapp.tests.TestsToExecute;

import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class CardScreensTest extends SetUpForSuiteBase {	
	
	@Test(description = "CARD. TRANSITIONS BETWEEN SCREENS TEST")
	public void cardScreensTest() {
		greetingPopupHandler();
		appManager.getAuthScreen().verifyAuthScreen();  
	    appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
	    appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
	    protectCodeCheckboxUnckeck();
	    appManager.getAuthScreen().loginBtnClick();
	    appManager.getDashboardScreen().verifyDashboardScreen();
	    appManager.getDashboardScreen().openLoan(PropertyReader.getProperty("cardname"));
	    appManager.getCardScreen().verify();
	    appManager.getCardScreen().getCardTab().expandBtnClick();
	    appManager.getCardScreen().getCardTab().holdsBtnClick();
	    appManager.getTimelineScreen().verifyHoldsScreen();
	    appManager.getTimelineScreen().navUpBtnClick();	    
	    appManager.getCardScreen().getCardTab().blockFundsSwitchClick();	    
	    appManager.getCardScreen().getCardTab().howWorksBlockFundsBtnClick();
	    appManager.getCardScreen().navUpBtnClick();
	    appManager.getCardScreen().getCardTab().cardOperationsClick();
	    appManager.getTimelineScreen().navUpBtnClick();
	    appManager.getCardScreen().getCardTab().whatIfBtnClick();
	    appManager.getCardScreen().navUpBtnClick();
	    appManager.getCardScreen().infoTabClick();
	    appManager.getCardScreen().getCardInfoTab().howToUseCardClick();
	    appManager.getCardScreen().navUpBtnClick();
	    appManager.getCardScreen().getCardInfoTab().cardOperationsClick();
	    appManager.getTimelineScreen().navUpBtnClick();
	    appManager.getCardScreen().managementTabClick();
	    appManager.getCardScreen().getCardManagementTab().blockFundsSwitchClick();
	    appManager.getCardScreen().getCardManagementTab().howWorksBlockFundsBtnClick();
	    appManager.getCardScreen().navUpBtnClick();
	    appManager.getCardScreen().getCardManagementTab().connectingServiceHistoryBtnClick();
	    appManager.getTimelineScreen().navUpBtnClick();
	    appManager.getCardScreen().navUpBtnClick();
	    appManager.getDashboardScreen().openDrawer();
	    appManager.getDashboardScreen().getDrawer().exitBtnClick();
	    Log.info("END OF TEST");
	}
	

}
