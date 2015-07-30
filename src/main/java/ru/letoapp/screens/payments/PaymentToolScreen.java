package ru.letoapp.screens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class PaymentToolScreen extends AppScreenBase{
	By nextBtn = By.xpath("//Button[@id='button']");
	
	public PaymentToolScreen(WebDriver driver) {
		super(driver);
	}
	
	public void choosePaymentTool(String paymentTool) {
		Log.info("Payment tool screen: Choose payment tool - " + paymentTool);
		findElement(By.xpath("//TextView[@value='" + paymentTool + "']/following-sibling::TextView/following-sibling::RadioButton"), driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}

	public void nextBtnClick(){
		Log.info("Amount screen: next button click");
		findElement(nextBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}
}
