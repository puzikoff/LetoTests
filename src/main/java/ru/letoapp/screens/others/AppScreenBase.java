package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
	
	public void waitFor(String xpath) {
		WebDriverWait waitVar =  new WebDriverWait(driver, 60);
		By x = By.xpath(xpath);
		waitVar.until(ExpectedConditions.presenceOfElementLocated(x));		
	}
	
	public void waitFor(By locator) {		
		WebDriverWait waitVar =  new WebDriverWait(driver, 60);
		waitVar.until(ExpectedConditions.presenceOfElementLocated(locator));		
	}
	
	public void waitForClickable(String xpath) {
		WebDriverWait waitVar =  new WebDriverWait(driver, 60);
		By x = By.xpath(xpath);
		waitVar.until(ExpectedConditions.elementToBeClickable(x));		
	}

}
