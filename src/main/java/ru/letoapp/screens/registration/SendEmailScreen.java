package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.others.AppScreenBase;

public class SendEmailScreen extends AppScreenBase{	
	public static final Logger Log = Logger.getLogger(SendEmailScreen.class);
	
	By emailField = By.id("text_email");
	By sendBtn = By.id("button_send");
	By emptyEmailPopupError = By.xpath("//TextView[@value='Поле «Адрес электронной почты» должно быть заполнено.']");
	By emptyEmailPopupNextBtn = By.id("sdl__positive_button");
	By title = By.xpath("//TextView[contains(@value, 'На него будет отправлен договор')]");
	
	public SendEmailScreen(WebDriver driver) {
		super(driver);		
	}

	public void sendBtnClick() {		
		waitFor(sendBtn);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		Log.info("Click send button");
		driver.findElement(sendBtn).click();		
	}

	public void emptyEmailPopupNextBtnClick() {		
		waitFor(emptyEmailPopupError);
		Log.info("Click next");
		driver.findElement(emptyEmailPopupNextBtn).click();		
	}

	public void enterEmail(String email) {
		Log.info("Entering email: " + email);
		driver.findElement(emailField).clear();
		driver.findElement(emailField).sendKeys(email);		
	}

}
