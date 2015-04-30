package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class RegistrationMethodScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(RegistrationMethodScreen.class);
	
	String actionBarTitle = "Регистрация";
	String screenTitleText = "У вас есть карта Лето Банка?";
	By screenTitle = By.xpath("//LinearLayout/LinearLayout/ImageView/../TextView");
	By cardRegistrationBtn = By.id("button_have_a_card");
	By accountRegistrationBtn = By.id("button_have_no_card");
	
	public RegistrationMethodScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void verifyScreen() {
		verify.assertEquals(getTitleFromActionBar(), actionBarTitle, "Action bar title");
		verify.assertEquals(driver.findElement(screenTitle).getText(), screenTitleText, "Screen title");
		verify.assertAll();
		
	}

	public void chooseCard() {		
		waitFor(cardRegistrationBtn);
		Log.info("RegistrationMethodScreen: Choose card registration");
		driver.findElement(cardRegistrationBtn).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void chooseAccount() {		
		waitFor(accountRegistrationBtn);
		Log.info("RegistrationMethodScreen: Choose account registration");
		driver.findElement(accountRegistrationBtn).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

}
