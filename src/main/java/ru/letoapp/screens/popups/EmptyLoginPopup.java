package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class EmptyLoginPopup extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(EmptyLoginPopup.class);

	public EmptyLoginPopup(WebDriver driver) {
		super(driver);		
	}

}
