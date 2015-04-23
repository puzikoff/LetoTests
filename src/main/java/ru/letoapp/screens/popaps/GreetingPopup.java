package ru.letoapp.screens.popaps;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class GreetingPopup extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(GreetingPopup.class);
	
	By title = By.id("sdl__title");
	By message = By.id("sdl__message");
	By nextBtn = By.id("sdl__positive_button");
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
	
	public void nextBtnClick () {
		waitFor(nextBtn);
		Log.info("Greeting popup: Click on confirm button");
		driver.findElement(nextBtn).click();
		delay();
	}

}
