package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class AccountCredentialsScreen extends AppScreenBase{
	
public static final Logger Log = Logger.getLogger(AccountCredentialsScreen.class);
	
	By accountNumberField = By.id("text_account_number");
	By accessCodeField = By.id("text_access_code");
	By nextBtn = By.id("button_further");
	By forgetAccessLink = By.id("button_remind_account_number_or_access_code");

	public AccountCredentialsScreen(WebDriver driver) {
		super(driver);
	}
	
	public void enterAccountNumber(String accountNumber) {
		waitFor(accountNumberField);
		Log.info("Account Credentials Screen: Entering account number");
		driver.findElement(accountNumberField).clear();
		driver.findElement(accountNumberField).sendKeys(accountNumber);		
	}

	public void enterAccessCode(String accessCode) {
		waitFor(accessCodeField);
		Log.info("Account Credentials Screen: Entering access code");
		driver.findElement(accessCodeField).clear();
		driver.findElement(accessCodeField).sendKeys(accessCode);
	}

	public void NextBtnClick() {
		waitFor(nextBtn);
		Log.info("Account Credentials Screen: Click next button");
		driver.findElement(nextBtn).click();	
		delay();
	}

	public void forgotAccountBtnClick() {
		waitFor(forgetAccessLink);
		Log.info("Account Credentials Screen: Click forget acces code button");
		driver.findElement(forgetAccessLink).click();	
		delay();
	}

}
