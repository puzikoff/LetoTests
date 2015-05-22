package ru.letoapp.tests.TestsToExecute;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class LoanScreensTest extends SetUpForSuiteBase{
	public static final Logger Log = Logger.getLogger(LoanScreensTest.class);
	
	@Test(description = "LOAN. TRANSITIONS BETWEEN SCREENS TEST")
	public void loanTests() {
		Log.info("LOAN TRANSITIONS BETWEEN SCREENS TEST STARTS");
		greetingPopupHandler();		                
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("username"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        protectCodeCheckboxUnckeck();
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().verifyDashboardScreen();
        appManager.getDashboardScreen().openLoan(PropertyReader.getProperty("creditname"));
        appManager.getLoanScreen().verify();
        appManager.getLoanScreen().getPaymentTab().paymentScheduleClick();
        appManager.getPaymentsScheduleScreen().verify();
        appManager.getPaymentsScheduleScreen().navUpBtnClick();
        appManager.getLoanScreen().getPaymentTab().whatIfClick();
        appManager.getWhatIfScreen().verify();
        appManager.getWhatIfScreen().navUpBtnClick();
        appManager.getLoanScreen().getPaymentTab().inLetoBankOfficesClick();
        appManager.getInLetoBankOfficesScreen().verify();
        appManager.getInLetoBankOfficesScreen().navUpBtnClick();
        appManager.getLoanScreen().getPaymentTab().anotherBankPaymentClick();
        appManager.getAnotherBankPaymentScreen().verify();
        appManager.getAnotherBankPaymentScreen().navUpBtnClick();
        appManager.getLoanScreen().getPaymentTab().paymentSystemsTerminalsClick();
        appManager.getPaymentsInTerminalsSecreen().verify();
        appManager.getPaymentsInTerminalsSecreen().navUpBtnClick();
        appManager.getLoanScreen().infoTabClick();
        appManager.getLoanScreen().getLoanInfoTab().contractBtnClick();
        appManager.getLoanContractScreen().verify();
        appManager.getLoanContractScreen().navUpBtnClick();
        appManager.getLoanScreen().getLoanInfoTab().creditOperationsBtnClick();
        appManager.getTimelineScreen().verifyLoanOperationsScreen();
        appManager.getTimelineScreen().navUpBtnClick();
        appManager.getLoanScreen().getLoanInfoTab().insuranceBtnClick();
        appManager.getLoanInsuranceScreen().verify();
        appManager.getLoanInsuranceScreen().navUpBtnClick();
        appManager.getLoanScreen().getLoanInfoTab().paymentsScheduleBtnClick();
        appManager.getPaymentsScheduleScreen().verify();
        appManager.getPaymentsScheduleScreen().navUpBtnClick(); 
        appManager.getLoanScreen().managementTabClick();
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
        appManager.getLoanScreen().getLoanManagementTab().serviceDetailsClick("Уменьшить платёж");
        Assert.assertFalse(appManager.getLoanScreen().getLoanManagementTab().isErrorPopupDisplayed(), "Loan screen, management tab: Error popup displayed");
        appManager.getLoanScreen().navUpBtnClick();
        appManager.getLoanScreen().getLoanManagementTab().connectingServicesHistoryBtnClick();
        Assert.assertFalse(appManager.getLoanScreen().getLoanManagementTab().isErrorPopupDisplayed(), "Loan screen, management tab: Error popup displayed");
        appManager.getTimelineScreen().verifyConnectionServicesHistoryScreen();
        appManager.getTimelineScreen().navUpBtnClick();
        appManager.getLoanScreen().navUpBtnClick();
        appManager.getDashboardScreen().openDrawer();
        appManager.getDashboardScreen().getDrawer().exitBtnClick();
        Log.info("END OF TEST");        
    }
}
