package ru.letoapp.screens.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class InLetoBankOfficesScreen extends AppScreenBase{
	String titleText = "В офисах банка";
	By hint = By.id("label_description");	
	String hintText = "Зачисление в тот же день. Рекомендуется";
	By addressesOnMap = By.xpath("//TextView[@id='label_action_addresses_on_map']");
	By getQRBtn = By.id("button_get_qr");
	String getQRBtnText = "Получить штрих-код";
	By contractNumberBlock = By.xpath("//CaptionTextItemView_");
	
	public InLetoBankOfficesScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {		
		verify.assertEquals(findElement(hint, driver).getText(), hintText , "Hint text");
		verify.assertTrue(findElement(addressesOnMap, driver).isDisplayed(), "Addresses on map");
		verify.assertTrue(findElement(getQRBtn, driver).isDisplayed(), "Get QR button");
		verify.assertTrue(findElement(contractNumberBlock, driver).isDisplayed(), "Contract name block");
		verify.assertEquals(getTitleFromActionBar(), titleText , "In leto bank offices screen: title");
		verify.assertAll();		
	}
}
