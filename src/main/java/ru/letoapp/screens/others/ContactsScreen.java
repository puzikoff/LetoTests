package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class ContactsScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(ContactsScreen.class);

	public ContactsScreen(WebDriver driver) {
		super(driver);		
	}

}
