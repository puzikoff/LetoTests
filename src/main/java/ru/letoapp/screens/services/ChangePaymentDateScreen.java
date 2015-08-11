package ru.letoapp.screens.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class ChangePaymentDateScreen extends AppScreenBase{
	String title = "Меняю дату платежа";
	By serviceHint = By.xpath("//TextView[@id='label_content']");
	String serviceHintText = "Можно выбрать любое число с 4-го по 28-е. Максимальная величина переноса даты - 15 дней от текущего платежа";
	By commisionBlock = By.xpath("//TextView[@value='КОМИССИЯ ЗА ПОДКЛЮЧЕНИЕ']");
	By connectionPossibilityBlock = By.xpath("//TextView[@value='ВОЗМОЖНОСТЬ ПОДКЛЮЧЕНИЯ']");
	By calendarBlock = By.xpath("//TextView[@value='ВЫБЕРИТЕ НОВУЮ ДАТУ']");
	By serviceChangesTitle = By.xpath("//TextView[@id='label_title'][@value='ЧТО БУДЕТ, ЕСЛИ ИЗМЕНИТЬ ДАТУ ПЛАТЕЖА?']");
	By nextPaymentBlock = By.xpath("//TextView[@value='СЛЕДУЮЩИЙ ПЛАТЁЖ']");
	By connectBtn = By.xpath("//Button[@id='button']");
	
	public ChangePaymentDateScreen(WebDriver driver) {
		super(driver);
	}
	
	public void connectBtnClick() {
		Log.info("Change Payment Date screen: connect button click");
		findElement(connectBtn, driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}
	
	public void verifyBeforeCalculation(){
		Log.info("Change Payment Date screen: verify before calculation");
		verify.assertEquals(getTitleFromActionBar(), title, "Title");
		verify.assertEquals(findElement(serviceHint, driver).getText(),  serviceHintText, "Service hint text");
		verify.assertTrue(findElement(connectionPossibilityBlock, driver) != null, "Connection possibility block");
		verify.assertTrue(findElement(calendarBlock, driver) != null, "Calendar block");
		verify.assertAll();		
	}
	
	public void verifyAfterCalculation(){
		Log.info("Change Payment Date screen: verify after calculation");
		verify.assertEquals(getTitleFromActionBar(), title, "Title");
		verify.assertEquals(findElement(serviceHint, driver).getText(),  serviceHintText, "Service hint text");
		verify.assertTrue(findElement(commisionBlock, driver) != null, "Commission block");
		verify.assertTrue(findElement(connectionPossibilityBlock, driver) != null, "Connection possibility block");
		verify.assertTrue(findElement(calendarBlock, driver) != null, "Calendar block");
		verify.assertTrue(findElement(nextPaymentBlock, driver) != null, "Next payment block");
		verify.assertTrue(findElement(connectBtn, driver) != null, "Connect button");
		verify.assertAll();
	}
	
	public void chooseNewDate(String date) {

		Log.info("Change payment date screen: Choose date: " + date);
		findElement(By.xpath("//TextView[@id='label_day_of_month'][@value='" + date + "']"), driver).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }				
	}

}
