package ru.letoapp.screens.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.ScreenBase;

public class ActionBar extends ScreenBase{
	
	By menuBtn = By.id("home");
	By actionBarTitle = By.id("action_bar_title");	
	By navUpBtn = By.xpath("//HomeView/ImageView[@id='up']");
	By contactsBtn = By.id("menu_item_contacts");
	
	public ActionBar(WebDriver driver) {
		super(driver);
	} 	 
	
	public void menuBtnClick() {
		Log.info("Action bar: Menu button click");
		findElement(menuBtn, driver).click();
		delay();
	}
	 
	public void navUpBtnClick() {
		Log.info("Action bar: Click NavUp button");
		waitFor(navUpBtn);
		findElement(navUpBtn, driver).click();	
		delay();
	}
	 
	public void contactsBtnClick() {
		waitForClickable(contactsBtn);
		Log.info("Action bar: Click contacts button");		
		findElement(contactsBtn, driver).click();
		delay();
	}
	 
	public String getActionBarTitle() {
		waitFor(actionBarTitle);
		Log.info("Action bar: Get title");
		Log.info("Action bar: Title: " + findElement(actionBarTitle, driver).getText());
		return findElement(actionBarTitle, driver).getText();
	} 

}
