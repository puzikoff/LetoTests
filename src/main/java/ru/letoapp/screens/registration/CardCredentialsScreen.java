package ru.letoapp.screens.registration;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.screens.AppScreenBase;
import ru.letoapp.screens.popups.EmptyAccessCodePopup;
import ru.letoapp.screens.popups.EmptyCardNumberPopup;
import ru.letoapp.screens.popups.IncorrectCardNumberOrAccesCodePopup;

public class CardCredentialsScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(CardCredentialsScreen.class);
	
	EmptyCardNumberPopup emptyCardNumberPopup;
	EmptyAccessCodePopup emptyAccessCodePopup;
	IncorrectCardNumberOrAccesCodePopup incorrectCardNumberOrAccesCodePopup;
	
	String actionBarTitleText = "Регистрация"; 
	By cardNumberTitle = By.xpath("//MaskedEditText[1]/../TextView[1]");
	By accessCodeTitle = By.xpath("//MaskedEditText[1]/../TextView[2]");
	By accessCodeTip = By.xpath("//MaskedEditText[1]/../TextView[3]");
	String cardNumberTitleText = "Введите номер вашей карты\nЛето Банка";
	String accessCodeTitleText = "Введите 6-значный код доступа";
	String accessCodeTipText = "Мы прислали его в SMS\nпри заключении договора с банком";
	By cardNumberField = By.id("text_card_number");
	By accessCodeField = By.id("text_access_code");
	By nextBtn = By.id("button_further");
	By forgetAccessLink = By.id("button_remind_access_code");
	String forgetAccessLinkText = "Не знаете код доступа?";
	String nextBtnText = "Далее";

	public CardCredentialsScreen(WebDriver driver) {
		super(driver);		
		emptyCardNumberPopup = PageFactory.initElements(driver, EmptyCardNumberPopup.class);
		emptyCardNumberPopup.setDriver(driver);
		emptyAccessCodePopup = PageFactory.initElements(driver, EmptyAccessCodePopup.class);
		emptyAccessCodePopup.setDriver(driver);
		incorrectCardNumberOrAccesCodePopup = PageFactory.initElements(driver, IncorrectCardNumberOrAccesCodePopup.class);
		incorrectCardNumberOrAccesCodePopup.setDriver(driver);
	}
	
	public EmptyCardNumberPopup getEmptyCardNumberPopup() {
		return emptyCardNumberPopup;
	}
	
	public EmptyAccessCodePopup getEmptyAccessCodePopup() {
		return emptyAccessCodePopup;
	}
	
	public IncorrectCardNumberOrAccesCodePopup getIncorrectCardNumberOrAccesCodePopup() {
		return incorrectCardNumberOrAccesCodePopup;
	}
	
	public void verifyScreen() {
		verify.assertEquals(getActionBarTitle(), actionBarTitleText, "Action bar title");
		verify.assertEquals(driver.findElement(cardNumberTitle).getText(), cardNumberTitleText, "Card number title");		
		verify.assertEquals(driver.findElement(accessCodeTitle).getText(), accessCodeTitleText, "Access code title");
		verify.assertEquals(driver.findElement(accessCodeTip).getText(), accessCodeTipText, "Access code tip");		
		verify.assertEquals(driver.findElement(nextBtn).getText(), nextBtnText, "Next button text");
		verify.assertEquals(driver.findElement(forgetAccessLink).getText(), forgetAccessLinkText, "Forget Access code link text");
		verify.assertAll();
	}

	public void enterCardNumber(String cardNumber) {
		waitFor(cardNumberField);
		Log.info("Card Credentials Screen: Entering card number");
		driver.findElement(cardNumberField).clear();
		driver.findElement(cardNumberField).sendKeys(cardNumber);		
	}

	public void enterAccessCode(String accessCode) {
		waitFor(accessCodeField);
		Log.info("Card Credentials Screen: Entering access code");
		driver.findElement(accessCodeField).clear();
		driver.findElement(accessCodeField).sendKeys(accessCode);
	}

	public void NextBtnClick() {
		waitFor(nextBtn);
		Log.info("Card Credentials Screen: Click next button");
		driver.findElement(nextBtn).click();
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

	public void forgotCardNumberBtnClick() {
		waitFor(forgetAccessLink);
		Log.info("Card Credentials Screen: Click forget access code or card number button");
		driver.findElement(forgetAccessLink).click();	
		delay();
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}

}
