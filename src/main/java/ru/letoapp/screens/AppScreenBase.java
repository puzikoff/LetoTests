package ru.letoapp.screens;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import ru.letoapp.screens.others.ActionBar;
import ru.letoapp.screens.others.Drawer;
import ru.letoapp.screens.popups.ErrorPopup;

public class AppScreenBase extends ScreenBase {
	public static final Logger Log = Logger.getLogger(AppScreenBase.class);
	
	
	private ActionBar actionBar;
	private Drawer drawer;
	private ErrorPopup errorPopup;
	By drawerLoc = By.id("mdc__layout_drawer");
	By errorPopupTitleLocator = By.id("sdl__title");
	By errorPopupMessageLocator = By.id("sdl__message");
	String errorPopuptitleText = "Ошибка…";

	public AppScreenBase(WebDriver driver) {
		super(driver);
		actionBar = PageFactory.initElements(driver, ActionBar.class);
		drawer = PageFactory.initElements(driver, Drawer.class);
		errorPopup = PageFactory.initElements(driver, ErrorPopup.class);		
		actionBar.setDriver(driver);		
		drawer.setDriver(driver);
		errorPopup.setDriver(driver);
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
	
	public void openDrawer() {
		actionBar.menuBtnClick();
	}
	
	public void closeDrawer() {
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
	public Drawer getDrawer(){
		return drawer;
	}
	
/* ---- Drawer methods ENDS-----*/

/* ---- Error popup methods-----*/
	
	public ErrorPopup getErrorPopup() {
		return errorPopup;
	}
	
	public boolean isErrorPopupDisplayed() {
		List <WebElement> errorPopups = driver.findElements(errorPopupTitleLocator);
		if(!errorPopups.isEmpty()) {
			if(errorPopups.get(0).getText().equals(errorPopuptitleText)) {
				Log.info("Error popup displayed");
				Log.info(driver.findElement(errorPopupTitleLocator).getText());
				Log.info(driver.findElement(errorPopupMessageLocator).getText());
				return true;
			}			
			Log.info("Error popup is not displayed");
			return false;
		}
		Log.info("Error popup is not displayed");
		return false;
	}
	
/* ---- Error popup methods ends -----*/

/* ------ Common methods --- */
	
	
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
	
	/* ------ Common methods --- ENDS*/	

}
