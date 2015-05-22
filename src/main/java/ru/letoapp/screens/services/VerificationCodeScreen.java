package ru.letoapp.screens.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class VerificationCodeScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(VerificationCodeScreen.class);
	
	By codeField = By.xpath("//MaskedEditText");
	By nextBtn = By.xpath("//Button[@id='button_further']");

	public VerificationCodeScreen(WebDriver driver) {
		super(driver);
	}

}
