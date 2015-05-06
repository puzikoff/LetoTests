package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.screens.AppScreenBase;
import ru.letoapp.screens.popups.PhoneCallPopup;

public class ContactsScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(ContactsScreen.class);
	PhoneCallPopup phoneCallPopup;
	
	By stillToRepayTheLoan = By.xpath("//TextView[@id='label_caption']");
	String stillToRepayTheLoanText = "Где ещё погасить кредит?";
	By addressesOnMap = By.xpath("//TextView[@id='label_captionlabel_action_addresses_on_map']");
	String addressesOnMapText = "Адреса на карте";
	By phoneCallBtn = By.xpath("//TextView[@id='label_phone_number']");
	String phoneCallText = "ПОЗВОНИТЬ В ЛЕТО БАНК";
	String phoneCallNumber = "+7 800 550 0770";
	By phoneCallTip = By.xpath("//NoSaveStateFrameLayout/LinearLayout/TextView[2]");
	String phoneCallTipText = "Клиентская служба ответит на ваши вопросы\nс 8:00 до 22:00 по московскому времени.\nЗвонок по России бесплатный";
	By foreignPhoneCallBtn = By.xpath("//TextView[@id='label_foreign_phone_number']");
	String foreignPhoneCallText = "+7 495 532 1300";
	By writeToBank = By.xpath("//LinearLayout[@id='layout_section_write_to_us']");
	String writeToBankText = "Написать в Лето Банк";
	By bankSite = By.xpath("//LinearLayout[@id='layout_section_web']");
	String bankSiteText = "Сайт банка";
	
	public ContactsScreen(WebDriver driver) {
		super(driver);		
		phoneCallPopup = PageFactory.initElements(driver, PhoneCallPopup.class);
		phoneCallPopup.setDriver(driver);
	}
	
	public PhoneCallPopup getPhoneCallPopup() {
		return phoneCallPopup;
	}
	
	public void stillToRepayTheLoanClick () {
		waitFor(stillToRepayTheLoan);
		Log.info("Contacts screen: Where still to repay the loan");
		driver.findElement(stillToRepayTheLoan).click();
		delay();
	}
	
	public void phoneCallClick () {
		waitFor(phoneCallBtn);
		Log.info("Contacts screen: Phone call click");
		driver.findElement(phoneCallBtn).click();
		delay();
	}
	
	public void foreignPhoneCallClick () {
		waitFor(foreignPhoneCallBtn);
		Log.info("Contacts screen: Foreign Phone call click");
		driver.findElement(foreignPhoneCallBtn).click();
		delay();
	}
	
	public void writeToBankClick () {
		waitFor(writeToBank);
		Log.info("Contacts screen: Write to bank click");
		driver.findElement(writeToBank).click();
		delay();
	}
	
	public void bankSiteClick () {
		waitFor(bankSite);
		Log.info("Contacts screen: Write to bank click");
		driver.findElement(bankSite).click();
		delay();
	}

}
