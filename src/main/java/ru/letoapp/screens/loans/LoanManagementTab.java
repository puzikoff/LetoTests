package ru.letoapp.screens.loans;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class LoanManagementTab extends AppScreenBase{
	
	By repaymentBlock = By.xpath("//TextView[@value='Автопогашение']");
	By changePayDateBlock = By.xpath("//TextView[@value='Меняю дату платежа']");
	By skipPayBlock = By.xpath("//TextView[@value='Пропустить платёж']");
	By reducePayBlock = By.xpath("//TextView[@value='Уменьшить платёж']");
	By connectingServicesHistoryBtn = By.xpath("//TextView[@value='История подключения услуг']");		

	public LoanManagementTab(WebDriver driver) {
		super(driver);
	}
	
	public void serviceDetailsClick(String serviceName){
		Log.info("Loan management tab: " + serviceName + " detailes click");
		findElement(By.xpath("//TextView[@value='" + serviceName + "']/../../ImageView"), driver).click();
		findElement(By.xpath("//TextView[@value='" + serviceName + "']/../../..//TextView[@id='label_pressable_caption']"), driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void unwrapServiceBlock(String serviceName){
		Log.info("Loan management tab: Unwrap service " + serviceName + " block");
		findElement(By.xpath("//TextView[@value='" + serviceName + "']/../../ImageView"), driver).click();
	}
	
	public void wrapServiceBlock(String serviceName){
		Log.info("Loan management tab: Wrap service " + serviceName + " block");
		findElement(By.xpath("//TextView[@value='" + serviceName + "']/../../ImageView"), driver).click();		
	}
	
	public void connectingServicesHistoryBtnClick() {
		Log.info("Loan management tab: Connecting services button click");
		findElement(connectingServicesHistoryBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }
	}

}
