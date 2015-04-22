package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class SecurityCodeScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(SecurityCodeScreen.class);
	By setTitle = By.xpath("//TextView[contains(@value, 'Введите защитный код')]");
	By confirmTitle = By.xpath("//TextView[contains(@value, 'Повторите защитный код')]");
	By authTitle = By.xpath("//TextView[contains(@value, 'Введите защитный код')]");
	By disMissBtn = By.id("button_miss");
	By remindSecurityCodeBtn = By.xpath("//Button[@id='button_remind_protection_code']");
	

	public SecurityCodeScreen(WebDriver driver) {
		super(driver);	
	}
	
	public void verifyScreen() {		
	}
	
	public void clickNumber(String number) {
		Log.info("Security Code Screen: Click number: " + number);
		driver.findElement(By.id("button_keyboard_" + number)).click();	
		delay();
	}
	
	public void remindSecurityCodeBtnClick(){
		Log.info("Security Code Screen:  remind security code click");
		driver.findElement(remindSecurityCodeBtn).click();
		delay();
	}

}
