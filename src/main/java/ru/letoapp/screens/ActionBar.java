package ru.letoapp.screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionBar extends ScreenBase{
	public static final Logger Log = Logger.getLogger(ActionBar.class);
	 By menuBtn = By.id("home");
	 //By menuBtn = By.xpath("//ActionBarView/LinearLayout/HomeView");
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
	 
	 public String getTitleFromActionBar() {
		 return "title";
	 }
	 

}
