package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

public class AppScreenBase extends ScreenBase {
	public static final Logger Log = Logger.getLogger(AppScreenBase.class);
	
	private ActionBar actionBar;
	private Drawer drawer;
	By drawerLoc = By.id("mdc__layout_drawer");

	public AppScreenBase(WebDriver driver) {
		super(driver);
		actionBar = PageFactory.initElements(driver, ActionBar.class);
		drawer = PageFactory.initElements(driver, Drawer.class);
		actionBar.setDriver(driver);		
		drawer.setDriver(driver);
	}
	
/* ---- Action Bar methods -----*/		
	public String getTitleFromActionBar() {
		return actionBar.getActionBarTitle();
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

	public String getActionBarTitle() {
		return actionBar.getActionBarTitle();
	}
	
/* ---- Action Bar methods Ends-----*/
	
/* ---- Drawer methods -----*/
	public void drawerContactsBtnClick() {
		drawer.drawerContactsBtnClick();
	}
	
	public void drawerAboutBankBtnClick() {
		drawer.drawerAboutBankBtnClick();
	}
	
	public void exitBtnClick() {
		drawer.exitBtnClick();
	}
	
/* ---- Drawer methods ENDS-----*/
	
	
	public String onlyNumbersString(String s) {
		s = s.replaceAll("\\D+", "");	
		return s;
	}
	
	public void swipeOpenDrawer() {	
		TouchActions flick = new TouchActions(driver).flick(driver.findElement(drawerLoc), +150, 0, 1);
		flick.perform();		
	}	
	
	public void scroll() throws Exception {	
		TouchActions scroll = new TouchActions(driver).down(0, 1200);
		scroll.perform();		
	}
	
	

}
