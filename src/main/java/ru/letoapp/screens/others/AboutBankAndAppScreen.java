package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AboutBankAndAppScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(AboutBankAndAppScreen.class);
	By writeToUsBtn = By.id("layout_section_write_to_us");
	By title1 = By.xpath("//ScrollView//LinearLayout/LinearLayout[1]/TextView[1]");
	String title1Text = "ПАО «Лето Банк»";
	By title2 = By.xpath("//ScrollView//LinearLayout/LinearLayout[1]/TextView[2]");
	String title2Text = "Лицензия ЦБ РФ на осуществление банковских операций № 650 от 15 октября 2012.";
	By title3 = By.xpath("//ScrollView//LinearLayout/LinearLayout[1]/TextView[3]");
	String title3Text = "Является частью международной финансовой группы ВТБ.";
	By title5 = By.xpath("//ScrollView//LinearLayout/LinearLayout[1]/TextView[5]");
	String title5Text = "Эта версия приложения является предварительной и находится в процессе тестирования. Мы будем рады получить Ваши пожелания и предложения по работе Мобильного банка. Ваше мнение очень важно для нас!";
	
	public AboutBankAndAppScreen(WebDriver driver) {
		super(driver);
	}

}
