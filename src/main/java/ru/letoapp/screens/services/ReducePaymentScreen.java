package ru.letoapp.screens.services;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class ReducePaymentScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(ReducePaymentScreen.class);
	By connectBtn = By.xpath("//Button[@id='button']");
	String titleText = "Уменьшаю платеж";
	String connectBtnText = "Подключить";
	String subtitleText = "ЧТО БУДЕТ ЕСЛИ УМЕНЬШИТЬ ПЛАТЁЖ?";
	By subtitle = By.xpath("//TextView[@id='label_title']");
	String nextPaymentText = "СЛЕДУЮЩИЙ ПЛАТЁЖ";
	By nextPaymentDefault = By.xpath("//ComparatorView_[1]//TextView[@id='label_default']");
	By nextPaymentNew = By.xpath("//ComparatorView_[1]//TextView[@id='label_text']");
	By nextPaymentDifference = By.xpath("//ComparatorView_[1]//TextView[@id='label_comment']");
	String rateText = "СТАВКА ПО КРЕДИТУ";
	By rateDefault = By.xpath("//ComparatorView_[2]//TextView[@id='label_default']");
	By rateNew = By.xpath("//ComparatorView_[2]//TextView[@id='label_text']");	
	By rateDifference = By.xpath("//ComparatorView_[2]//TextView[@id='label_comment']");
	String planDateText = "ПЛАНОВЫЙ СРОК ПОГАШЕНИЯ";
	By planDateDefault = By.xpath("//ComparatorView_[3]//TextView[@id='label_default']");
	By planDateNew = By.xpath("//ComparatorView_[3]//TextView[@id='label_text']");
	By planDateDifference = By.xpath("//ComparatorView_[3]//TextView[@id='label_comment']");

	public ReducePaymentScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void connectBtnClick(){
		Log.info("Reduce paymnet service screen: Connect button click");
		findElement(connectBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), titleText, "Reduce payment screen: Title");
		verify.assertEquals(findElement(connectBtn, driver).getText(), connectBtnText, "Reduce payment screen: Connect button text");
		verify.assertEquals(driver.findElements(subtitle).get(1).getText(), subtitleText, "Reduce payment screen: Subtitle text");
		verify.assertAll();
	}

}
