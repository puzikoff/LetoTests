package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class ForgotPswScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(ForgotPswScreen.class);
	
	String actionBarTitle = "Забыли логин или пароль?";
	String titleText = "Вы всегда можете получить\nновые логин и пароль";
	String tipText = "Вам понадобится 16-значный номер вашей платёжной карты Лето Банка или 20-значный номер вашего счёта в Лето Банке, который начинается с цифры 4";
	String newCredentialsBtnText = "Получить новые логин и пароль";
	By title = By.xpath("//FrameLayout[@id='mdc__layout_content']//TextView[1]");
	By tip = By.xpath("//FrameLayout[@id='mdc__layout_content']//TextView[2]");
	By newCredentialsBtn = By.id("button_get_new_credentials");

	public ForgotPswScreen(WebDriver driver) {
		super(driver);		
	}
	
	public void verifyScreen() {
		Log.info("Forgot login or password screen: verify screen");
		verify.assertEquals(getTitleFromActionBar(), actionBarTitle, "Forgot login or password screen: Action bar title");
		verify.assertEquals(driver.findElement(title).getText(), titleText, "Forgot login or password screen: Title text");
		Log.info(driver.findElement(title).getText());
		verify.assertEquals(driver.findElement(tip).getText(), tipText, "Forgot login or password screen: Tip text");
		driver.findElement(tip).getText();
		verify.assertEquals(driver.findElement(newCredentialsBtn).getText(), newCredentialsBtnText, "Forgot login or password screen: Button text");
		verify.assertAll();
	}

	public void getNewCredentialsBtnClick() {
		waitFor(newCredentialsBtn);
		Log.info("Forgot Psw Screen: New credentials button click");
		driver.findElement(newCredentialsBtn).click();	
		delay();
	}

}
