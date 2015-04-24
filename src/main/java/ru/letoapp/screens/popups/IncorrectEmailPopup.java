package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class IncorrectEmailPopup extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(IncorrectEmailPopup.class);

	public IncorrectEmailPopup(WebDriver driver) {
		super(driver);
	}

}
