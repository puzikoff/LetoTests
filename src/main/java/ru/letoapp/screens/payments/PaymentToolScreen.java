package ru.letoapp.screens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class PaymentToolScreen extends AppScreenBase{
	By nextBtn = By.xpath("//Button[@id='button']");
	By comission = By.xpath("//TextView[@value='КОМИССИЯ']/following-sibling::LinearLayout/EditText");
	By amount = By.xpath("//TextView[@value='СУММА']/following-sibling::LinearLayout/EditText");
	By phoneNumber = By.xpath("//TextView[@value='НОМЕР ТЕЛЕФОНА']/following-sibling::LinearLayout/WeakMaskedEditText");
	
	public PaymentToolScreen(WebDriver driver) {
		super(driver);
	}
	
	public void choosePaymentTool(String paymentTool) {
		Log.info("Payment tool screen: Choose payment tool - " + paymentTool);
		clickAndWaitSpinerToVanish(By.xpath("//TextView[@value='" + paymentTool + "']/following-sibling::TextView/following-sibling::RadioButton"));				
	}

	public void nextBtnClick(){
		Log.info("Amount screen: next button click");
		clickAndWaitSpinerToVanish(nextBtn);
	}
	
	public String getComission() {
		Log.info("Payment tool screen: comission: " + findElement(comission, driver).getText());
		return onlyNumbersString(findElement(comission, driver).getText());
	}
	
	public String getAmount() {
		Log.info("Payment tool screen: amount: " + findElement(amount, driver).getText());
		return onlyNumbersString(findElement(amount, driver).getText());
	}
	
	public String getPhoneNumber() {
		Log.info("Payment tool screen: phoneNumber: " + findElement(phoneNumber, driver).getText());
		return onlyNumbersString(findElement(phoneNumber, driver).getText());
	}
}
