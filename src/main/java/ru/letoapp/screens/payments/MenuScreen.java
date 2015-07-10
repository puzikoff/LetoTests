package ru.letoapp.screens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;

import ru.letoapp.screens.AppScreenBase;

public class MenuScreen extends AppScreenBase{
	By serachField = By.xpath("//EditText");

	public MenuScreen(WebDriver driver) {
		super(driver);
	}
	
	public void categoryClick(String categoryName) {
		Log.info("Menu: Choose category - " + categoryName);
		findElement(By.xpath("//MenuItemView_//TextView[@value='" + categoryName + "']"), driver).click();
		//waitFor(By.xpath("//MenuItemView_//TextView[@value='МТС']"));
		delay();		
	}
	
	public void paymentClick(String paymentName) {
		Log.info("Menu: Choose category - " + paymentName);
		findElement(By.xpath("//MenuItemView_//TextView[@value='" + paymentName + "']"), driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}
	
	/*public void paymentClick(String paymentName) {
		Log.info("Menu: Choose category - " + paymentName);
		Log.info("Menu: Scroll to element - " + paymentName);
	
		while(findElement(By.xpath("//MenuItemView_//TextView[@value='" + paymentName + "']"), driver) == null) {		
			TouchActions scroll = new TouchActions(driver).scroll(0, 200);
			scroll.perform();	
		}	
		findElement(By.xpath("//MenuItemView_//TextView[@value='" + paymentName + "']"), driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
    		waitForVanishWaitPopup();
    	}		
	}*/
	
	public void searchBy(String searchString) {
		Log.info("Menu: Search by - " + searchString);
		findElement(serachField, driver).clear();
		findElement(serachField, driver).sendKeys(searchString);
	}

}
