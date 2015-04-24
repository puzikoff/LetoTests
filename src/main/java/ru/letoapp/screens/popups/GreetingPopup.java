package ru.letoapp.screens.popups;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class GreetingPopup extends PopupBase{
	public static final Logger Log = Logger.getLogger(GreetingPopup.class);
	
	String messageText = "Уважаемый клиент, эта версия приложения является предварительной и находится в процессе тестирования. Мы будем рады получить ваши пожелания и предложения по работе сервиса на адрес электронной почты, который вы найдете в разделе «Контакты».\n\nБлагодарим вас за пользование услугами «Лето Банка»! Спасибо, что выбрали нас!";
	String titleText = "Информация";
	String nextBtnText = "Продолжить";
	
	public void verifyGreeting() {		
		waitFor(nextBtn);
		Log.info("Greeting popup: Verify greeting window");
		verify.assertEquals(driver.findElement(message).getText(), messageText, "Greeting message text");
		verify.assertEquals(driver.findElement(title).getText(), titleText, "Greeting title");		
		verify.assertEquals(driver.findElement(nextBtn).getText(), nextBtnText, "Next button text");
		verify.assertAll();
	}

	public GreetingPopup(WebDriver driver) {
		super(driver);
	}	

}
