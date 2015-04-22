package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class ResetSecurityCodeScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(ResetSecurityCodeScreen.class);
	
	By resetSecurityCodeBtn = By.xpath("//Button[@id='button_reset_protection_code']");

	public ResetSecurityCodeScreen(WebDriver driver) {
		super(driver);
	}
	
	public void resetSecurityCodeBtnClick() {
		Log.info("Reset Security Code Screen: Reset security code button click");
		driver.findElement(resetSecurityCodeBtn).click();
		delay();
	}

}
