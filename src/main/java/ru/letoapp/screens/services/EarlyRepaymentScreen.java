package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class EarlyRepaymentScreen extends AppScreenBase{
	String title = "Досрочное погашение";
	By hint = By.xpath("//TextView[@id='label_content']");
	By comissionBlock = By.xpath("//TextView[@value='КОМИССИЯ ЗА ПОДКЛЮЧЕНИЕ']");
	By connectBtn = By.xpath("//Button[@id='button']");

	public EarlyRepaymentScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {
		verify.assertEquals(getTitleFromActionBar(), title, "title");
		verify.assertTrue(findElement(comissionBlock, driver).isDisplayed(), "Comission block");
		verify.assertTrue(findElement(connectBtn, driver).isDisplayed(), "Connect button");
		verify.assertAll();		
	}
	
	public void connectBtnClickAndWait() {
		Log.info("Early repayment screen: connect button click");
		clickAndWaitSpinerToVanish(connectBtn);
	}

}
