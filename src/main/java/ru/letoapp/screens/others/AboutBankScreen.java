package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AboutBankScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(AboutBankScreen.class);
	By aboutBankAndAppBtn = By.id("action_show_app_info");
	By bankRequisitesBtn = By.id("action_show_bank_requisites");
	String title = "О банке";

	public AboutBankScreen(WebDriver driver) {
		super(driver);
	}

	public void aboutBankAndAppBtnClick() {
		waitFor(aboutBankAndAppBtn);
		Log.info("About bank screen: About bank and application button click");
		driver.findElement(aboutBankAndAppBtn).click();
		delay();
	}

	public void bankRequisitesBtnClick() {
		waitFor(bankRequisitesBtn);
		Log.info("About bank screen: Bank requisites button click");
		driver.findElement(bankRequisitesBtn).click();
		delay();
	}

}
