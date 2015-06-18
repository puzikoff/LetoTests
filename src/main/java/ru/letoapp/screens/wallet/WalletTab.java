package ru.letoapp.screens.wallet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class WalletTab extends AppScreenBase{
	By paymentBtn = By.xpath("//Button[@id='button_transfer_or_payment']");

	public WalletTab(WebDriver driver) {
		super(driver);
	}
	
	public void paymentBtnClick() {
		Log.info("Wallet Screen: Payment button click");
		findElement(paymentBtn, driver).click();
		delay();
	}
}
