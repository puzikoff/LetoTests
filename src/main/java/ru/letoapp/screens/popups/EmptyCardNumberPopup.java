package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class EmptyCardNumberPopup extends PopupBase{
	public static final Logger Log = Logger.getLogger(EmptyCardNumberPopup.class);
	
	String titleText = "Ошибка…";
	String popupMessageText = "Поле «Номер карты» должно быть заполнено.";
	String nextBtnText = "Продолжить";

	public EmptyCardNumberPopup(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPopup() {
		Log.info("Empty card number popup: Verify empty login popup");
		verify.assertEquals(driver.findElement(title).getText(), titleText, "Popup title");
		verify.assertEquals(driver.findElement(message).getText(), popupMessageText, "Popup message");
		verify.assertEquals(driver.findElement(nextBtn).getText(), nextBtnText, "Popup next button");
		verify.assertAll();
	}

}
