package ru.letoapp.screens.others;

import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardScreen extends AppScreenBase {
	public static final Logger Log = Logger.getLogger(DashboardScreen.class);	
	By timelineBtn = By.id("button_feed");	
	By walletBtn = By.xpath("//LinearLayout//ScrollView//LinearLayout//FrameLayout[2]//RelativeLayout[1]");
	By cardsListBtn = By.xpath("//LinearLayout//ScrollView//LinearLayout//FrameLayout[2]//RelativeLayout");	
	By loansListBtn = By.xpath("//LinearLayout//ScrollView//LinearLayout//FrameLayout[3]//RelativeLayout");
	By depositsListBtn = By.xpath("//LinearLayout//ScrollView//LinearLayout//FrameLayout[4]//RelativeLayout[1]");
	By adsressesOnMapLabel = By.id("label_action_addresses_on_map");
	By sendEmailBtn = By.id("button_dashboard_send");
	By phoneCallBtn = By.id("button_dashboard_call");
	By websiteBtn = By.id("button_dashboard_website");
	By loanBtn = By.xpath("//LoanInfoView_[1]");
	By cardBtn = By.xpath("//CardInfoView_[1]");	
	String addressesOnMapLabelText = "Адреса на карте";
	
	
	public DashboardScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verifyDashboardScreen() {
		waitFor("//TextView[@id=\"label_card_caption\"]");
	}
		
	public void openCard(String cardName) {
		waitFor("//TextView[@id=\"label_card_caption\"]");				
		List <WebElement> cards = driver.findElements(By.xpath("//TextView[@id='label_card_caption']"));
		for(WebElement card: cards) {			
			if(card.getText().contains(cardName)) {				
				Log.error("Open card:" + card.getText());								
				card.click();
			}			
		}		
	}
	
	public void openCard(int n) {		
		waitFor("//ScrollView/LinearLayout//FrameLayout[2]//CardInfoView_[1]");
		driver.findElement(By.xpath("//ScrollView/LinearLayout//FrameLayout[2]//CardInfoView_[" + n + "]")).click();	
	}
	
	public String getCardSum(String cardName) {
		String sum = null;
		waitFor("//TextView[@id=\"label_card_caption\"]");				
		List <WebElement> cards = driver.findElements(By.xpath("//TextView[@id='label_card_caption']"));
		for(int i = 0; cards.get(i).getSize() != null; ++i) {			
			if(cards.get(i).getText().contains(cardName)) {
				sum = driver.findElement(By.xpath("//CardInfoView_[" + (i+1) + "]//TextView[2]")).getText();
				if(!sum.contains(",")) sum = sum + "00";
				sum = sum.replaceAll("\\D+", "");							
				return sum;
			}			
		}
		return "No card with such name: " + cardName;
	}
	
	public String getCardSum(int n) {
		waitFor("//ScrollView/LinearLayout//FrameLayout[2]//CardInfoView_[" + n + "]//TextView[2]");		
		return driver.findElement(By.xpath("//ScrollView/LinearLayout//FrameLayout[2]//CardInfoView_[" + n + "]//TextView[2]")).getText();
	}
	
	
	public void cardsListBtnClick() {
		waitFor(cardsListBtn);		
		driver.findElement(cardsListBtn).click();		
	}	
	
	public void loansListBtnClick() {
		waitFor(loansListBtn);
		driver.findElement(loansListBtn).click();
	}
	
	public void loanBtnClick() {
		driver.findElement(loanBtn).click();
	}
	
	public void depositsListBtnClick() {
		waitFor(depositsListBtn);
		driver.findElement(depositsListBtn).click();
	}
	
	public void timelineBtnClick(){
		waitFor(timelineBtn);
		driver.findElement(timelineBtn).click();
	}	

}
