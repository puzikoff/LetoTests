package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.others.AppScreenBase;

public class ForgotAccountOrAccessCodeScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(ForgotAccountOrAccessCodeScreen.class);
	
	By accountNumberField = By.xpath("//MaskedEditText[1]");
	By accessCodeField = By.xpath("//MaskedEditText[2]");
	By nextBtn = By.xpath("//LinearLayout/Button");
	By callBtn = By.id("button_call_phone_number");

	public ForgotAccountOrAccessCodeScreen(WebDriver driver) {
		super(driver);
	}

	public void enterAccountNumber(String accountNumber) {
		waitFor(accountNumberField);
		Log.info("Forgot account Or Access Code Screen: Entering account number");
		driver.findElement(accountNumberField).clear();
		driver.findElement(accountNumberField).sendKeys(accountNumber);		
	}

	public void enterAccessCode(String accessCode) {
		waitFor(accessCodeField);
		Log.info("Forgot Account Or Access Code Screen: Entering acces code");
		driver.findElement(accessCodeField).clear();
		driver.findElement(accessCodeField).sendKeys(accessCode);
	}

	public void NextBtnClick() {
		waitFor(nextBtn);
		Log.info("Forgot Account Or Access Code Screen: Click next button");
		driver.findElement(nextBtn).click();	
		delay();
	}
}
