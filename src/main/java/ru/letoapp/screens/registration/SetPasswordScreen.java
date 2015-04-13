package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.others.AppScreenBase;

public class SetPasswordScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(SetPasswordScreen.class);
	By nextBtn = By.id("button_further");
	By passwordField = By.id("text_password");
	By confirmPasswordField = By.id("text_confirm_password");
	By wrongConfirmPasswordError = By.xpath("//TextView[contains(@value, 'Пароли не совпадают')]");
	By weakPasswordError = By.xpath("//TextView[contains(@value, 'Ненадёжный пароль')]");

	public SetPasswordScreen(WebDriver driver) {
		super(driver);
	}

	public void enterPassword(String password) {
		waitFor(passwordField);
		Log.info("Entering password: " + password);
		driver.findElement(passwordField).clear();
		driver.findElement(passwordField).sendKeys(password);
	}

	public void isWeakPasswordErrorDisplayed() {
		waitFor(weakPasswordError);
		if(driver.findElement(weakPasswordError).isDisplayed())
			Log.info("Error: " + driver.findElement(weakPasswordError).getText());
		else
			Log.error("No weak password error");
	}

	public void confirmPassword(String confirmPassword) {
		waitFor(confirmPasswordField);
		Log.info("Confirm password: " + confirmPassword);
		driver.findElement(confirmPasswordField).clear();
		driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	}

	public void isWrongConfirmPasswordErrorDisplayed() {
		waitFor(wrongConfirmPasswordError);
		if(driver.findElement(wrongConfirmPasswordError).isDisplayed())
			Log.info("Error: " + driver.findElement(wrongConfirmPasswordError).getText());
		else
			Log.error("No wrong confirm password error");
	}

	public void nextBtnClick() {
		waitFor(nextBtn);
		Log.info("Click next button");
		driver.findElement(nextBtn).click();
	}

}
