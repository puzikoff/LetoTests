package ru.letoapp.screens.others;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import ru.letoapp.screens.AppScreenBase;

public class DashboardScreen extends AppScreenBase {
	
	By timelineBtn = By.id("button_feed");	
	By paymentsBtn = By.id("button_payment");
	By cardsListBtn = By.xpath("//LinearLayout//ScrollView//LinearLayout//FrameLayout[2]//RelativeLayout");	
	By loansListBtn = By.xpath("//LinearLayout//ScrollView//LinearLayout//FrameLayout[3]//RelativeLayout");
	By depositsListBtn = By.xpath("//LinearLayout//ScrollView//LinearLayout//FrameLayout[4]//RelativeLayout[1]");
	By walletBtn = By.xpath("//TextView[@value='МОЙ КОШЕЛЁК']//..");
	By adsressesOnMapLabel = By.id("label_action_addresses_on_map");
	By sendEmailBtn = By.id("button_dashboard_send");
	By phoneCallBtn = By.id("button_dashboard_call");
	By websiteBtn = By.id("button_dashboard_website");
	By loanBtn = By.xpath("//LoanInfoView_[1]");
	By cardBtn = By.xpath("//CardInfoView_[1]");	
	By updateBigSpiner = By.xpath("//ProgressBar[@id='progress_loading']");
	By loadingError = By.xpath("//ImageView[@id='image_error']");
	String addressesOnMapLabelText = "Адреса на карте";
	
	
	public DashboardScreen(WebDriver driver) {
		super(driver);
	}
	
	public void verifyDashboardScreen() {
		Log.info("Dashboard screen: Verify Dashboard");		
	}
		
	public void openCard(String cardName) {
		Log.info("Dashboard screen: Open card: " + cardName);	
		List <WebElement> cards = driver.findElements(By.xpath("//TextView[@value = '" + cardName + "']"));
		if(!cards.isEmpty()) {
			cards.get(0).click();
			delay();
		}
		else {
			Log.error("Dashboard screen: No card with such name");
			Assert.fail("Dashboard screen: No card with such name: " + cardName);
		}
	}
	
	public void openLoan(String loanName) {
		Log.info("Dashboard screen: Open loan: " + loanName);		
		List <WebElement> loans = driver.findElements(By.xpath("//TextView[@value = '" + loanName + "']"));
		if(!loans.isEmpty()) {												
			loans.get(0).click();		
			delay();
		}			
		else {
			Log.error("Dashboard screen: No loan with such name");
			Assert.fail("Dashboard screen: No card with such name: " + loanName);
		}
	}
	
	public boolean isLoadingErrorExist() {		
		if(findElement(loadingError, driver).isDisplayed()){
			Log.error("Dashboard screen: Loading ERROR");
			takeScreenshot();
			return true;
		}
		else return false;		
	}
	
	public void openDeposit(String depositName) {
		Log.info("Dashboard screen: Open deposit: " + depositName);						
		List <WebElement> deposits = driver.findElements(By.xpath("//TextView[@value='" + depositName + "']"));
		if(!deposits.isEmpty()) {				
			deposits.get(0).click();		
			delay();		
		}
		else {
			Log.error("Dashboard screen: No deposit with such name");
			Assert.fail();
		}
	}
	
	public void openCard(int n) {		
		Log.info("Dashboard screen: Open card number: " + n + "on dashboard");
		waitFor("//CardSectionView_//CardInfoView_[1]");
		findElement(By.xpath("//CardSectionView_//CardInfoView_[" + n + "]"), driver).click();
		delay();
	}
	
	public void openLoan(int n) {		
		Log.info("Dashboard screen: Open loan number: " + n + "on dashboard");
		waitFor("//LoanSectionView_//LoanInfoView_[1]");
		findElement(By.xpath("//LoanSectionView_//LoanInfoView_[" + n + "]"), driver).click();
		delay();
	}
	
	public void openDeposit(int n) {		
		Log.info("Dashboard screen: Open deposit number: " + n + "on dashboard");
		waitFor("//DepositSectionView_//DepositInfoView_[1]");
		findElement(By.xpath("//DepositSectionView_//DepositInfoView_[" + n + "]"), driver).click();
		delay();
	}
	
	public String getCardSum(String cardName) {
		String sum = null;
		Log.info("Dashboard screen: Get" + cardName + "card sum");
		waitFor("//TextView[@id='label_card_caption']");				
		List <WebElement> cards = driver.findElements(By.xpath("//TextView[@id='label_card_caption']"));
		for(int i = 0; cards.get(i).getSize() != null; ++i) {			
			if(cards.get(i).getText().contains(cardName)) {
				sum = findElement(By.xpath("//CardInfoView_[" + (i+1) + "]//TextView[2]"), driver).getText();
				if(!sum.contains(",")) sum = sum + "00";
				sum = sum.replaceAll("\\D+", "");				
				Log.info("Dashboard screen: Cardsum: " + sum);
				return sum;	}		
		}
		Log.error("Dashboard screen: No card with such name: " + cardName);
		return "no card"; 		 
	}
	
	public String getCardSum(int n) {
		waitFor("//ScrollView/LinearLayout//FrameLayout[2]//CardInfoView_[" + n + "]//TextView[2]");		
		return findElement(By.xpath("//ScrollView/LinearLayout//FrameLayout[2]//CardInfoView_[" + n + "]//TextView[2]"), driver).getText();
	}
	
	
	public void cardsListBtnClick() {		
		waitFor(cardsListBtn);		
		Log.info("Dashboard screen: Open cards list");
		findElement(cardsListBtn, driver).click();	
		delay();
	}	
	
	public void loansListBtnClick() {
		waitFor(loansListBtn);
		Log.info("Dashboard screen: Open loans list");
		findElement(loansListBtn, driver).click();
		delay();
	}
	
	public void loanBtnClick() {
		waitFor(loanBtn);
		Log.info("Dashboard screen: Open loan");		
		findElement(loanBtn, driver).click();
		delay();
	}
	
	public void depositsListBtnClick() {
		waitFor(depositsListBtn);
		Log.info("Dashboard screen: Open depositss list");
		findElement(depositsListBtn, driver).click();
		delay();
	}
	
	public void timelineBtnClick(){
		waitFor(timelineBtn);
		Log.info("Dashboard screen: Open timeline");
		findElement(timelineBtn, driver).click();
		delay();
	}	
	
	public void walletBtnClick() {
		waitFor(walletBtn);
		Log.info("Dashboard screen: Open wallet");
		findElement(walletBtn, driver).click();
		delay();
	}
	
	public void openWallet() {
		waitFor(walletBtn);
		Log.info("Dashboard screen: Open wallet");
		findElement(walletBtn, driver).click();
		delay();
	}

	public void waitForVanishUpdateSpiner() {
		waitFor(updateBigSpiner);
		Log.info("Dashboard screen: Wait for vanish update spiner");
		waitForVanish(updateBigSpiner);		
	}
	
	public void paymentsBtnClik() {
		Log.info("Dashboard screen: Payments button click");
		findElement(paymentsBtn, driver).click();
		delay();
	}

}
