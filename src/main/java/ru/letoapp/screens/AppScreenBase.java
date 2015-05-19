package ru.letoapp.screens;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait.WaitTimedOutException;

import ru.letoapp.screens.others.ActionBar;
import ru.letoapp.screens.others.Drawer;
import ru.letoapp.screens.popups.ErrorPopup;
import ru.letoapp.utilities.ScreenshotMaker;

@SuppressWarnings("deprecation")
public class AppScreenBase extends ScreenBase {
	public static final Logger Log = Logger.getLogger(AppScreenBase.class);	
	private ActionBar actionBar;
	private Drawer drawer;
	private ErrorPopup errorPopup;
	By drawerLoc = By.id("mdc__layout_drawer");
	By errorPopupTitleLocator = By.id("sdl__title");
	By errorPopupMessageLocator = By.id("sdl__message");
	String errorPopuptitleText = "Ошибка…";
	String errorPopuptitleText2 = "Ошибка";
	public By waitPopup = By.id("sdl__message");	
	String waitPopupText = "Пожалуйста, подождите…";
	
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

/* ---- popups methods-----*/
	
	public ErrorPopup getErrorPopup() {
		return errorPopup;
	}
	
	public boolean isErrorPopupDisplayed() {
		if(findElement(errorPopupTitleLocator, driver) != null) {
			if(findElement(errorPopupTitleLocator, driver) == null) {
				Log.info("Error popup is not displayed");
				return false;
			}
			if((findElement(errorPopupTitleLocator, driver).getText().equals(errorPopuptitleText))||(findElement(errorPopupTitleLocator, driver).getText().equals(errorPopuptitleText2))) 
			{
				Log.error("Error popup displayed");			
				Log.error(findElement(errorPopupMessageLocator, driver).getText());				
				takeScreenshot();
				return true; 
			}			
			else {
				Log.info("Error popup is not displayed");
				return false;
			}
		}
		else{
			Log.info("Error popup is not displayed");
			return false;
		}
	}
	
	public boolean isWaitPopupDisplayed() {
		if(findElement(waitPopup, driver) != null) {
			if(findElement(waitPopup, driver) == null) {
				Log.info("Wait popup is not displayed");
				return false;
			}
			if(findElement(waitPopup, driver).getText().equals(waitPopupText))
			{
				Log.info("Wait popup displayed");
				return true; 
			} 		
			else {
				Log.info("Wait popup is not displayed");
				return false;
			}		
		}
		else {
			Log.info("Wait popup is not displayed");
			return false;
		}
	}
		
	public void waitForVanishWaitPopup() {		
		 try {
	            Wait<WebDriver> wait = new WebDriverWait(getDriver(), waitTimeout, 100);	            
	            wait.until(new ExpectedCondition<String>() {
	                public String apply(WebDriver driver) {	                	
	                    try {
	                    	WebElement element = findElement(waitPopup, driver);
	                    	if (null == element) {
	                    		Log.info("Wait popup vanished");
	                    		return "not_present";
	                    	} else if (!element.isDisplayed()) {
	                    		Log.info("Wait popup vanished");
	                    		return "not_displayed";
	                    	} else if (!element.getText().equals(waitPopupText)) {
	                    		Log.info("Wait popup vanished : Became another element");
	                    		return "not_displayed"; 
	                    	} else {
	                    		return null;
	                    	}
	                    	} catch (StaleElementReferenceException ex) {
	                    		Log.info("Wait popup is not attached to DOM, try again");	                        
	                    		return "not_attached_to_dom";
	                    	}     
	                }	                
	            });
	        } catch (WaitTimedOutException e) {
	            Log.info(waitPopup.toString() + "Timeout: Wait popup is still present");
	            throw e;
	   }
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
	
	public void takeScreenshot()
    {       
		Log.info("Taking screenshot");
		ScreenshotMaker.takeScreenshot(driver);
    }

}
