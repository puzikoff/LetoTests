package ru.letoapp.screens.loans;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.others.AppScreenBase;

public class LoanScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(LoanScreen.class);

	public LoanScreen(WebDriver driver) {
		super(driver);	
	}

}
