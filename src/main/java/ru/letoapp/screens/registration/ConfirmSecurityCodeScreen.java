package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class ConfirmSecurityCodeScreen extends AppScreenBase {
	public static final Logger Log = Logger.getLogger(ConfirmSecurityCodeScreen.class);
	By title = By.xpath("//TextView[contains(@value, 'Повторите защитный код')]");
	By disMissBtn = By.id("button_miss");
	
	public ConfirmSecurityCodeScreen(WebDriver driver) {
		super(driver);	
	}
	
	public void verifyScreen() {
		waitFor(title);
	}

	public void clickNumber(String number) {
		Log.info("Confirm security code screen: Click number: " + number);
		driver.findElement(By.id("button_keyboard_" + number)).click();		
	}

}
