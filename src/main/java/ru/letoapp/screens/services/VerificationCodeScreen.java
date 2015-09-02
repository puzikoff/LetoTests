package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class VerificationCodeScreen extends AppScreenBase{	
	
	By codeField = By.xpath("//MaskedEditText");
	By nextBtn = By.xpath("//Button[@id='button']");

	public VerificationCodeScreen(WebDriver driver) {
		super(driver);
	}
	
	public void enterVerificationCode(String vc) {
		Log.info("Verification code screen: enter vc");
		findElement(codeField, driver).clear();
		findElement(codeField, driver).sendKeys(vc);
		delay();
	}

	public void nextBtnClick() {
		Log.info("Verification code screen: next btn click");
		clickAndWaitSpinerToVanish(nextBtn);
	}
}
