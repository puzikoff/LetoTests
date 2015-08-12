package ru.letoapp.tests.TestsToExecute;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class LoanScreensTest extends SetUpForSuiteBase{	

	String loanScreenTitle = "Кредит";
	
	@Test(priority = 1)
	public void openLoanTest() {
		androidNewVersionPopupHandler();
		greetingPopupHandler();
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        protectCodeCheckboxUnckeck();
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getDashboardScreen().isLoadingErrorExist(), "Dashboard screen: Loading ERROR");        
        appManager.getDashboardScreen().openLoan(PropertyReader.getProperty("loanName"));
        Assert.assertFalse(appManager.getDashboardScreen().isErrorPopupDisplayed(), "Dashboard screen, open loan: Error popup displayed");
        appManager.getLoanScreen().waitForVanishUpdateIndicator();
        appManager.getLoanScreen().verify();
        //appManager.getLoanScreen().getPaymentTab().verify();
		
	}
	
	@Test(priority = 5, dependsOnMethods = { "openLoanTest" })
	public void changeDisplayNameTest() {
		appManager.getLoanScreen().getEditDisplayName().editDisplayNameBtnClick(); 
		appManager.getLoanScreen().getEditDisplayName().getDisplayNameFromEditPopup();
		appManager.getLoanScreen().getEditDisplayName().editDisplayName(PropertyReader.getProperty("newLoanName"));
		appManager.getLoanScreen().getEditDisplayName().editDisplayNamePopupNextBtnClick();
		Assert.assertEquals(appManager.getLoanScreen().getEditDisplayName().getDisplayName(), PropertyReader.getProperty("newLoanName"));
		appManager.getLoanScreen().getEditDisplayName().editDisplayNameBtnClick();
		appManager.getLoanScreen().getEditDisplayName().editDisplayName(PropertyReader.getProperty("loanName"));
		appManager.getLoanScreen().getEditDisplayName().editDisplayNamePopupNextBtnClick();
		Assert.assertEquals(appManager.getLoanScreen().getEditDisplayName().getDisplayName(), PropertyReader.getProperty("loanName")); 
	}
	
	@Test(priority = 10, dependsOnMethods = { "openLoanTest" })
	public void openPaymentScheduleTest() {
		appManager.getLoanScreen().getPaymentTab().paymentScheduleClick();
	    appManager.getPaymentsScheduleScreen().verify();	    
	}
	
	@Test(priority = 30, dependsOnMethods = { "openLoanTest" })
	public void openWhatIfScreenTest() {
		if(!appManager.getPaymentsScheduleScreen().getTitleFromActionBar().equals(loanScreenTitle)) {
			appManager.getPaymentsScheduleScreen().navUpBtnClick();
			appManager.getLoanScreen().waitForVanishUpdateIndicator();
		}		
		appManager.getLoanScreen().getPaymentTab().whatIfClick();
        //appManager.getWhatIfScreen().verifyCardWhatIfScreen();
	}
	
	@Test(priority = 40, dependsOnMethods = { "openLoanTest" })
	public void openInLetoBankOfficesScreenTest() {
		if(!appManager.getWhatIfScreen().getTitleFromActionBar().equals(loanScreenTitle)) {
			appManager.getWhatIfScreen().navUpBtnClick();
			appManager.getLoanScreen().waitForVanishUpdateIndicator();
		}			
        appManager.getLoanScreen().getPaymentTab().inLetoBankOfficesClick();
        appManager.getInLetoBankOfficesScreen().verify();
	}
	
	@Test(priority = 50, dependsOnMethods = { "openLoanTest" })
	public void openAnotherBankPaymentScreenTest() {
		if(!appManager.getInLetoBankOfficesScreen().getTitleFromActionBar().equals(loanScreenTitle)) {
			appManager.getInLetoBankOfficesScreen().navUpBtnClick();
			appManager.getLoanScreen().waitForVanishUpdateIndicator();
		}		
        appManager.getLoanScreen().getPaymentTab().anotherBankPaymentClick();
        appManager.getAnotherBankPaymentScreen().verify();
	}
	
	@Test(priority = 60, dependsOnMethods = { "openLoanTest" })
	public void openPaymentSystemsTerminalsScreenTest() {
		if(!appManager.getAnotherBankPaymentScreen().getTitleFromActionBar().equals(loanScreenTitle)) {
			appManager.getAnotherBankPaymentScreen().navUpBtnClick();
			appManager.getLoanScreen().waitForVanishUpdateIndicator();
		}		
        appManager.getLoanScreen().getPaymentTab().paymentSystemsTerminalsClick();
        appManager.getPaymentsInTerminalsSecreen().verify();
	}
        
	@Test(priority = 70, dependsOnMethods = { "openLoanTest" })
	public void openContractScreenTest() {        
		if(!appManager.getPaymentsInTerminalsSecreen().getTitleFromActionBar().equals(loanScreenTitle)) {
			appManager.getPaymentsInTerminalsSecreen().navUpBtnClick();
			appManager.getLoanScreen().waitForVanishUpdateIndicator();
		}		        
        appManager.getLoanScreen().infoTabClick();
        //appManager.getLoanScreen().getLoanInfoTab().verify();
        appManager.getLoanScreen().getLoanInfoTab().contractBtnClick();
        appManager.getLoanContractScreen().verify();
	}
	
	@Test(priority = 80, dependsOnMethods = { "openLoanTest" })
	public void openLoanOperationScreenTest() {
		if(!appManager.getLoanContractScreen().getTitleFromActionBar().equals(loanScreenTitle)) {
			appManager.getLoanContractScreen().navUpBtnClick();
			appManager.getLoanScreen().waitForVanishUpdateIndicator();
		}        
        appManager.getLoanScreen().getLoanInfoTab().creditOperationsBtnClick();
        appManager.getTimelineScreen().verifyLoanOperationsScreen();
	}
	
	@Test(priority = 90, dependsOnMethods = { "openLoanTest" })
	public void openInsuranceScreenTest() {
		if(!appManager.getTimelineScreen().getTitleFromActionBar().equals(loanScreenTitle)) {
			appManager.getTimelineScreen().navUpBtnClick();
			appManager.getLoanScreen().waitForVanishUpdateIndicator();
		}        
        appManager.getLoanScreen().getLoanInfoTab().insuranceBtnClick();
        appManager.getLoanInsuranceScreen().verify();
	}
	
	@Test(priority = 100, dependsOnMethods = { "openLoanTest" })
	public void openPaymentsScheduleScreenFromInfoTabTest() {
		if(!appManager.getLoanInsuranceScreen().getTitleFromActionBar().equals(loanScreenTitle)) {
			appManager.getLoanInsuranceScreen().navUpBtnClick();
			appManager.getLoanScreen().waitForVanishUpdateIndicator();
		}        
        appManager.getLoanScreen().getLoanInfoTab().paymentsScheduleBtnClick();
        appManager.getPaymentsScheduleScreen().verify();
	}
	
	@Test(priority = 110, dependsOnMethods = { "openLoanTest" })
	public void wrapUnwrapServicesWidgetsTest() {
		if(!appManager.getPaymentsScheduleScreen().getTitleFromActionBar().equals(loanScreenTitle)) {
			appManager.getPaymentsScheduleScreen().navUpBtnClick();
			appManager.getLoanScreen().waitForVanishUpdateIndicator();
		}         
        appManager.getLoanScreen().managementTabClick();
        //appManager.getLoanScreen().getLoanManagementTab().verify();
        appManager.getLoanScreen().getLoanManagementTab().unwrapServiceBlock("Автопогашение");        
        appManager.getLoanScreen().getLoanManagementTab().wrapServiceBlock("Автопогашение");
        appManager.getLoanScreen().getLoanManagementTab().unwrapServiceBlock("Частичное досрочное погашение");        
        appManager.getLoanScreen().getLoanManagementTab().wrapServiceBlock("Частичное досрочное погашение");
        appManager.getLoanScreen().getLoanManagementTab().unwrapServiceBlock("Меняю дату платежа");        
        appManager.getLoanScreen().getLoanManagementTab().wrapServiceBlock("Меняю дату платежа");
        appManager.getLoanScreen().getLoanManagementTab().unwrapServiceBlock("Пропустить платёж");        
        appManager.getLoanScreen().getLoanManagementTab().wrapServiceBlock("Пропустить платёж");
        appManager.getLoanScreen().getLoanManagementTab().unwrapServiceBlock("Уменьшить платёж");        
        appManager.getLoanScreen().getLoanManagementTab().wrapServiceBlock("Уменьшить платёж");
	}
	
	//@Test(priority = 120, dependsOnMethods = { "openLoanTest" })
	public void openReducePaymentServiceScreenTest() {
        appManager.getLoanScreen().getLoanManagementTab().serviceDetailsClick("Уменьшить платёж");
        Assert.assertFalse(appManager.getLoanScreen().getLoanManagementTab().isErrorPopupDisplayed(), "Loan screen, management tab: Error popup displayed");
        appManager.getReducePaymentScreen().verify();
	}
	
	@Test(priority = 130, dependsOnMethods = { "openLoanTest" })
	public void openConnectingServicesScreenTest() {
		if(!appManager.getReducePaymentScreen().getTitleFromActionBar().equals(loanScreenTitle)) {
			appManager.getReducePaymentScreen().navUpBtnClick();
			appManager.getLoanScreen().waitForVanishUpdateIndicator();
		}		
        appManager.getLoanScreen().getLoanManagementTab().connectingServicesHistoryBtnClick();
        Assert.assertFalse(appManager.getLoanScreen().getLoanManagementTab().isErrorPopupDisplayed(), "Loan screen, management tab: Error popup displayed");
        appManager.getTimelineScreen().verifyConnectionServicesHistoryScreen();
        appManager.getTimelineScreen().navUpBtnClick();
        appManager.getLoanScreen().navUpBtnClick();
        appManager.getDashboardScreen().openDrawer();
        appManager.getDashboardScreen().getDrawer().exitBtnClick();        
    }
}
