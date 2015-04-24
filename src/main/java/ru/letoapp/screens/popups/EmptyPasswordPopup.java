package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class EmptyPasswordPopup extends PopupBase{
	public static final Logger Log = Logger.getLogger(EmptyPasswordPopup.class);
	String titleText = "Ошибка…";
	String popupMessageText = "Поле «Пароль» должно быть заполнено.";
	String nextBtnText = "Продолжить";

	public EmptyPasswordPopup(WebDriver driver) {
		super(driver);
	}

	public void verifyPopup() {
		Log.info("Empty password popup: Verify empty password popup");
		verify.assertEquals(driver.findElement(title).getText(), titleText);
		verify.assertEquals(driver.findElement(message).getText(), popupMessageText);
		verify.assertEquals(driver.findElement(nextBtn).getText(), nextBtnText);
		verify.assertAll();
	}
	
}
