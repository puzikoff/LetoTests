package ru.letoapp.screens.others;

import org.openqa.selenium.WebDriver;

public class ScreenBase {
	private static final long DELAY_AFTER_ACTIVE_ACTION = 700;
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

}
