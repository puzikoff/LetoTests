package ru.letoapp.screens;

import org.openqa.selenium.By;
import org.testng.Assert;

import ru.letoapp.utilities.SelendroidHelper;

public class AuthScreen extends SelendroidHelper {
	By greetingTitle = By.id("sdl__titile");
	By greetingMessage = By.id("sdl__message");
	By greetingNextBtn = By.id("sdl__positive_button");
	By loginBtn = By.id("button_login");
	By usernameTextField = By.id("text_username");
	By passwordTextField = By.id("text_password");
	String greetingMsg = "Уважаемый клиент, эта версия приложения является предварительной и находится в процессе тестирования. Мы будем рады получить ваши пожелания и предложения по работе сервиса на адрес электронной почты, который вы найдете в разделе «Контакты».\n\nБлагодарим вас за пользование услугами «Лето Банка»! Спасибо, что выбрали нас!";
	String greetingTtl = "Информация";
	
	public void verifyGreeting() {
//		waitDriver.until(ExpectedConditions.presenceOfElementLocated(greetingTitle));
//		waitDriver.until(ExpectedConditions.elementToBeClickable(greetingNextBtn));
		Assert.assertEquals(driver.findElement(greetingMessage).getText(), greetingMsg);
		Assert.assertEquals(driver.findElement(greetingTitle).getText(), greetingTtl);
		Assert.assertTrue(driver.findElement(greetingNextBtn).isDisplayed());
		
	}
	
	public void loginBtnClick () {
		driver.findElement(loginBtn).click();
	}
	
	public void nextBtnClick () {
		getDriver().findElement(greetingNextBtn).click();
	}
	
	public void enterUsername (String username) {
		driver.findElement(usernameTextField).clear();
		driver.findElement(usernameTextField).sendKeys(username);
	}
	
	public void enterPassword (String password) {
		driver.findElement(passwordTextField).clear();
		driver.findElement(passwordTextField).sendKeys(password);
	}
	
	
}
