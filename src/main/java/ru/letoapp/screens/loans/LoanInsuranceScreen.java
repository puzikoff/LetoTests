package ru.letoapp.screens.loans;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class LoanInsuranceScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(LoanInsuranceScreen.class);
	private String titleText = "Страховая защита";

	public LoanInsuranceScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), titleText , "Loan insurance screen: title");
		verify.assertAll();		
	}

}
