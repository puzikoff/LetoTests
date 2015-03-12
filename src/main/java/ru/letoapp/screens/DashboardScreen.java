package ru.letoapp.screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardScreen extends AppScreenBase {
	public static final Logger Log = Logger.getLogger(DashboardScreen.class);
	By timelineBtn = By.id("button_feed");
	By cardsSection = By.id("layout_cards_section");
	By cardsListBtn = By.xpath("//LinearLayout//RelativeLayout[1]");
	By loansListBtn = By.xpath("//LinearLayout//RelativeLayout[2]");
	By depositsListBtn = By.xpath("//RelativeLayout//RelativeLayout[3]");
	By adsressesOnMapLabel = By.id("label_action_addresses_on_map");
	By sendEmailBtn = By.id("button_dashboard_send");
	By phoneCallBtn = By.id("button_dashboard_call");
	By websiteBtn = By.id("button_dashboard_website");
	By loanBtn = By.xpath("//LoanInfoView_[1]");
	By cardBtn = By.xpath("//CardInfoView_[1]");	
	String adsressesOnMapLabelTesxt = "Адреса на карте";
	
	
	public DashboardScreen(WebDriver driver) {
		super(driver);
	}
	
	public void cardsListBtnClick() {
		driver.findElement(cardsListBtn).click();
	}
	
	public void cardBtnClick() {
		driver.findElement(cardBtn).click();
	}
	
	public void loansListBtnClick() {
		driver.findElement(loansListBtn).click();
	}
	
	public void loanBtnClick() {
		driver.findElement(loanBtn).click();
	}
	
	public void depositsListBtnClick() {
		driver.findElement(depositsListBtn).click();
	}
	
	public void timelineBtnClick() {
		driver.findElement(timelineBtn).click();
	}	

}
