package ru.letoapp.screens.loans;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class LoanContractScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(LoanContractScreen.class);
	private String titleText = "Договор";

	public LoanContractScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {
		verify.assertTrue(getTitleFromActionBar().contains(titleText ), "Loan contract screen: title");
		verify.assertAll();		
	}

}
