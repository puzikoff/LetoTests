package ru.letoapp.screens.loans;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import ru.letoapp.screens.AppScreenBase;

public class PaymentTab extends AppScreenBase{
	
	String titleText = "Кредит";
	final String PAYMENT_TAB_LOCATOR = "//ViewPager/NoSaveStateFrameLayout[1]";
	By paymentsSchedule = By.id("widget_payments_grid");
	By moreDetailed = By.xpath("//TextView[@id='label_top_date']/../TextView[2]");
	By paymentBlockTitle = By.id("label_title_payment");
	String paymentBlockTitleText = "ОПЛАТИТЕ";
	By currentPaymentBlock = By.id("layout_action_current_payment");
	By whatIf = By.id("layout_what_if_container");
	By repayment = By.xpath("//TextView[@value='Автопогашение с карты другого банка']");
	By inLetoBankOffices = By.xpath("//TextView[@value='В офисах банка']");
	By anotherBankPayment = By.xpath("//TextView[@value='Платежом из другого банка']");
	By paymentSystemsTerminals = By.xpath("//TextView[@value='Через терминалы платёжных систем']");	
	
	@FindBy(how = How.XPATH, using = PAYMENT_TAB_LOCATOR)
	WebElement paymentTab;
	
	public PaymentTab(WebDriver driver) {
		super(driver);
	}
	
	public void verify() {
		verify.assertTrue(findElement(paymentsSchedule, driver).isDisplayed(), "Payments schedule");
		verify.assertTrue(findElement(paymentBlockTitle, driver).isDisplayed(), "Payment block title");
		verify.assertTrue(findElement(currentPaymentBlock, driver).isDisplayed(), "Current payment block");
		verify.assertTrue(findElement(whatIf, driver).isDisplayed(), "What if block");
		verify.assertTrue(findElement(repayment, driver).isDisplayed(), "Repayment block");
		verify.assertTrue(findElement(inLetoBankOffices, driver).isDisplayed(), "In leto offices");
		verify.assertTrue(findElement(anotherBankPayment, driver).isDisplayed(), "Another bank payment");
		verify.assertTrue(findElement(paymentSystemsTerminals, driver).isDisplayed(), "What if block");
		verify.assertAll();
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
	
	/*public void findTest() {
		List<WebElement> elements = driver.findElements(By.xpath("//TextView"));
		List<WebElement> elements2 = paymentTab.findElements(By.xpath("//TextView"));
		Log.info("All: " + elements.size());
		Log.info("Under payment tab: " + elements2.size());		
	}*/


}
