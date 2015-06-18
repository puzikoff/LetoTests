package ru.letoapp.screens.wallet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.screens.AppScreenBase;

public class WalletScreen extends AppScreenBase{
	private WalletTab walletTab;
	private WalletInfoTab walletInfoTab;
	By infoTabBtn = By.xpath("//TextView[@value='ИНФОРМАЦИЯ']");
	By walletTabBtn = By.xpath("//TextView[@value='КОШЕЛЁК']");
	

	public WalletScreen(WebDriver driver) {
		super(driver);
		walletTab = PageFactory.initElements(driver, WalletTab.class);
		walletInfoTab = PageFactory.initElements(driver, WalletInfoTab.class);
		walletTab.setDriver(driver);
		walletInfoTab.setDriver(driver);		
	}
	
	public WalletTab getWalletTab() {
		return walletTab;
	}
	
	public WalletInfoTab getWalletInfoTab() {
		return walletInfoTab;
	}
	
	public void infoTabClick() {
		Log.info("Wallet Screen: Information tab click");
		findElement(infoTabBtn, driver);
		delay();
	}
	
	public void walletTabClick() {
		Log.info("Wallet Screen: Wallet tab click");
		findElement(walletTabBtn, driver);
		delay(2000);
	}	
	
}
