package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class ForgotPswScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(ForgotPswScreen.class);
	
	By newCredentialsBtn = By.id("button_get_new_credentials");

	public ForgotPswScreen(WebDriver driver) {
		super(driver);		
	}

	public void getNewCredentialsBtnClick() {
		waitFor(newCredentialsBtn);
		Log.info("Forgot Psw Screen: New credentials button click");
		driver.findElement(newCredentialsBtn).click();	
		delay();
	}

}
