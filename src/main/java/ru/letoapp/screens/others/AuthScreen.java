package ru.letoapp.screens.others;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import ru.letoapp.screens.AppScreenBase;
import ru.letoapp.screens.popups.EmptyLoginPopup;
import ru.letoapp.screens.popups.EmptyPasswordPopup;
import ru.letoapp.screens.popups.GreetingPopup;

public class AuthScreen extends AppScreenBase {
	public static final Logger Log = Logger.getLogger(AuthScreen.class);
	GreetingPopup greetingPopup;
	EmptyLoginPopup emptyLoginPopup;
	EmptyPasswordPopup emptyPasswordPopup;

	By greetingMessage = By.id("sdl__message");
	By emptyLoginPopupLocator = By.xpath("//NoSaveStateFrameLayout/LinearLayout");
	By emptyPasswordPopupLocator = By.xpath("//NoSaveStateFrameLayout/LinearLayout");
	By authTitle = By.xpath("//ScrollView//TextView[3]");
	By authSubTitle = By.id("text_subtitle");
	By usernameTextField = By.id("text_username");
	By passwordTextField = By.id("text_password");
	By protCodeCheckbox = By.id("checkbox_set_protection_code");
	By loginBtn = By.id("button_login");	
	By remindLogPasLink = By.id("button_remind_login_or_password");
	By registerBtn = By.id("button_register");		
	String authTitleText = "Введите логин и пароль";
	String authSubTitleText = "Это поможет защитить ваши деньги";
	String protCodeCheckboxText = "Установить защитный код для быстрого входа";
	String loginBtnText = "Войти";
	String remindLogPasLinkText = "Забыли логин или пароль?";
	String registerBtnText = "Зарегистрироваться";	
	
	public AuthScreen(WebDriver driver) {
		super(driver);		
		greetingPopup = PageFactory.initElements(driver,GreetingPopup.class);
		greetingPopup.setDriver(driver);
		emptyLoginPopup = PageFactory.initElements(driver,EmptyLoginPopup.class);
		emptyLoginPopup.setDriver(driver);
		emptyPasswordPopup = PageFactory.initElements(driver,EmptyPasswordPopup.class);
		emptyPasswordPopup.setDriver(driver);
	}	
	
	public GreetingPopup getGreetingPopup() {
		return greetingPopup;
	}
	
	public EmptyLoginPopup getEmptyLoginPopup() {
		return emptyLoginPopup;
	}

	public EmptyPasswordPopup getEmptyPasswordPopup() {
		return emptyPasswordPopup;
	}

	
	public boolean isEmptyLoginPopupDisplayed() {
		List <WebElement> emptyLoginPopups = driver.findElements(emptyLoginPopupLocator);
		if(!emptyLoginPopups.isEmpty()) {
			Log.info("Auth screen: Empty login popup displayed");
			return true;
		}
		Log.info("Auth screen: Empty login popup is not displayed");
		return false;
	}
	
	public boolean isEmptyPasswordPopupDisplayed() {
		List <WebElement> emptyPasswordPopups = driver.findElements(emptyPasswordPopupLocator);
		if(!emptyPasswordPopups.isEmpty()) {
			Log.info("Auth screen: Empty password popup displayed");
			return true;
		}
		Log.info("Auth screen: Empty password popup is not displayed");
		return false;
	}		
	
	public boolean isGreetingMessageDisplayed() {
		List <WebElement> greetingPopUp = driver.findElements(greetingMessage);
		if(!greetingPopUp.isEmpty()) {
			Log.info("Auth screen: Greeting popup displayed");
			return true;
		}
		Log.info("Auth screen: Greeting popup is not displayed");
		return false;
	}		
	
	public void verifyAuthScreen() {		
		waitFor(loginBtn);
		Log.info("Auth screen: Verify auth screen");
		verify.assertEquals(driver.findElement(authTitle).getText(), authTitleText, "Auth title text");	
		verify.assertEquals(driver.findElement(authSubTitle).getText(), authSubTitleText, "Auth subtitle text");
		verify.assertEquals(driver.findElement(protCodeCheckbox).getText(), protCodeCheckboxText, "Auth protect code text");		
		verify.assertEquals(driver.findElement(loginBtn).getText(), loginBtnText, "Login button text");
		verify.assertEquals(driver.findElement(remindLogPasLink).getText(), remindLogPasLinkText, "Remind login or password text");		
		verify.assertEquals(driver.findElement(registerBtn).getText(), registerBtnText, "Register button text");
		verify.assertAll();
	}
	
	public void setProtCodeCheckbox () {		
		Log.info("Auth screen: Set protect code checkbox");
		driver.findElement(protCodeCheckbox).click();
		delay();
	}
	
	public boolean isProtCodeCheckboxSelected () {
		Log.info("Auth screen: Is protect code selected:" + driver.findElement(protCodeCheckbox).isSelected());
		return driver.findElement(protCodeCheckbox).isSelected();
	}
	
	public void loginBtnClick () {
		waitFor(loginBtn);
		Log.info("Auth screen: Click login button");
		driver.findElement(loginBtn).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}
	
	public void remindLogPasBtnClick () {
		Log.info("Auth screen: Click remind login and password link");
		driver.findElement(remindLogPasLink).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }		
	}
	
	public void registerBtnClick () {
		waitFor(registerBtn);
		Log.info("Auth screen: Click 'Registration' button'");
		driver.findElement(registerBtn).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}	
	
	public void enterUsername (String username) {
		waitFor(usernameTextField);
		Log.info("Auth screen: Enter Username: " + username);
		driver.findElement(usernameTextField).clear();
		driver.findElement(usernameTextField).sendKeys(username);
	}
	
	public String getUsername () {
		Log.info("Auth screen: get username");
		return driver.findElement(usernameTextField).getText();		
	}
	
	public void enterPassword (String password) {
		waitFor(passwordTextField);
		Log.info("Auth screen: Enter password: " + password);
		driver.findElement(passwordTextField).clear();
		driver.findElement(passwordTextField).sendKeys(password);
	}
}