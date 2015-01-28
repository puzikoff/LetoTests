package ru.letoapp.selendroidtests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StartAppTest extends TestBase { 
    
    @Test
    public void test() throws Exception {     
    	Logger logger = Logger.getLogger("startAppTestLogger");    	
    	FileHandler handler = new FileHandler("D:\\log.txt", true);   
    	logger.addHandler(handler);    	
    	
    	logger.log(Level.INFO, "Click on confirm button");
    	//selendroidHelper.getDriver().findElement(By.id("sdl__positive_button")).click();    	
        authScreen.verifyGreeting();
        authScreen.nextBtnClick();
        logger.log(Level.INFO, "Enter username");
        authScreen.enterUsername("testuser@sb");
        logger.log(Level.INFO, "Enter password");
        authScreen.enterPassword("Qwerty");
        logger.log(Level.INFO, "Click enter");
        authScreen.loginBtnClick();
        
    } 
}