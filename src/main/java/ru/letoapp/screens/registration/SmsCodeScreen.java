package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class SmsCodeScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(SmsCodeScreen.class);
	
	By smsCodeComment = By.id("label_phone_number_comment");
	By smsLabelEnterCode = By.id("label_enter_confirmation_code");
	By smsCodeField = By.id("text_confirmation_code");
	By nextBtn = By.id("button_further");
	By sendSmsAgainBtn = By.id("button_send_confirmation_code_again");	
	By smsLabelNotRecieve = By.id("label_16_4");
	String smsCodeCommentText = "Вам отправлено SMS с кодом подтверждения регистрации на номер";
	String smsLabelEnterCodeText = "Введите код из SMS";
	String nextBtnText = "Далее";
	String smsLabelNotRecieveText = "SMS с кодом не пришло?";

	public SmsCodeScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void verifyScreen() {
		Log.info("SMS code screen: verify screen");
		verify.assertTrue(driver.findElement(smsCodeComment).getText().contains(smsCodeCommentText));
		verify.assertEquals(driver.findElement(smsLabelEnterCode).getText(), smsLabelEnterCodeText, "SMS label enter code");
		verify.assertEquals(driver.findElement(nextBtn).getText(), nextBtnText, "Next button text");
		verify.assertEquals(driver.findElement(smsLabelNotRecieve).getText(), smsLabelNotRecieveText, "Not recieve ?");
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

}
