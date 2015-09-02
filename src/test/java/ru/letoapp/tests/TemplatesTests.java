package ru.letoapp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import ru.letoapp.tests.common.SetUpForSuiteBase;
import ru.letoapp.utilities.PropertyReader;

public class TemplatesTests extends SetUpForSuiteBase{
	
	@Test(priority=1)
	public void auth(){		
		androidNewVersionPopupHandler();
		greetingPopupHandler();
        appManager.getAuthScreen().verifyAuthScreen();  
        appManager.getAuthScreen().enterUsername(PropertyReader.getProperty("openPaymentsUsername"));        
        appManager.getAuthScreen().enterPassword(PropertyReader.getProperty("password"));    
        protectCodeCheckboxUnckeck();
        appManager.getAuthScreen().loginBtnClick();
        appManager.getDashboardScreen().waitForVanishUpdateSpiner();
        Assert.assertFalse(appManager.getDashboardScreen().isLoadingErrorExist(), "Dashboard screen: Loading ERROR");        
	}
	
	@Test(priority = 2, dependsOnMethods = { "auth" } )
	public void openPaymentsAndTransfersScreenTest(){		
		 appManager.getDashboardScreen().paymentsBtnClik();
		 //appManager.getPaymentsAndTransfersScreen().verify();
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().addToFavoriteBtnClick("mts");
		 appManager.getPaymentsAndTransfersScreen().navUpBtnClick();		 
		 appManager.getDashboardScreen().openDrawer();
		 Assert.assertTrue(appManager.getPaymentsAndTransfersScreen().getDrawer().isTemplateDisplayed("mts"));
		 appManager.getDashboardScreen().menuBtnClick();
		 appManager.getDashboardScreen().paymentsBtnClik();
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().removeFromFavoriteBtnClick("mts");
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().openTemplateContextMenu("mts");
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().getTemplateContextMenu().renameBtnClick();
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().getEditDisplayNamePopup().editDisplayName("mts mts");
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().getEditDisplayNamePopup().nextBtnClick();
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().openTemplateContextMenu("mts mts");
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().getTemplateContextMenu().renameBtnClick();
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().getEditDisplayNamePopup().editDisplayName("mts");
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().getEditDisplayNamePopup().nextBtnClick();
		 appManager.getPaymentsAndTransfersScreen().paymentsTabBtnClick();
		 appManager.getPaymentsAndTransfersScreen().getPaymentsTab().categoryClick("Услуги связи");		
		 appManager.getPaymentsAndTransfersScreen().getPaymentsTab().flickPaymentsListDown();
		 appManager.getPaymentsAndTransfersScreen().getPaymentsTab().paymentClick("БиЛайн");
		 Assert.assertFalse(appManager.getPaymentsAndTransfersScreen().getPaymentsTab().isErrorPopupDisplayed(), "Payments tab: Error popup displayed");
		 appManager.getAccountInfoScreen().enterAccount("9859859898");
		 appManager.getAccountInfoScreen().nextBtnClick();
		 Assert.assertFalse(appManager.getAccountInfoScreen().isErrorPopupDisplayed(), "Account info screen: Error popup displayed");		 
		 appManager.getAmountScreen().tenRubBtnClick();
		 appManager.getAmountScreen().hundredRubBtnClick();
		 appManager.getAmountScreen().thousandRubBtnClick();
		 appManager.getAmountScreen().enterAmount("2");
		 appManager.getAmountScreen().nextBtnClick();
		 Assert.assertFalse(appManager.getAmountScreen().isErrorPopupDisplayed(), "Amount screen: Error popup displayed");
		 appManager.getPaymentToolScreen().nextBtnClick();
		 Assert.assertFalse(appManager.getPaymentToolScreen().isErrorPopupDisplayed(), "Payment tool screen: Error popup displayed");
		 appManager.getVerificationCodeScreen().enterVerificationCode("2233");
		 appManager.getVerificationCodeScreen().nextBtnClick();
		 Assert.assertFalse(appManager.getVerificationCodeScreen().isErrorPopupDisplayed(), "Verification screen: Error popup displayed");
		 appManager.getStatusScreen().waitForVanishUpdateStatus();
		 appManager.getStatusScreen().editTemplateName("beeline");
		 appManager.getStatusScreen().createTemplaetBtnClick();
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().payWithTemplate("beeline");
		 Assert.assertFalse(appManager.getPaymentsAndTransfersScreen().getTemplatesTab().isErrorPopupDisplayed(), "Templates tab: Error popup displayed");
		 appManager.getAccountInfoScreen().nextBtnClick();
		 Assert.assertFalse(appManager.getAccountInfoScreen().isErrorPopupDisplayed(), "Account info screen: Error popup displayed");		 
		 appManager.getAmountScreen().tenRubBtnClick();
		 appManager.getAmountScreen().hundredRubBtnClick();
		 appManager.getAmountScreen().thousandRubBtnClick();
		 appManager.getAmountScreen().enterAmount("2");
		 appManager.getAmountScreen().nextBtnClick();
		 Assert.assertFalse(appManager.getAmountScreen().isErrorPopupDisplayed(), "Amount screen: Error popup displayed");
		 appManager.getPaymentToolScreen().nextBtnClick();
		 Assert.assertFalse(appManager.getPaymentToolScreen().isErrorPopupDisplayed(), "Payment tool screen: Error popup displayed");
		 appManager.getVerificationCodeScreen().enterVerificationCode("2233");
		 appManager.getVerificationCodeScreen().nextBtnClick();
		 appManager.getVerificationCodeScreen().navUpBtnClick();		 
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().openTemplateContextMenu("beeline");
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().getTemplateContextMenu().payBtnClick();
		 Assert.assertFalse(appManager.getPaymentsAndTransfersScreen().getTemplatesTab().isErrorPopupDisplayed(), "Templates tab: Error popup displayed");
		 appManager.getAccountInfoScreen().navUpBtnClick();
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().openTemplateContextMenu("beeline");
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().getTemplateContextMenu().deleteBtnClick();
		 appManager.getPaymentsAndTransfersScreen().getTemplatesTab().getTemplateDeleteConfirmationPopup().yesBtnClick();		 
	}

}
