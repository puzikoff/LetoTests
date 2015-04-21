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
		Log.info("Dashboard screen: Verify Dashboard");
		waitFor("//TextView[@id=\"label_card_caption\"]");
	}
		
	public void openCard(String cardName) {
		Log.info("Dashboard screen: Open card: " + cardName);
		waitFor("//TextView[@id=\"label_card_caption\"]");				
		List <WebElement> cards = driver.findElements(By.xpath("//TextView[@id='label_card_caption']"));
		for(WebElement card: cards) {			
			if(card.getText().contains(cardName)) {				
				Log.error("Open card:" + card.getText());								
				card.click();
				delay();
			}			
		}		
	}
	
	public void openCard(int n) {		
		Log.info("Dashboard screen: Open card number: " + n);
		waitFor("//CardSectionView_//CardInfoView_[1]");
		driver.findElement(By.xpath("//CardSectionView_//CardInfoView_[" + n + "]")).click();
		delay();
	}
	
	public String getCardSum(String cardName) {
		String sum = null;
		Log.info("Dashboard screen: Get" + cardName + "card sum");
		waitFor("//TextView[@id=\"label_card_caption\"]");				
		List <WebElement> cards = driver.findElements(By.xpath("//TextView[@id='label_card_caption']"));
		for(int i = 0; cards.get(i).getSize() != null; ++i) {			
			if(cards.get(i).getText().contains(cardName)) {
				sum = driver.findElement(By.xpath("//CardInfoView_[" + (i+1) + "]//TextView[2]")).getText();
				if(!sum.contains(",")) sum = sum + "00";
				sum = sum.replaceAll("\\D+", "");				
				Log.info("Dashboard screen: Cardsum: " + sum);
				return sum;
			}			
		}
		return "Dashboard screen: No card with such name: " + cardName;
	}
	
	public String getCardSum(int n) {
		waitFor("//ScrollView/LinearLayout//FrameLayout[2]//CardInfoView_[" + n + "]//TextView[2]");		
		return driver.findElement(By.xpath("//ScrollView/LinearLayout//FrameLayout[2]//CardInfoView_[" + n + "]//TextView[2]")).getText();
	}
	
	
	public void cardsListBtnClick() {		
		waitFor(cardsListBtn);		
		Log.info("Dashboard screen: Open cards list");
		driver.findElement(cardsListBtn).click();	
		delay();
	}	
	
	public void loansListBtnClick() {
		waitFor(loansListBtn);
		Log.info("Dashboard screen: Open loans list");
		driver.findElement(loansListBtn).click();
		delay();
	}
	
	public void loanBtnClick() {
		waitFor(loanBtn);
		Log.info("Dashboard screen: Open loan");		
		driver.findElement(loanBtn).click();
		delay();
	}
	
	public void depositsListBtnClick() {
		waitFor(depositsListBtn);
		Log.info("Dashboard screen: Open depositss list");
		driver.findElement(depositsListBtn).click();
		delay();
	}
	
	public void timelineBtnClick(){
		waitFor(timelineBtn);
		Log.info("Dashboard screen: Open timeline");
		driver.findElement(timelineBtn).click();
		delay();
	}	

}
