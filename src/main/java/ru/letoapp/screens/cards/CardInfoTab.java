package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class CardInfoTab extends AppScreenBase{	
	
	By howToUseCardBtn = By.id("widget_action_how_to_use_card");
	By product = By.id("label_product");
	By cardOperationsBtn = By.id("widget_show_operation_history");

	public CardInfoTab(WebDriver driver) {
		super(driver);
	}
	
	public void howToUseCardClick() {
		waitFor(howToUseCardBtn);
		Log.info("Card screen, info tab: How to use card button click");
		findElement(howToUseCardBtn, driver).click();
		delay();
	}
	
	public void cardOperationsClick() {
		waitFor(cardOperationsBtn);
		Log.info("Card screen, info tab: Card operations button click");
		findElement(cardOperationsBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

}
