package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class DboScreen extends AppScreenBase {
	public static final Logger Log = Logger.getLogger(DboScreen.class);
	String actionBarTitle = "Регистрация"; 
	By acceptTermsBtn = By.xpath("//ActionMenuItemView[@id='menu_item_accept_contract']");
	By contextMenuBtn = By.xpath("//ActionMenuItemView[@id='menu_item_more']");
	By sendEmailBtn = By.xpath("//TextView[contains(@value, 'Отправить на почту')]");
	String acceptTermsBtnText = "Принять условия договора";
	
	public DboScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void verifyScreen() {
		verify.assertEquals(getTitleFromActionBar(), actionBarTitle, "Action bar title");
		verify.assertEquals(driver.findElement(acceptTermsBtn).getText(), acceptTermsBtnText, "Accept terms button text");
		verify.assertAll();
	}

	public void acceptLicenseTerms() {		
		waitFor(acceptTermsBtn);
		Log.info("Dbo Screen: Click 'Accept terms' button");
		driver.findElement(acceptTermsBtn).click();	
		delay();
	}	
	
	public void contextMenuBtnClick() {		
		waitFor(contextMenuBtn);
		Log.info("Dbo Screen: Click menu button");
		driver.findElement(contextMenuBtn).click();
	}
	
	public void sendEmailBtnClick() {		
		waitFor(sendEmailBtn);
		Log.info("Dbo Screen: Click send email button");
		driver.findElement(sendEmailBtn).click();
		delay();
	}

}
