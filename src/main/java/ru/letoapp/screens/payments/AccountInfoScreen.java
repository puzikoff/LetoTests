package ru.letoapp.screens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class AccountInfoScreen extends AppScreenBase{
	
	By accountField = By.xpath("//WeakMaskedEditText");
	By alert = By.id("image_alert_indicator");
	By nextBtn = By.xpath("//Button[@id='button']");
	

	public AccountInfoScreen(WebDriver driver) {
		super(driver);
	}
	
	public void enterAccount(String account) {
		Log.info("Account info screen: Entering account - " + account);
		findElement(accountField, driver).clear();
		findElement(accountField, driver).sendKeys(account);
	}
	
	public boolean isAlertDisplayed() {
		return isElementPresent(alert);
	}
	
	public boolean isNextBtnDisplayed() {
		return isElementPresent(nextBtn);
	}
	
	public void nextBtnClick(){
		Log.info("Account info screen: next button click - ");
		findElement(nextBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}

}
