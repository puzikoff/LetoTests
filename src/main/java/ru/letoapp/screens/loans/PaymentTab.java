package ru.letoapp.screens.loans;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class PaymentTab extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(PaymentTab.class);
	String titleText = "Кредит";
	By paymentsSchedule = By.id("widget_payments_grid");
	By moreDetailed = By.xpath("//TextView[@id='label_top_date']/../TextView[2]");
	By whatIf = By.id("layout_what_if_container");
	By inLetoBankOffices = By.xpath("//TextView[@value='В офисах Лето Банка']");
	By anotherBankPayment = By.xpath("//TextView[@value='Платежом из другого банка']");
	By paymentSystemsTerminals = By.xpath("//TextView[@value='Через терминалы платёжных систем']");

	public PaymentTab(WebDriver driver) {
		super(driver);
	}
	
	public void paymentScheduleClick() {
		waitFor(paymentsSchedule);
		Log.info("Loan payment tab: Payment schedule click");
		findElement(paymentsSchedule, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void whatIfClick() {
		waitForClickable(whatIf);
		Log.info("Loan payment tab: What if? click");
		findElement(whatIf, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void inLetoBankOfficesClick() {
		waitForClickable(inLetoBankOffices);
		Log.info("Loan payment tab: In leto bank offices payment click");
		findElement(inLetoBankOffices, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void anotherBankPaymentClick() {
		waitForClickable(anotherBankPayment);
		Log.info("Loan payment tab: Another bank payment click");
		findElement(anotherBankPayment, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void paymentSystemsTerminalsClick() {
		waitForClickable(paymentSystemsTerminals);
		Log.info("Loan payment tab: Payments systems terminalst click");
		findElement(paymentSystemsTerminals, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

}
