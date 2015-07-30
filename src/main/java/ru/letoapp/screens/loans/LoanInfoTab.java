package ru.letoapp.screens.loans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class LoanInfoTab extends AppScreenBase{	
	
	By contractBtn = By.id("widget_show_contract_details");
	By creditOperationsBtn = By.id("layout_action_show_loan_operations");
	By insuranceBtn = By.id("widget_show_insurance");
	By repaymentCardBtn = By.id("widget_show_repayment_card");
	By paymentsScheduleBtn = By.id("widget_show_payment_schedule");
	By superRateBtn = By.id("widget_superrate_info");

	public LoanInfoTab(WebDriver driver) {
		super(driver);
	}
	
	public void contractBtnClick() {
		waitForClickable(contractBtn);
		Log.info("Loan info tab: contract butoon click");
		findElement(contractBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void creditOperationsBtnClick() {
		waitForClickable(creditOperationsBtn);
		Log.info("Loan info tab: Credit operations button click");
		findElement(creditOperationsBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void insuranceBtnClick() {
		waitForClickable(insuranceBtn);
		Log.info("Loan info tab: Insurance button click");
		findElement(insuranceBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

	public void paymentsScheduleBtnClick() {
		waitForClickable(paymentsScheduleBtn);
		Log.info("Loan info tab: Payments schedule button click");
		findElement(paymentsScheduleBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

}
