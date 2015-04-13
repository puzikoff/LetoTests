package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.others.AppScreenBase;

public class DboScreen extends AppScreenBase {
	public static final Logger Log = Logger.getLogger(DboScreen.class);
	By acceptTermsBtn = By.xpath("//ActionMenuItemView[@id='menu_item_accept_contract']");
	By contextMenuBtn = By.xpath("//ActionMenuItemView[@id='menu_item_more']");
	By sendEmailBtn = By.xpath("//TextView[contains(@value, 'Отправить на почту')]");
	
	public DboScreen(WebDriver driver) {
		super(driver);		
	}

	public void acceptLicenseTerms() {		
		waitFor(acceptTermsBtn);
		Log.info("DboScreen: Click 'Accept terms' button");
		driver.findElement(acceptTermsBtn).click();		
	}	
	
	public void menuBtnClick() {		
		waitFor(contextMenuBtn);
		Log.info("DboScreen: Click menu button");
		driver.findElement(contextMenuBtn).click();
	}
	
	public void sendEmailBtnClick() {		
		waitFor(sendEmailBtn);
		Log.info("DboScreen: Click send email button");
		driver.findElement(sendEmailBtn).click();
	}

}
