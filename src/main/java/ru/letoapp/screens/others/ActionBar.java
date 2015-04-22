package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.ScreenBase;

public class ActionBar extends ScreenBase{
	public static final Logger Log = Logger.getLogger(ActionBar.class);	
	By menuBtn = By.id("home");
	By actionBarTitle = By.id("action_bar_title");
	By navUpBtn = By.xpath("//ActionBarView/LinearLayout/HomeView/ImageView[1]");	 
	By contactsBtn = By.id("menu_item_contacts");
	
	public ActionBar(WebDriver driver) {
		super(driver);
	} 	 
	
	public void menuBtnClick() {
		Log.info("Action bar: Menu button click");
		driver.findElement(menuBtn).click();
		delay();
	}
	 
	public void navUpBtnClick() {
		Log.info("Action bar: Click NavUp button");
		driver.findElement(navUpBtn).click();	
		delay();
	}
	 
	public void contactsBtnClick() {
		Log.info("Action bar: Click contracts button");
		driver.findElement(contactsBtn).click();
		delay();
	}
	 
	public String getActionBarTitle() {
		waitFor(actionBarTitle);
		Log.info("Action bar: Get title");
		Log.info("Action bar: Title: " + driver.findElement(actionBarTitle).getText());
		return driver.findElement(actionBarTitle).getText();
	} 

}
