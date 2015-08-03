package ru.letoapp.screens.cards;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class CardInfoTab extends AppScreenBase{	
	
	By howToUseCardBtn = By.id("widget_action_how_to_use_card");
	By product = By.id("label_product");
	By cardOperationsBtn = By.id("widget_show_operation_history");
	By generalInformationText = By.xpath("//TextView[@value='ОБЩАЯ ИНФОРМАЦИЯ']");
	By productBlock = By.xpath("//TextView[@value='ПРОДУКТ']");
	By creditLimitBlock = By.xpath("//TextView[@value='КРЕДИТНЫЙ ЛИМИТ']");
	By spendCreditBlock = By.xpath("//TextView[@value='ИСПОЛЬЗОВАННЫЙ КРЕДИТ']");
	By paymentDateBlock = By.xpath("//TextView[@value='ПЛАТЁЖНАЯ ДАТА']");
	By expirationDateBlock = By.xpath("//TextView[@value='КАРТА ДЕЙСТВУЕТ ДО']");
	By statusBlock = By.xpath("//TextView[@value='СТАТУС']");
	By contractNumberBlock = By.xpath("//TextView[@value='НОМЕР ДОГОВОРА']");
	By contractDateBlock = By.xpath("//TextView[@value='ДАТА ДОГОВОРА']");
	By paymentBlock = By.xpath("//TextView[@value='ПЛАТЁЖ']");

	public CardInfoTab(WebDriver driver) {
		super(driver);
	}
	
	public void howToUseCardClick() {
		waitFor(howToUseCardBtn);
		Log.info("Card screen, info tab: How to use card button click");
		findElement(howToUseCardBtn, driver).click();
		delay();
	}
	
	public void cardOperationsClick() {
		waitFor(cardOperationsBtn);
		Log.info("Card screen, info tab: Card operations button click");
		findElement(cardOperationsBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

	public void verify() {
		Log.info("Card screen, info tab: verify");
		verify.assertTrue(findElement(howToUseCardBtn, driver).isDisplayed(), "How to use card");
		verify.assertTrue(findElement(cardOperationsBtn, driver).isDisplayed(), "Card operations");
		verify.assertTrue(findElement(generalInformationText, driver).isDisplayed(), "General information");
		verify.assertTrue(findElement(productBlock, driver).isDisplayed(), "Product block");
		verify.assertTrue(findElement(creditLimitBlock, driver).isDisplayed(), "Credit limit block");
		verify.assertTrue(findElement(spendCreditBlock, driver).isDisplayed(), "Spend credit block");
		verify.assertTrue(findElement(paymentDateBlock, driver).isDisplayed(), "Payment date");
		verify.assertTrue(findElement(expirationDateBlock, driver).isDisplayed(), "Expiration date");
		verify.assertTrue(findElement(statusBlock, driver).isDisplayed(), "Status");
		verify.assertTrue(findElement(contractNumberBlock, driver).isDisplayed(), "Contract number");
		verify.assertTrue(findElement(contractDateBlock, driver).isDisplayed(), "Contract date");
		verify.assertTrue(findElement(paymentBlock, driver).isDisplayed(), "Payment");
		verify.assertAll();
	}

}
