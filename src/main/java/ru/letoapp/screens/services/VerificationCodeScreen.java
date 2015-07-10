package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class VerificationCodeScreen extends AppScreenBase{	
	
	By codeField = By.xpath("//MaskedEditText");
	By nextBtn = By.xpath("//Button[@id='button_further']");

	public VerificationCodeScreen(WebDriver driver) {
		super(driver);
	}

}