package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.screens.AppScreenBase;
import ru.letoapp.screens.others.EditDisplayNameBlock;
import ru.letoapp.screens.popups.NotImplementedPopup;

public class CardScreen extends AppScreenBase{	
	private CardTab cardTab;
	private CardInfoTab cardInfoTab;
	private CardManagementTab cardManagementTab;
	private EditDisplayNameBlock editDisplayName;
	private NotImplementedPopup notImplementedPopup;
	By contractNameBlock = By.id("layout_product_name_container");
	String titleText = "Карта";	
	By cardTabBtn = By.xpath("//TextView[@value='КАРТА']");
	By infoTabBtn = By.xpath("//TextView[@value='ИНФОРМАЦИЯ']");
	By managementTabBtn = By.xpath("//TextView[@value='УПРАВЛЕНИЕ']");	
	By updateIndicator = By.xpath("//ProgressBar");

	public CardScreen(WebDriver driver) {
		super(driver);
		cardTab = PageFactory.initElements(driver, CardTab.class);
		cardInfoTab = PageFactory.initElements(driver, CardInfoTab.class);
		cardManagementTab = PageFactory.initElements(driver, CardManagementTab.class);
		editDisplayName = PageFactory.initElements(driver, EditDisplayNameBlock.class);
		cardTab.setDriver(driver);
		cardInfoTab.setDriver(driver);
		cardManagementTab.setDriver(driver);
		editDisplayName.setDriver(driver);
		notImplementedPopup = PageFactory.initElements(driver, NotImplementedPopup.class);
		notImplementedPopup.setDriver(driver);
	}
	
	public CardTab getCardTab(){
		return cardTab;
	}
	
	public CardInfoTab getCardInfoTab() {
		return cardInfoTab;
	}
	
	public CardManagementTab getCardManagementTab() {
		return cardManagementTab;
	}
	
	public EditDisplayNameBlock getEditDisplayName() {
		return editDisplayName;
	}
	
	public NotImplementedPopup getNotImplementedPopup() {
		return notImplementedPopup;
	}
	
	public void verify() {		
		verify.assertEquals(getTitleFromActionBar(), titleText , "Card screen: title");
		verify.assertTrue(findElement(contractNameBlock, driver).isDisplayed(), "Edit contract name block displayed");
		verify.assertAll();		
	}		
	
	public void infoTabClick() {
		Log.info("Card Screen: Information tab click");
		findElement(infoTabBtn, driver).click();
		delay();
	}

	public void managementTabClick() {
		Log.info("Card Screen: Managementd tab click");
		findElement(managementTabBtn, driver).click();
		delay();		
	}
	
	public void cardTabClick() {
		Log.info("Card Screen: Card tab click");
		findElement(cardTabBtn, driver).click();
		delay();
	}

	public void waitForVanishUpdateIndicator() {
		Log.info("Card screen: Wait for vanish update spiner");		
		waitForVanish(updateIndicator);				
	}
	
	public String calculateNewPaymentDate(int paymentDate) {
		Log.info("Calculate new payment date from info tab");		
		if((paymentDate < 5)&&(paymentDate > 1)) { 
			Log.info("New payment date: 5");
			return "5";
		}	
		if((paymentDate < 15)&&(paymentDate >= 5)) {
			Log.info("New payment date: " + (paymentDate + 1));
			return Integer.toString(paymentDate + 1);
		}
		if((paymentDate >= 15)&&(paymentDate < 28)) {
			Log.info("New payment date: " + (paymentDate - 1));
			return Integer.toString(paymentDate - 1);
		}
		if((paymentDate <= 31)&&(paymentDate >= 28 )) {
			Log.info("New payment date: 28");
			return "28";
		}
		else
			return "Can't calculate new payment date";
	}	

}
