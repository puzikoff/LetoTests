package ru.letoapp.screens.cards;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class CardScreenCard extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(CardScreenCard.class);
	String actionBarTitle = "Карта";	
	By cardTab = By.xpath("//TextView[@value='КАРТА']");
	By infoTab = By.xpath("//TextView[@value='ИНФОРМАЦИЯ']");
	By manageTab = By.xpath("//TextView[@value='УПРАВЛЕНИЕ']");
	By expandBtn = By.id("label_card_info_total_caption");
	By totalAvailable = By.id("label_total_available");
	By creditFunds = By.id("label_credit_funds");
	By ownFunds = By.id("label_own_funds");
	By blockedFunds = By.id("label_blocked");
	By holdsBtn = By.id("layout_card_info_holds");

	public CardScreenCard(WebDriver driver) {
		super(driver);
	}
	
	public void verifyCardScreen() {
	}
	
	
	public String getTotalAvailable() {		
		String ta = null;
		waitFor(totalAvailable);		
		ta = driver.findElement(totalAvailable).getText();
		ta = onlyNumbersString(ta);
		Log.info("Card Screen 'card' tab: get Total Available: " + ta);
		return ta;
	}
	
	public String getCreditFunds() {		
		String cf = null;
		waitFor(creditFunds);
		cf = driver.findElement(creditFunds).getText();
		cf = onlyNumbersString(cf);
		Log.info("Card Screen 'card' tab: get Credit Funds: " + cf);
		return cf;
	}
	
	public String getOwnFunds() {		
		String of = null;
		waitFor(ownFunds);
		of = driver.findElement(ownFunds).getText();
		of = onlyNumbersString(of);	
		Log.info("Card Screen 'card' tab: get Own Funds: " + of);
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

	public void infoTabClick() {
		Log.info("Card Screen 'card' tab: Information tab click");
		driver.findElement(infoTab).click();
		delay();
	}

	public void managementTabClick() {
		Log.info("Card Screen 'card' tab: Managementd tab click");
		driver.findElement(manageTab).click();
		delay();		
	}

}
