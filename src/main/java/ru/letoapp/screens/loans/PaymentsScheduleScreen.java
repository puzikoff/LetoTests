package ru.letoapp.screens.loans;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class PaymentsScheduleScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(PaymentsScheduleScreen.class);
	
	String titleText = "График погашений";

	public PaymentsScheduleScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), titleText, "Payments schedule screen: title");
		verify.assertAll();		
	}

}
