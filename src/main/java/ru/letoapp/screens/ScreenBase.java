package ru.letoapp.screens;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.thoughtworks.selenium.Wait.WaitTimedOutException;

@SuppressWarnings("deprecation")
public class ScreenBase {
	public static final Logger Log = Logger.getLogger(ScreenBase.class);
	private static final long DELAY_AFTER_ACTIVE_ACTION = 700;
	protected final int waitTimeout = 6000;
	protected SoftAssert verify = new SoftAssert();
	protected WebDriver driver;	  

	    public ScreenBase(WebDriver driver) {
	        this.driver = driver;	     	       
	    }

	    public void setDriver(WebDriver driver) {
	        this.driver = driver;
	    }

	    public WebDriver getDriver() {
	        return driver;
	    }    
	    
	    public void delay() {
	        try {
	            Thread.sleep(DELAY_AFTER_ACTIVE_ACTION);
	        } catch (InterruptedException e) {}
	    }
	    
	    public void delay(long time) {
	        try {
	            Thread.sleep(time);
	        } catch (InterruptedException e) {}
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
		
		public void waitForClickable(By locator) {
			WebDriverWait waitVar =  new WebDriverWait(driver, 60);			
			waitVar.until(ExpectedConditions.elementToBeClickable(locator));		
		}
		
		public void waitForDisappear(final By by) {	        
	        try {
	            Wait<WebDriver> wait = new WebDriverWait(getDriver(), waitTimeout, 100);	            
	            wait.until(new ExpectedCondition<String>() {
	                public String apply(WebDriver driver) {	                	
	                    try {
	                    	WebElement element = findElement(by, driver);
	                    	if (null == element) {
	                    		Log.info("[waitForDisappear] Element vanished");
	                    		return "not_present";
	                    	} else if (!element.isDisplayed()) {
	                    		Log.info("[waitForDisappear] Element vanished");
	                    		return "not_displayed";	                    
	                    	} else {
	                    		return null;
	                    	}
	                    	} catch (StaleElementReferenceException ex) {
	                    		Log.info(by.toString() + "[waitForDisappear] Element not attached to DOM, try again");	                        
	                    		return "not_attached_to_dom";
	                    	}     
	                }	                
	            });
	        } catch (WaitTimedOutException e) {
	            Log.info(by.toString() + " : element is still present");
	            throw e;
	        }
	    }
		
		 public void waitForVanish(final By by) {			 
		        try { if (findElement(by, driver) == null) {
		              return;
		            }
		            Wait<WebDriver> wait = new WebDriverWait(getDriver(), waitTimeout, 100);
		            wait.until(new ExpectedCondition<Boolean>() {
		                @Override
		                public Boolean apply(WebDriver driver) {
		                    List<WebElement> elements = driver.findElements(by);
		                    return ((elements.size() == 0)||(!elements.get(0).isDisplayed()));
		                }
		            });
		            Log.info("[WaitForVanish] Element is gone");
		        }catch (NoSuchElementException ex) {
		        	Log.info("[WaitForVanish] Element is already gone");
		        }
		    }
		
		 public By getBy(String locator) {
	        if (locator.matches("^id=[\\d\\D]+"))
	            return By.id(locator.replaceAll("id=", ""));
	        else if (locator.matches("^xpath=[\\d\\D]+"))
	            return By.xpath(locator.replaceAll("xpath=", ""));
	        else if (locator.matches("^iexpath=[\\d\\D]+"))
	            return By.xpath(locator.replaceAll("iexpath=", ""));
	        else if (locator.contains("//"))
	            return By.xpath(locator);
	        else
	            return By.id(locator);
	    }
		
		 protected WebElement findElement(By by, WebDriver driver) {
		        List<WebElement> elements = driver.findElements(by);
		        if (elements.size() > 0) {
		            return elements.get(0);
		        } else {
		            return null;
		        }
		}	 
		
}
