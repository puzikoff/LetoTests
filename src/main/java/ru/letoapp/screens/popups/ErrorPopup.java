package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ErrorPopup extends PopupBase{
	public static final Logger Log = Logger.getLogger(ErrorPopup.class);
	
	String titleText = "Ошибка…";
	String titleText2 = "Ошибка";
	String popupMessageText = "";
	String nextBtnText = "Продолжить";

	public ErrorPopup(WebDriver driver) {
		super(driver);
	}

}
