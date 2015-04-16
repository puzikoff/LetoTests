package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.others.AppScreenBase;

public class SmsCodeScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(SmsCodeScreen.class);
	
	By smsCodeField = By.id("text_confirmation_code");
	By nextBtn = By.id("button_further");
	By sendSmsAgainBtn = By.id("button_send_confirmation_code_again");
	By emptyFieldErrorNextBtn = By.id("sdl__positive_button");

	public SmsCodeScreen(WebDriver driver) {
		super(driver);		
	}

	public void sendSmsAgainBtnClick() {
		waitFor(sendSmsAgainBtn);
		Log.info("SMS Code Screen: Click 'send sms again'");
		driver.findElement(sendSmsAgainBtn).click();
		delay();
	}

	public void nextBtnClick() {				
		waitFor(nextBtn);				
		Log.info("SMS Code Screen: Click 'Next'");
		driver.findElement(nextBtn).click();
		delay();
	}

	public void enterSmsCode(String smsCode) {
		waitFor(smsCodeField);
		Log.info("SMS Code Screen: Enter sms code");
		driver.findElement(smsCodeField).clear();
		driver.findElement(smsCodeField).sendKeys(smsCode);
	}

	public void emptyFieldNextBtnClick() {
		waitFor(emptyFieldErrorNextBtn);
		Log.info("SMS Code Screen: Click 'Next' on empty field error popup");
		driver.findElement(emptyFieldErrorNextBtn).click();
		delay();		
	}

}
