package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class IncorrectLoginPasswordScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(IncorrectLoginPasswordScreen.class);
	
	By tryAgainBtn = By.id("button_try_again");
	By resetCredentialsBtn = By.id("button_reset_credentials");
	
	public IncorrectLoginPasswordScreen(WebDriver driver) {
		super(driver);		
	}

	public void tryAgainBtnClick() {
		waitFor(tryAgainBtn);
		Log.info("Incorrect Login or Password Screen: Try again button click");
		driver.findElement(tryAgainBtn).click();	
		delay();
	}

}
