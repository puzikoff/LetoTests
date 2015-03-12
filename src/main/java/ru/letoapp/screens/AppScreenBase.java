package ru.letoapp.screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

public class AppScreenBase extends ScreenBase {
	public static final Logger Log = Logger.getLogger(ScreenBase.class);
	private ActionBar actionBar;
	By drawerLoc = By.id("mdc__layout_drawer");

	public AppScreenBase(WebDriver driver) {
		super(driver);
		actionBar = PageFactory.initElements(driver, ActionBar.class);
		actionBar.setDriver(driver);		
	}
	
	public String getTitleFromActionBar() {
		return actionBar.getTitleFromActionBar();
	}
	
	public void navUpBtnClick() {
		actionBar.navUpBtnClick();
	}
	
	public void menuBtnClick() {
		actionBar.menuBtnClick();
	}
	
	public void contactsBtnClick() {
		actionBar.contactsBtnClick();
	}
	
	public void swipeOpenDrawer() {	
		TouchActions flick = new TouchActions(driver).flick(driver.findElement(drawerLoc), +150, 0, 1);
		flick.perform();		
	}
	
	public void scroll() throws Exception {	
		TouchActions scroll = new TouchActions(driver).down(0, 1200);
		scroll.perform();		
		scroll = new TouchActions(driver).up(-800, -800);
		scroll.perform();
		scroll = new TouchActions(driver).up(0, -800);
		scroll.perform();
		scroll = new TouchActions(driver).up(800, 0);
		scroll.perform();
		scroll = new TouchActions(driver).up(-800, 0);
		scroll.perform();
		scroll = new TouchActions(driver).up(800, 800);
		scroll.perform();
		scroll = new TouchActions(driver).up(-800, -800);
		scroll.perform();
		Thread.sleep(2000);
	}

}
