package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.ScreenBase;

public class Drawer extends ScreenBase{
	public static final Logger Log = Logger.getLogger(Drawer.class);
	By contactsBtn = By.id("layout_contacts");
	By aboutBankBtn = By.id("layout_about_bank");
	By exitBtn = By.id("layout_logout");

	public Drawer(WebDriver driver) {
		super(driver);		
	}
	
	public void contactsBtnClick() {
		waitFor(contactsBtn);
		Log.info("Drawer: Contacts button click");
		driver.findElement(contactsBtn).click();
		delay();
	}
	
	public void aboutBankBtnClick() {
		waitFor(aboutBankBtn);
		Log.info("Drawer: About bank button click");
		driver.findElement(aboutBankBtn).click();
		delay();
	}
	
	public void exitBtnClick() {
		waitFor(exitBtn);
		Log.info("Drawer: Exit button click");
		driver.findElement(exitBtn).click();
		delay();
	}

}
