package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.letoapp.screens.ScreenBase;

public class PopupBase extends ScreenBase{
	public static final Logger Log = Logger.getLogger(PopupBase.class);
	By title = By.id("sdl__title");
	By message = By.id("sdl__message");
	By nextBtn = By.id("sdl__positive_button");

	public PopupBase(WebDriver driver) {
		super(driver);
	}
	
	public void nextBtnClick () {
		waitForClickable(nextBtn);
		Log.info("Popup: Click next button");
		driver.findElement(nextBtn).click();
		delay();
	}

}
