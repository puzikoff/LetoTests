package ru.letoapp.screens.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionBar extends ScreenBase{
	public static final Logger Log = Logger.getLogger(ActionBar.class);
	WebDriverWait waitVar =  new WebDriverWait(driver, 45);
	By menuBtn = By.id("home");
	By actionBarTitle = By.id("action_bar_title");
	By navUpBtn = By.xpath("//ActionBarView/LinearLayout/HomeView/ImageView[1]");	 
	By contactsBtn = By.id("menu_item_contacts");
	
	public ActionBar(WebDriver driver) {
		super(driver);
	} 	 
	
	public void menuBtnClick() {
		driver.findElement(menuBtn).click();
	}
	 
	public void navUpBtnClick() {		 
		driver.findElement(navUpBtn).click();	
	}
	 
	public void contactsBtnClick() {
		driver.findElement(contactsBtn).click();
	}
	 
	public void waitFor(By locator) {		
		waitVar.until(ExpectedConditions.presenceOfElementLocated(locator));		
	}
	 
	public String getActionBarTitle() {
		waitFor(actionBarTitle);
		return driver.findElement(actionBarTitle).getText();
	}
	 

}
