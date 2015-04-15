package ru.letoapp.screens.others;

import java.util.List;

import io.selendroid.server.common.exceptions.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import com.google.common.base.Verify;

public class AuthScreen extends AppScreenBase {
	public static final Logger Log = Logger.getLogger(AuthScreen.class);

	By greetingTitle = By.id("sdl__title");
	By greetingMessage = By.id("sdl__message");
	By greetingNextBtn = By.id("sdl__positive_button");
	By authTitle = By.xpath("//ScrollView//TextView[3]");
	By authSubTitle = By.id("text_subtitle");
	By usernameTextField = By.id("text_username");
	By passwordTextField = By.id("text_password");
	By protCodeCheckbox = By.id("checkbox_set_protection_code");
	By loginBtn = By.id("button_login");	
	By remindLogPasLink = By.id("button_remind_login_or_password");
	By registerBtn = By.id("button_register");
	By drawerLoc = By.id("mdc__layout_drawer");
	String greetingMessageText = "Уважаемый клиент, эта версия приложения является предварительной и находится в процессе тестирования. Мы будем рады получить ваши пожелания и предложения по работе сервиса на адрес электронной почты, который вы найдете в разделе «Контакты».\n\nБлагодарим вас за пользование услугами «Лето Банка»! Спасибо, что выбрали нас!";
	String greetingTitleText = "Информация";
	String greetingNextBtnText = "Продолжить";
	String authTitleText = "Введите логин и пароль";
	String authSubTitleText = "Это поможет защитить ваши деньги";
	String protCodeCheckboxText = "Установить защитный код для быстрого входа";
	String loginBtnText = "Войти";
	String remindLogPasLinkText = "Забыли логин или пароль?";
	String registerBtnText = "Зарегистрироваться";	
	
	public AuthScreen(WebDriver driver) {
		super(driver);		
	}	
	
	public boolean isGreetingMessageDisplayed() {
		List <WebElement> greetingPopUp = driver.findElements(greetingMessage);
		if(!greetingPopUp.isEmpty()) return true;
		return false;
	}
	
	public void verifyGreeting() {		
		waitFor(greetingNextBtn);
		Log.info("Verify greeting window");
		Assert.assertEquals(driver.findElement(greetingMessage).getText(), greetingMessageText);
		Assert.assertEquals(driver.findElement(greetingTitle).getText(), greetingTitleText);		
		Assert.assertEquals(driver.findElement(greetingNextBtn).getText(), greetingNextBtnText);	
	}
	
	public void verifyAuthScreen() {		
		waitFor(loginBtn);
		Log.info("Verify auth screen");
		Verify.verify(driver.findElement(authTitle).getText().contentEquals(authTitleText), "Title is not correct", driver.findElement(authTitle).getText());	
		Assert.assertEquals(driver.findElement(authSubTitle).getText(), authSubTitleText);
		Assert.assertEquals(driver.findElement(protCodeCheckbox).getText(), protCodeCheckboxText);		
		Assert.assertEquals(driver.findElement(loginBtn).getText(), loginBtnText);
		Assert.assertEquals(driver.findElement(remindLogPasLink).getText(), remindLogPasLinkText);		
		Assert.assertEquals(driver.findElement(registerBtn).getText(), registerBtnText);
		//Assert.assertTrue(driver.findElement(protCodeCheckbox).isSelected());
	}
	
	public void setProtCodeCheckbox () {
		
		driver.findElement(protCodeCheckbox).click();
	}
	
	public boolean isProtCodeCheckboxSelected () {
		return driver.findElement(protCodeCheckbox).isSelected();
	}
	
	public void loginBtnClick () {
		driver.findElement(loginBtn).click();
	}
	
	public void remindLogPasBtnClick () {
		driver.findElement(remindLogPasLink).click();
	}
	
	public void registerBtnClick () {
		Log.info("Click 'Registration' button'");
		driver.findElement(registerBtn).click();
	}
	
	public void closeGreetingMessage () {
		Log.info("Click on confirm button");
		driver.findElement(greetingNextBtn).click();
	}
	
	public void enterUsername (String username) {
		driver.findElement(usernameTextField).clear();
		driver.findElement(usernameTextField).sendKeys(username);
	}
	
	public String getUsername () {
		return driver.findElement(usernameTextField).getText();		
	}
	
	public void enterPassword (String password) {
		driver.findElement(passwordTextField).clear();
		driver.findElement(passwordTextField).sendKeys(password);
	}
}
