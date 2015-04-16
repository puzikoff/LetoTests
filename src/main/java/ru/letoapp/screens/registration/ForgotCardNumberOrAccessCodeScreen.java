package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.others.AppScreenBase;

public class ForgotCardNumberOrAccessCodeScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(ForgotCardNumberOrAccessCodeScreen.class);	
	
	By cardNumberField = By.xpath("//MaskedEditText[1]");	
	By accessCodeField = By.xpath("//MaskedEditText[2]");	
	By nextBtn = By.xpath("//LinearLayout/Button");
	By callBtn = By.id("button_call_phone_number");

	public ForgotCardNumberOrAccessCodeScreen(WebDriver driver) {
		super(driver);
	}

	public void enterCardNumber(String cardNumber) {
		waitFor(cardNumberField);
		Log.info("Forgot Card Number Or Access Code Screen: Entering card number");
		driver.findElement(cardNumberField).clear();
		driver.findElement(cardNumberField).sendKeys(cardNumber);		
	}

	public void enterAccessCode(String accessCode) {
		waitFor(accessCodeField);
		Log.info("Forgot Card Number Or Access Code Screen: Entering access code");
		driver.findElement(accessCodeField).clear();
		driver.findElement(accessCodeField).sendKeys(accessCode);
	}

	public void NextBtnClick() {
		waitFor(nextBtn);
		Log.info("Forgot Card Number Or Access Code Screen: Click next button");
		driver.findElement(nextBtn).click();
		delay();
	}

}
