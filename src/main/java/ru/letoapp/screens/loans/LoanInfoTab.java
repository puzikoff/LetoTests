package ru.letoapp.screens.loans;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class LoanInfoTab extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(LoanInfoTab.class);
	
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
	}

}
