package ru.letoapp.screens.loans;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class PaymentsInTerminalsSecreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(PaymentsInTerminalsSecreen.class);
	private String titleText = "Через терминалы";

	public PaymentsInTerminalsSecreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {
		verify.assertTrue(getTitleFromActionBar().contains(titleText), "Payments via terminals screen: title");
		verify.assertAll();		
	}

}
