package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class IncorrectCardNumberOrAccesCodePopup extends PopupBase{
	public static final Logger Log = Logger.getLogger(IncorrectCardNumberOrAccesCodePopup.class);

	String titleText = "Ошибка…";
	String popupMessageText = "Неверный номер карты или код доступа. Попробуйте ввести их еще раз.";
	String nextBtnText = "Продолжить";
	
	public IncorrectCardNumberOrAccesCodePopup(WebDriver driver) {
		super(driver);
	}
	
	public void verifyPopup() {
		Log.info("Incorrect card number or access code popup: Verify empty login popup");
		verify.assertEquals(driver.findElement(title).getText(), titleText, "Popup title");
		verify.assertEquals(driver.findElement(message).getText(), popupMessageText, "Popup message");
		verify.assertEquals(driver.findElement(nextBtn).getText(), nextBtnText, "Popup next button");
		verify.assertAll();
	}

}
