package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.screens.AppScreenBase;
import ru.letoapp.screens.others.EditDisplayNameBlock;

public class CardScreen extends AppScreenBase{	
	private CardTab cardTab;
	private CardInfoTab cardInfoTab;
	private CardManagementTab cardManagementTab;
	private EditDisplayNameBlock editDisplayName;
	String titleText = "Карта";	
	By cardTabBtn = By.xpath("//TextView[@value='КАРТА']");
	By infoTabBtn = By.xpath("//TextView[@value='ИНФОРМАЦИЯ']");
	By managementTabBtn = By.xpath("//TextView[@value='УПРАВЛЕНИЕ']");	

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
	
	public void verify() {		
		Log.info("Card screen: verify screen");
		verify.assertEquals(getTitleFromActionBar(), titleText , "Card screen: title");
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

	public void waitForVanoshUpdateIndicator() {
		// TODO Auto-generated method stub
		
	}

}
