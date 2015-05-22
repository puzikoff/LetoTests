package ru.letoapp.screens.loans;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class AnotherBankPaymentScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(AnotherBankPaymentScreen.class);
	private String titleText = "Платежом из другого банка";

	public AnotherBankPaymentScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), titleText , "Another bank payment screen: title");
		verify.assertAll();		
	}

}
