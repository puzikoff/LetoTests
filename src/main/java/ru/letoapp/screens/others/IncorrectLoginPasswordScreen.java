package ru.letoapp.screens.others;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class IncorrectLoginPasswordScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(IncorrectLoginPasswordScreen.class);
	
	By title = By.xpath("//Button[@id='button_try_again']/../TextView[1]");
	By subTitle = By.xpath("//Button[@id='button_try_again']/../TextView[2]");
	By resetTip = By.xpath("//Button[@id='button_reset_credentials']/../TextView[1]");
	By resetTip2 = By.xpath("//Button[@id='button_reset_credentials']/../TextView[2]");
	By tryAgainBtn = By.id("button_try_again");
	By resetCredentialsBtn = By.id("button_reset_credentials");
	String titleText = "Логин или пароль неверные";
	String subTitleText = "Попробуйте ввести их ещё раз";
	String tryAgainBtnText = "Попробовать ещё раз";
	String resetTipText = "Если вам не удается вспомнить логин или пароль, вы можете сбросить их и установить заново";	
	String resetTip2Text = "Вам понадобится 16-значный номер вашей платёжной карты Лето Банка или 20-значный номер вашего счёта в Лето Банке, который начинается с цифры 4";
	String resetCredentialsBtnText = "Сбросить логин и пароль";
	
	public IncorrectLoginPasswordScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void verifyScreen() {
		Log.info("Incorrect Login or Password Screen: Verify screen");
		verify.assertEquals(driver.findElement(title).getText(), titleText, "Title");		
		verify.assertEquals(driver.findElement(subTitle).getText(), subTitleText, "Subtitle");		
		verify.assertEquals(driver.findElement(tryAgainBtn).getText(), tryAgainBtnText, "Try again button");		
		verify.assertEquals(driver.findElement(resetTip).getText(), resetTipText, "Reset credentials tip");		
		verify.assertEquals(driver.findElement(resetTip2).getText(), resetTip2Text, "Reset credentials tip 2");		
		verify.assertEquals(driver.findElement(resetCredentialsBtn).getText(), resetCredentialsBtnText, "Reset credentials button");		
		verify.assertAll();
	}

	public void tryAgainBtnClick() {
		waitForClickable(tryAgainBtn);
		Log.info("Incorrect Login or Password Screen: Try again button click");
		driver.findElement(tryAgainBtn).click();	
		delay();
	}
	
	public void resetCredentialsBtnClick() {
		waitForClickable(resetCredentialsBtn);
		Log.info("Incorrect Login or Password Screen: Reset credentials button click");
		driver.findElement(resetCredentialsBtn).click();	
		delay();		
	}

}
