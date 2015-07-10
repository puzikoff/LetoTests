package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class CardTab extends AppScreenBase{	
	By expandBtn = By.id("label_card_info_total_caption");
	By totalAvailable = By.id("label_total_available");
	By creditFunds = By.id("label_credit_funds");
	By ownFunds = By.id("label_own_funds");
	By blockedFunds = By.id("label_blocked");
	By holdsBtn = By.id("layout_card_info_holds");
	By blockFundsSwitch = By.xpath("//Switch");
	By howWorksBlockFundsBtn = By.id("button_show_spending_block_info");
	By cardOperationsBtn = By.xpath("//ClickableItemView_[@id='label_action_last_transactions']//TextView");
	By whatIfBtn = By.id("layout_what_if_container");

	public CardTab(WebDriver driver) {
		super(driver);
	}
	
	public void expandBtnClick() {
		waitFor(expandBtn);
		Log.info("Card screen, Card Tab: Expand button click");
		findElement(expandBtn, driver).click();
		delay();
	}
	
	public void holdsBtnClick() {
		waitFor(holdsBtn);
		Log.info("Card screen, Card Tab: Hold funds click");
		findElement(holdsBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void blockFundsSwitchClick() {
		waitFor(blockFundsSwitch);
		Log.info("Card screen, Card Tab: Block funds switch click");
		findElement(blockFundsSwitch, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void howWorksBlockFundsBtnClick() {
		waitFor(howWorksBlockFundsBtn);
		Log.info("Card screen, Card Tab: How works block funds click");
		findElement(howWorksBlockFundsBtn, driver).click();
		delay();		
	}
	
	public void cardOperationsClick(){
		waitFor(cardOperationsBtn);
		Log.info("Card screen, Card Tab: Card operations click");
		findElement(cardOperationsBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void whatIfBtnClick(){
		waitFor(whatIfBtn);
		Log.info("Card screen, Card Tab: What if button click");
		findElement(whatIfBtn, driver).click();
		delay();		
	}
	
	public String getTotalAvailable() {		
		String ta = null;
		waitFor(totalAvailable);		
		ta = findElement(totalAvailable, driver).getText();
		ta = onlyNumbersString(ta);
		Log.info("Card tab: get Total Available: " + ta);
		return ta;
	}
	
	public String getCreditFunds() {		
		String cf = null;
		waitFor(creditFunds);
		cf = findElement(creditFunds, driver).getText();
		cf = onlyNumbersString(cf);
		Log.info("Card tab: get Credit Funds: " + cf);
		return cf;
	}
	
	public String getOwnFunds() {		
		String of = null;
		waitFor(ownFunds);
		of = findElement(ownFunds, driver).getText();
		of = onlyNumbersString(of);	
		Log.info("Card tab: get Own Funds: " + of);
		return of;
	}
	
	public String getBlockedFunds() {		
		String bf = null;
		waitFor(blockedFunds);
		bf = findElement(blockedFunds, driver).getText();
		bf = onlyNumbersString(bf);	
		Log.info("Card Screen 'card' tab: get Blocked Funds: " + bf);
		return bf;
	}

	public void verify() {
		// TODO Auto-generated method stub
		
	}


}
