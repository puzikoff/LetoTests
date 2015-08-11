package ru.letoapp.screens.loans;

import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class PaymentsInTerminalsSecreen extends AppScreenBase{
	
	private String titleText = "Через терминалы";

	public PaymentsInTerminalsSecreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {
		verify.assertTrue(getTitleFromActionBar().contains(titleText), "Payments via terminals screen: title");
		verify.assertAll();		
	}

}
