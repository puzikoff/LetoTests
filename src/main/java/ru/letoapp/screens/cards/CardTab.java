package ru.letoapp.screens.cards;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class CardTab extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(CardTab.class);
	By expandBtn = By.id("label_card_info_total_caption");
	By totalAvailable = By.id("label_total_available");
	By creditFunds = By.id("label_credit_funds");
	By ownFunds = By.id("label_own_funds");
	By blockedFunds = By.id("label_blocked");
	By holdsBtn = By.id("layout_card_info_holds");

	public CardTab(WebDriver driver) {
		super(driver);
	}
	
	public void expandBtnClick() {
		waitFor(expandBtn);
		Log.info("Card Tab: Expand button click");
		driver.findElement(expandBtn).click();
		delay();
	}
	
	public String getTotalAvailable() {		
		String ta = null;
		waitFor(totalAvailable);		
		ta = driver.findElement(totalAvailable).getText();
		ta = onlyNumbersString(ta);
		Log.info("Card tab: get Total Available: " + ta);
		return ta;
	}
	
	public String getCreditFunds() {		
		String cf = null;
		waitFor(creditFunds);
		cf = driver.findElement(creditFunds).getText();
		cf = onlyNumbersString(cf);
		Log.info("Card tab: get Credit Funds: " + cf);
		return cf;
	}
	
	public String getOwnFunds() {		
		String of = null;
		waitFor(ownFunds);
		of = driver.findElement(ownFunds).getText();
		of = onlyNumbersString(of);	
		Log.info("Card tab: get Own Funds: " + of);
		return of;
	}
	
	public String getBlockedFunds() {		
		String bf = null;
		waitFor(blockedFunds);
		bf = driver.findElement(blockedFunds).getText();
		bf = onlyNumbersString(bf);	
		Log.info("Card Screen 'card' tab: get Blocked Funds: " + bf);
		return bf;
	}


}
