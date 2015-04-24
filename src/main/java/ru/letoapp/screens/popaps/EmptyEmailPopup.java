package ru.letoapp.screens.popaps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class EmptyEmailPopup extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(EmptyEmailPopup.class);

	public EmptyEmailPopup(WebDriver driver) {
		super(driver);
	}

}
