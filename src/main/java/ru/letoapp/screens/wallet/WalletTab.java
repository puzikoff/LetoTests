package ru.letoapp.screens.wallet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class WalletTab extends AppScreenBase{
	
	By walletInfoHeader = By.xpath("//LinearLayoutp[@id='layout_wallet_info_header']");
	By walletInfoBody = By.xpath("//LinearLayoutp[@id='layout_wallet_info_body']");
	By totalAvailable = By.xpath("//TextView[@id='label_total_available']");
	By totalAvailableCaption = By.xpath("//TextView[@id='label_wallet_info_total_caption']");
	By walletHint = By.xpath("//TextView[@id='label_own_funds']");
	String walletHintText = "Вы можете подключить карту Visa или MasterCard, выпущенную российским банком, чтобы пополнять кошелёк и платить с неё в приложении.\n\nПодключение карты бесплатно.\n\nБанк, выпустивший карту, может взимать комиссию за проведение операций по ней.";
	By connectCardBtn = By.xpath("//TextView[@value='Подключить новую карту']/..");
	By showInfoOnlineBtn = By.xpath("//TextView[contains(@value,'Перейти к описанию')]");
	By addFundsBtn = By.xpath("//Button[@id='button_add_funds']");
	By paymentBtn = By.xpath("//Button[@id='button_transfer_or_payment']");
	By walletOperationsBtn = By.xpath("//ClickableItemView_[@id='label_action_last_transactions']");
	By inLetoBankOffices = By.xpath("//TextView[@value='В офисах банка']");
	By anotherBankPayment = By.xpath("//TextView[@value='Платежом из другого банка']");
	By paymentSystemsTerminals = By.xpath("//TextView[@value='Через терминалы платёжных систем']");	

	public WalletTab(WebDriver driver) {
		super(driver);
	}	
	
	public void verifyZeroWallet() {		
		verify.assertTrue(findElement(totalAvailable, driver).isDisplayed(), "Wallet info body");
		verify.assertTrue(findElement(totalAvailableCaption, driver).isDisplayed(), "Wallet info body");
		verify.assertEquals(findElement(walletHint, driver).getText(), walletHintText, "Wallet info body");
		verify.assertTrue(findElement(connectCardBtn, driver).isDisplayed(), "connect button");
		verify.assertTrue(findElement(showInfoOnlineBtn, driver).isDisplayed(), "show info online");
		verify.assertTrue(findElement(addFundsBtn, driver).isDisplayed(), "add funds button");
		verify.assertTrue(findElement(paymentBtn, driver).isDisplayed(), "payments button");
		verify.assertTrue(findElement(walletOperationsBtn, driver).isDisplayed(), "wallet operations button");
		verify.assertAll();
	}
	
	public void walletOperationsBtnClick() {
		Log.info("Wallet Screen: Wallet operations button click");
		click(walletOperationsBtn);
	}
	
	public void paymentBtnClick() {
		Log.info("Wallet Screen: Payment button click");
		click(paymentBtn);
	}
	
	public void addFundsBtnClick() {
		Log.info("Wallet Screen: Add funds button click");
		click(addFundsBtn);
	}
	
	public void connectCardBtnClick() {
		Log.info("Wallet Screen: Connect card button click");
		click(connectCardBtn);
	}
	
	public void inLetoBankOfficesClick() {
		waitForClickable(inLetoBankOffices);
		Log.info("Wallet tab: In leto bank offices payment click");
		clickAndWaitSpinerToVanish(inLetoBankOffices);	
	}
	
	public void anotherBankPaymentClick() {
		waitForClickable(anotherBankPayment);
		Log.info("wallet tab: Another bank payment click");
		clickAndWaitSpinerToVanish(anotherBankPayment);	
	}
	
	public void paymentSystemsTerminalsClick() {
		waitForClickable(paymentSystemsTerminals);
		Log.info("Wallet tab: Payments systems terminalst click");
		clickAndWaitSpinerToVanish(paymentSystemsTerminals);	
	}
}
