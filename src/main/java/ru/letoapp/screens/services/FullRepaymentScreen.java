package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import ru.letoapp.screens.AppScreenBase;
import ru.letoapp.screens.popups.TopUpMethodsPopup;

public class FullRepaymentScreen extends AppScreenBase{
	TopUpMethodsPopup topUpMethodsPopup;
	
	String title = "Полное досрочное";	
	By topUpMethodBlock = By.xpath("//TextView[@value='КАКИМ СПОСОБОМ ВЫ БУДЕТЕ ВНОСИТЬ ДЕНЬГИ?']");
	By topUpMethodList = By.xpath("//TextView[@value='КАКИМ СПОСОБОМ ВЫ БУДЕТЕ ВНОСИТЬ ДЕНЬГИ?']/following-sibling::LinearLayout");
	By calendarBlock = By.xpath("//TextView[@value='КОГДА ВЫ ПЛАНИРУЕТЕ ЭТО СДЕЛАТЬ?']");
	By connectBtn = By.xpath("//Button[@id='button']");
	By chosenTopUpMethodBlock = By.xpath("//TextView[@value='СПОСОБ']");
	By sumToGrantBlock = By.xpath("//TextView[@value='CУММА ДЛЯ ВНЕСЕНИЯ']"); //в слове сумма с-английская
	By planingGrantDateBlock = By.xpath("//TextView[@value='ПЛАНИРУЕМАЯ ДАТА ВНЕСЕНИЯ']");
	By grantDateBlock = By.xpath("//TextView[@value='ОРИЕНТИРОВОЧНО ДЕНЬГИ ЗАЧИСЛЯТСЯ']");
	By payAttentionBlock = By.xpath("//WeakMaskedEditText[@id='edit_text']");
	By saveFundsBlock = By.xpath("//TextView[@value='ВЫ ЭКОНОМИТЕ НА % ']");

	public FullRepaymentScreen(WebDriver driver) {
		super(driver);
		topUpMethodsPopup = PageFactory.initElements(driver, TopUpMethodsPopup.class);
		topUpMethodsPopup.setDriver(driver);
	}
	
	public TopUpMethodsPopup getTopUpMethodsPopup() {
		return topUpMethodsPopup;
	}
	
	public void verifyFullRepaymentFirstStep() {
		verify.assertTrue(getTitleFromActionBar().contains(title), "Full repayment screen: title");
		verify.assertTrue(findElement(topUpMethodBlock, driver).isDisplayed(), "Full repayment screen: top up methods");
		verify.assertTrue(findElement(calendarBlock, driver).isDisplayed(), "Full repayment screen: calendar");				
		verify.assertAll();		
	}
	
	public void verifyFullRepaymentSecondStep() {
		verify.assertTrue(getTitleFromActionBar().contains(title), "Full repayment screen step 2: title");
		verify.assertTrue(findElement(chosenTopUpMethodBlock, driver).isDisplayed(), "Full repayment screen step 2: Choosen popup method");
		//verify.assertTrue(findElement(sumToGrantBlock, driver).isDisplayed(), "Full repayment screen step 2: Sum to grant");
		verify.assertTrue(findElement(planingGrantDateBlock, driver).isDisplayed(), "Full repayment screen step 2: Planing grant date block");
		verify.assertTrue(findElement(grantDateBlock, driver).isDisplayed(), "Full repayment screen step 2: Grant date block");
		verify.assertTrue(findElement(saveFundsBlock, driver).isDisplayed(), "Full repayment screen step 2: New payment sum or credit will be payed block");				
		verify.assertAll();
	}
	
	public void chooseNewDate(String date) {
		Log.info("Full repayment screen: Choose date: " + date);
		Assert.assertTrue(isElementClickable(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']")), "Full repayment screen: claculated new payment date is clickable");
		findElement(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']"), driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }				
	}
	
	public void topUpMethodsListClick() {
		Log.info("Full repayment screen: Top up methods list click");
		click(topUpMethodList);
	}
	
	public void connectBtnClick() {
		Log.info("Full repayment screen: connect button click");
		clickAndWaitSpinerToVanish(connectBtn);
	}

}
