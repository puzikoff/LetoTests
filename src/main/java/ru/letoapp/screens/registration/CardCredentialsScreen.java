package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class CardCredentialsScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(CardCredentialsScreen.class);
	
	By cardNumberField = By.id("text_card_number");
	By accessCodeField = By.id("text_access_code");
	By nextBtn = By.id("button_further");
	By forgetAccessLink = By.id("button_remind_access_code");

	public CardCredentialsScreen(WebDriver driver) {
		super(driver);		
	}

	public void enterCardNumber(String cardNumber) {
		waitFor(cardNumberField);
		Log.info("Card Credentials Screen: Entering card number");
		driver.findElement(cardNumberField).clear();
		driver.findElement(cardNumberField).sendKeys(cardNumber);		
	}

	public void enterAccessCode(String accessCode) {
		waitFor(accessCodeField);
		Log.info("Card Credentials Screen: Entering access code");
		driver.findElement(accessCodeField).clear();
		driver.findElement(accessCodeField).sendKeys(accessCode);
	}

	public void NextBtnClick() {
		waitFor(nextBtn);
		Log.info("Card Credentials Screen: Click next button");
		driver.findElement(nextBtn).click();
		delay();
	}

	public void forgotCardNumberBtnClick() {
		waitFor(forgetAccessLink);
		Log.info("Card Credentials Screen: Click forget access code or card number button");
		driver.findElement(forgetAccessLink).click();	
		delay();
	}

}
