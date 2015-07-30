package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class CardManagementTab extends AppScreenBase{
	
	By blockFundsSwitch = By.xpath("//Switch");
	By howWorksBlockFundsBtn = By.id("button_show_spending_block_info");
	By connectingServiceHistoryBtn = By.id("widget_show_service_history");
	

	public CardManagementTab(WebDriver driver) {
		super(driver);
	}
	
	public void blockFundsSwitchClick() {
		waitFor(blockFundsSwitch);
		Log.info("Card screen, Management Tab: Block funds switch click");
		findElement(blockFundsSwitch, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void connectingServiceHistoryBtnClick() {
		waitFor(connectingServiceHistoryBtn);
		Log.info("Card screen, Management Tab: Connecting services history button click");
		findElement(connectingServiceHistoryBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void howWorksBlockFundsBtnClick() {
		waitFor(howWorksBlockFundsBtn);
		Log.info("Card screen, management Tab: How works block funds click");
		findElement(howWorksBlockFundsBtn, driver).click();
		delay();		
	}

}
