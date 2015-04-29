package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class EmptySmsCodePopup extends PopupBase{
	public static final Logger Log = Logger.getLogger(EmptySmsCodePopup.class);
	
	String titleText = "Ошибка…";
	String popupMessageText = "Поле «Код подтверждения» должно быть заполнено.";
	String nextBtnText = "Продолжить";

	public EmptySmsCodePopup(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPopup() {
		Log.info("Empty sms code popup: Verify empty login popup");
		verify.assertEquals(driver.findElement(title).getText(), titleText, "Popup title");
		verify.assertEquals(driver.findElement(message).getText(), popupMessageText, "Popup message");
		verify.assertEquals(driver.findElement(nextBtn).getText(), nextBtnText, "Popup next button");
		verify.assertAll();
	}
}
