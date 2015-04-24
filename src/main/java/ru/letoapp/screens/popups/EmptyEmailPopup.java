package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class EmptyEmailPopup extends PopupBase{
	public static final Logger Log = Logger.getLogger(EmptyEmailPopup.class);

	public EmptyEmailPopup(WebDriver driver) {
		super(driver);
	}

}
