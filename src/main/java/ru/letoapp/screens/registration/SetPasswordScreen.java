package ru.letoapp.screens.registration;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.letoapp.screens.AppScreenBase;

public class SetPasswordScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(SetPasswordScreen.class);
	By nextBtn = By.id("button_further");
	By passwordField = By.id("text_password");
	By confirmPasswordField = By.id("text_confirm_password");
	By wrongConfirmPasswordError = By.xpath("//TextView[contains(@value, 'Пароли не совпадают')]");
	By weakPasswordError = By.xpath("//TextView[contains(@value, 'Ненадёжный пароль')]");
	By errorPopupLocator = By.id("sdl__message");

	public SetPasswordScreen(WebDriver driver) {
		super(driver);
	}
	
	public boolean isErrorPopupDisplayed() {
		List <WebElement> errorPopups = driver.findElements(errorPopupLocator);
		if(!errorPopups.isEmpty()) {
			Log.info("Set password screen: Error popup displayed");
			Log.info(driver.findElement(errorPopupLocator).getText());
			return true;
		}
		Log.info("Auth screen: Empty login popup is not displayed");
		return false;
	}

	public void enterPassword(String password) {
		waitFor(passwordField);
		Log.info("Set Password Screen: Entering password: " + password);
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}

	public void isWeakPasswordErrorDisplayed() {
		waitFor(weakPasswordError);
		if(driver.findElement(weakPasswordError).isDisplayed())
			Log.info("Set Password Screen: Error: " + driver.findElement(weakPasswordError).getText());
		else
			Log.error("Set Password Screen: No weak password error");
	}

	public void confirmPassword(String confirmPassword) {
		waitFor(confirmPasswordField);
		Log.info("Set Password Screen: Confirm password: " + confirmPassword);
		driver.findElement(confirmPasswordField).clear();
		driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	}

	public void isWrongConfirmPasswordErrorDisplayed() {
		waitFor(wrongConfirmPasswordError);
		if(driver.findElement(wrongConfirmPasswordError).isDisplayed())
			Log.info("Set Password Screen: Error: " + driver.findElement(wrongConfirmPasswordError).getText());
		else
			Log.error("Set Password Screen: No wrong confirm password error");
	}

	public void nextBtnClick() {
		waitFor(nextBtn);
		Log.info("Set Password Screen: Click next button");
		driver.findElement(nextBtn).click();
		delay();
	}

}
