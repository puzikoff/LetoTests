package ru.letoapp.screens.others;

import org.openqa.selenium.WebDriver;

public class ScreenBase {
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

}
