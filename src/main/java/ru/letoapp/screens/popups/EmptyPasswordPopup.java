package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class EmptyPasswordPopup extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(EmptyPasswordPopup.class);

	public EmptyPasswordPopup(WebDriver driver) {
		super(driver);
	}

}
