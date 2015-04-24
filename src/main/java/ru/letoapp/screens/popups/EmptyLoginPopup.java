package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class EmptyLoginPopup extends PopupBase{
	public static final Logger Log = Logger.getLogger(EmptyLoginPopup.class);
	String titleText = "Ошибка…";
	String popupMessageText = "Поле «Логин» должно быть заполнено.";
	String nextBtnText = "Продолжить";
	
	public EmptyLoginPopup(WebDriver driver) {
		super(driver);		
	}
	
	public void verifyPopup() {
		Log.info("Empty login popup: Verify empty login popup");
		verify.assertEquals(driver.findElement(title).getText(), titleText);
		verify.assertEquals(driver.findElement(message).getText(), popupMessageText);
		verify.assertEquals(driver.findElement(nextBtn).getText(), nextBtnText);
		verify.assertAll();
	}
	
	

}
