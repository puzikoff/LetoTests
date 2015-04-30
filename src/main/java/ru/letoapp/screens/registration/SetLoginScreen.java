package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class SetLoginScreen extends AppScreenBase {
	public static final Logger Log = Logger.getLogger(SetLoginScreen.class);
	By nextBtn = By.id("button_further");
	By loginField = By.id("text_login");

	public SetLoginScreen(WebDriver driver) {
		super(driver);
	}

	public void enterLogin(String login) {
		waitFor(loginField);
		Log.info("Set Login Screen: Entering login: " + login);
		driver.findElement(loginField).clear();
		driver.findElement(loginField).sendKeys(login);
	}

	public void nextBtnClick() {
		waitFor(nextBtn);
		Log.info("Set Login Screen: Click next button");
		driver.findElement(nextBtn).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

}
