package ru.letoapp.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class ScreenBase {
	private static final long DELAY_AFTER_ACTIVE_ACTION = 700;
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

}
