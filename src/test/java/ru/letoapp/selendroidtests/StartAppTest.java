package ru.letoapp.selendroidtests;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class StartAppTest extends TestBase { 
    
    @Test
    public void test() throws Exception {     
                
        selendroidHelper.getDriver().findElement(By.id("sdl__positive_button")).click();     
        selendroidHelper.getDriver().findElement(By.id("text_username")).clear();
        selendroidHelper.getDriver().findElement(By.id("text_username")).sendKeys("testuser@sb");
        selendroidHelper.getDriver().findElement(By.id("text_password")).clear();
        selendroidHelper.getDriver().findElement(By.id("text_password")).sendKeys("Qwerty");
        selendroidHelper.getDriver().findElement(By.id("button_login")).click();
    } 
}