package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class SetSecurityCodeScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(SetSecurityCodeScreen.class);
	By title = By.xpath("//TextView[contains(@value, 'Введите защитный код')]");
	By disMissBtn = By.id("button_miss");

	public SetSecurityCodeScreen(WebDriver driver) {
		super(driver);	
	}
	
	public void verifyScreen() {
		waitFor(title);
	}
	
	public void clickNumber(String number) {
		Log.info("Set Security Code Screen: Click number: " + number);
		driver.findElement(By.id("button_keyboard_" + number)).click();		
	}

}
