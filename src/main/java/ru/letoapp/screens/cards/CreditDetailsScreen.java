package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class CreditDetailsScreen extends AppScreenBase{
	By loadingIndicator = By.xpath("//ProgressBar[@id='progress_network_loading']");
	String title = "Платёжная дата";
	

	public CreditDetailsScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), title, "title");
		verify.assertAll();
	}
	
	public void waitForVanishLoadingIndicator() {
		waitForVanish(loadingIndicator);
	}

}
