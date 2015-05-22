package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class TimelineScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(TimelineScreen.class);
	private String loanOperationsTitleText = "Операции по кредиту";
	private String cardOperationsTitleText = "Операции по карте";
	private String connectionServicesHistoryTitleText = "История подключения услуг";
	private String holdsTitleText = "Заблокировано";

	public TimelineScreen(WebDriver driver) {
		super(driver);
	}

	public void verifyLoanOperationsScreen() {
		verify.assertTrue(getTitleFromActionBar().contains(loanOperationsTitleText), "Loan operations screen: title");
		verify.assertAll();	
	}
	
	public void verifyCardOperationsScreen() {
		verify.assertTrue(getTitleFromActionBar().contains(cardOperationsTitleText), "Card operations screen: title");
		verify.assertAll();	
	}
	
	public void verifyConnectionServicesHistoryScreen() {
		verify.assertEquals(getTitleFromActionBar(), connectionServicesHistoryTitleText, "Connection services history screen: title");
		verify.assertAll();	
	}

	public void verifyHoldsScreen() {
		verify.assertTrue(getTitleFromActionBar().contains(holdsTitleText), "Holds screen: title");
		verify.assertAll();	
	}

}
