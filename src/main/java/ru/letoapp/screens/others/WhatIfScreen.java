package ru.letoapp.screens.others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class WhatIfScreen extends AppScreenBase{

	public WhatIfScreen(WebDriver driver) {
		super(driver);
	}
	
	String titleText = "Что, если?..";

	
	/*-- Loan widgets --*/
	By payMoreWidget = By.id("widget_what_if_pay_more");
	By payMoreWidgetText = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_more']//TextView[@id='label_description']");
	String payMoreText = "В текущем периоде подключена услуга «Досрочное погашение», поэтому мы уменьшим размер ежемесячного платежа в последующих месяцах, если вы внесете средства сверх сумммы очередного платежа.";
	By payMore = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_more']//TextView[@id='label_pressable_caption']");
	
	By payLessWidget = By.id("widget_what_if_pay_less");
	By payLessWidgetText = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_less']//TextView[@id='label_description']");
	String payLessText = "Вам нужно будет доплатить оставшуюся часть очередного платежа до наступления его даты.";
	
	By payAllWidget = By.id("widget_what_if_pay_all");
	By payAllWidgetText = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_all']//TextView[@id='label_description']");
	String payAllText = "Вы можете рассчитать сумму, которую потребуется внести, чтобы полностью погасить кредит до его планового закрытия.";
	By payAll = By.xpath("//CollapsibleActionView_[@id='widget_what_if_pay_all']//TextView[@id='label_pressable_caption']");
	
	By insuranceCaseWidget = By.id("widget_what_if_insurance_case");
	By insuranceCaseWidgetText = By.xpath("//CollapsibleContactBankActionView_[@id='widget_what_if_insurance_case']//TextView[@id='label_description']");
	String insuranceCaseText = "Позвоните в службу поддержки или приходите в офис Лето Банка";
	
	By dismissPaymentWidget = By.id("widget_what_if_pass_case_alt");
	By dismissPaymentWidgetText = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_pass_case_alt']//TextView[@id='label_description']");
	String dismissPaymentText = "У меня нет возможности оплатить следующий платёж, можно ли его пропустить?";
	By dismissPayment = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_pass_case_alt']//TextView[@id='label_pressable_caption']");
	
	By decreasePaymentWidget = By.id("widget_what_if_decrease_case_alt");
	By decreasePaymentWidgetText = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_decrease_case_alt']//TextView[@id='label_description']");
	String decreasePaymentText = "Мне трудно оплачивать кредит, можно ли уменьшить сумму ежемесячного платежа?";
	By turnOffInsurance = By.xpath("//TextView[@id='Что, если я отключу страховую защиту?']");
	
	By changePayDateWidget = By.id("widget_what_if_change_date_case_alt");
	By changePayDateWidgetText = By.xpath("//CollapsibleMultiActionView_[@id='widget_what_if_change_date_case_alt']//TextView[@id='label_description']");
	String changePayDateText = "Я попал в больницу или нахожусь в отпуске и мне неудобно платить в текущую дату. Можно ли перенести дату платежа?";	
	By changePayDate = By.xpath("//TextView[@id='Что будет, если изменить дату платежа?']");
	
	/* - Card widgets */
	By whatIfCardLostWidget = By.id("widget_what_if_card_lost");
	By whatIfCardLostWidgetText = By.xpath("//CollapsibleContactBankActionView_[@id='widget_what_if_card_lost']//TextView[@id='label_description']");
	String whatIfCardLostText = "Установите запрет на снятие денежных средств и позвоните в клиентскую службу для блокировки карты. Специалисты банка проконсультируют по дальнейшим действиям.";
	
	By whatIfCardBrokenWidget = By.id("widget_what_if_card_broken");
	By whatIfCardBrokenWidgetText = By.xpath("//CollapsibleContactBankActionView_[@id='widget_what_if_card_broken']//TextView[@id='label_description']");
	String whatIfCardBrokenText = "Позвоните в клиентскую службу, специалисты банка проконсультируют по дальнейшим действиям.";
	
	By whatIfCardAbroadWidget = By.id("widget_what_if_abroad");
	By whatIfCardAbroadWidgetText = By.xpath("//CollapsibleActionView_[@id='widget_what_if_abroad']//TextView[@id='label_description']");
	String whatIfCardAbroadText = "Используя эту карту при оплате в других валютах, вы ничего не теряете.\n\nКурс конвертации банка будет равен курсу ЦБ РФ на дату совершения операции по ежедневно котируемым ЦБ РФ валютам (34 основные валюты).\n\nПо остальным валютам – конвертация будет происходить по курсам международной платежной системы через доллар США (далее конвертация доллар США – рубли будет также по курсу Банка России)";
	
	By whatIfNoAdditionWidget = By.id("widget_what_if_no_addition");
	By whatIfNoAdditionWidgetText = By.xpath("//CollapsibleActionView_[@id='widget_what_if_no_addition']//TextView[@id='label_description']");
	String whatIfNoAdditionText = "Принятые к зачислению деньги станут доступны для использования не позже следующего календарного дня за исключением суммы, которая пойдет на погашение ранее начисленных комиссий и процентов по кредиту. Если подключена услуга «SMS-информирование», то вы получите сообщение о том, что деньги зачислены.";
	
	By whatIfForgotPINWidget = By.xpath("//TextView[@value='Утерян/забыт ПИН-код']/../../../..");
	By whatIfForgotPINWidgetText = By.xpath("//TextView[@value='Утерян/забыт ПИН-код']/../../../..//TextView[@id='label_description']");
	
	String whatIfForgotPINText = "Для восстановления забытого/ утерянного ПИН-кода необходимо обратиться в клиентский центр, на стойку продаж или позвонить в клиентскую службу. При обращении в клиентскую службу, необходимо знать код доступа.";
	By whatIfCardNotReturnedWidget = By.xpath("//TextView[@value='Банкомат не вернул карту']/../../../..");
	By whatIfCardNotReturnedWidgetText = By.xpath("//TextView[@value='Банкомат не вернул карту']/../../../..//TextView[@id='label_description']");
	String whatIfCardNotReturnedText = "Установите запрет на снятие денежных средств и обратитесь в банк, чтобы заблокировать карту. Заблокировать карту можно при обращении в клиентский центр, на стойку продаж или по звонку в клиентскую службу.\n\nДалее необходимо произвести перевыпуск карты, обратившись в клиентский центр или на стойку продаж, при себе необходимо иметь паспорт.";
		
	public void verifyCardWhatIfScreen() {
		verify.assertEquals(getTitleFromActionBar(), titleText, "Title");
		verify.assertEquals(findElement(whatIfCardLostWidgetText, driver).getText(), whatIfCardLostText, "What if screen: what if card lost text");
		verify.assertEquals(findElement(whatIfCardBrokenWidgetText, driver).getText(), whatIfCardBrokenText, "What if screen: what if card broken text");		
		verify.assertEquals(findElement(whatIfCardAbroadWidgetText, driver).getText(), whatIfCardAbroadText, "What if screen: what if card abroad text");
		verify.assertEquals(findElement(whatIfNoAdditionWidgetText, driver).getText(), whatIfNoAdditionText, "What if screen: what if no card addition text");
		verify.assertEquals(findElement(whatIfForgotPINWidgetText, driver).getText(), whatIfForgotPINText, "What if screen: what if forgot PIN text");
		verify.assertEquals(findElement(whatIfCardNotReturnedWidgetText, driver).getText(), whatIfCardNotReturnedText, "What if screen: what if card not returned text");
		verify.assertAll();		
	}
	
	public void verifyLoanWhatIfScreen() {
		verify.assertEquals(getTitleFromActionBar(), titleText, "Title");
		Log.info("actual:" + findElement(payMoreWidgetText, driver).getText());
		Log.info("expected:" + payMoreText);
		verify.assertEquals(findElement(payMoreWidgetText, driver).getText(), payMoreText, "What if screen: pay more  text");
		Log.info("actual:" + findElement(payLessWidgetText, driver).getText());
		Log.info("expected:" + payLessText);
		verify.assertEquals(findElement(payLessWidgetText, driver).getText(), payLessText, "What if screen: pay less text");
		Log.info("actual:" + findElement(payAllWidgetText, driver).getText());
		Log.info("expected:" + payAllText);
		verify.assertEquals(findElement(payAllWidgetText, driver).getText(), payAllText, "What if screen: pay all text");
		Log.info("actual:" + findElement(insuranceCaseWidgetText, driver).getText());
		Log.info("expected:" + insuranceCaseText);
		verify.assertEquals(findElement(insuranceCaseWidgetText, driver).getText(), insuranceCaseText, "What if screen: insurance case text");
		Log.info("actual:" + findElement(dismissPaymentWidgetText, driver).getText());
		Log.info("expected:" + dismissPaymentText);
		verify.assertEquals(findElement(dismissPaymentWidgetText, driver).getText(), dismissPaymentText, "What if screen: dismiss payment  text");
		Log.info("actual:" + findElement(decreasePaymentWidgetText, driver).getText());
		Log.info("expected:" + decreasePaymentText);
		verify.assertEquals(findElement(decreasePaymentWidgetText, driver).getText(), decreasePaymentText, "What if screen: decrease payment text");
		Log.info("actual:" + findElement(changePayDateWidgetText, driver).getText());
		Log.info("expected:" + changePayDateText);
		verify.assertEquals(findElement(changePayDateWidgetText, driver).getText(), changePayDateText, "What if screen: change pay date text");
		verify.assertAll();		
	}
	
	public void whatIfCardLostWidgetClick(){
		Log.info("What if screen: what if card lost widget click");
		findElement(whatIfCardLostWidget, driver).click();
	}
	
	public void whatIfCardBrokenWidgetClick(){
		Log.info("What if screen: what if card broken widget click");
		findElement(whatIfCardBrokenWidget, driver).click();
	}
	
	public void whatIfCardAbroadWidgetClick(){
		Log.info("What if screen: what if card abroad widget click");
		findElement(whatIfCardAbroadWidget, driver).click();
	}
	
	public void whatIfNoAdditionWidgetClick(){
		Log.info("What if screen: what if no addition widget click");
		findElement(whatIfNoAdditionWidget, driver).click();
	}
	
	public void whatIfForgotPINWidgetClick(){
		Log.info("What if screen: what if forgot PIN widget click");
		findElement(whatIfForgotPINWidget, driver).click();
	}
	
	public void whatIfCardNotReturnedWidgetClick(){
		Log.info("What if screen: what if card not returned widget click");
		findElement(whatIfCardNotReturnedWidget, driver).click();
	}
	
	public void payMoreWidgetClick(){
		Log.info("What if screen: Pay more widget click");
		findElement(payMoreWidget, driver).click();
	}
	
	public void payLessWidgetClick(){
		Log.info("What if screen: Pay less widget click");
		findElement(payLessWidget, driver).click();
	}
	
	public void payAllWidgetClick(){
		Log.info("What if screen: Pay all widget click");
		findElement(payAllWidget, driver).click();
	}
	
	public void insuranceCaseWidgetClick(){
		Log.info("What if screen: Insurance case widget click");
		findElement(insuranceCaseWidget, driver).click();
	}
	
	public void dismissPaymentWidgetClick(){
		Log.info("What if screen: Dismiss payment widget click");
		findElement(dismissPaymentWidget, driver).click();
	}
	
	public void decreasePaymentWidgetClick(){
		Log.info("What if screen: Decrease payment widget click");
		findElement(decreasePaymentWidget, driver).click();
	}
	
	public void changePayDateWidgetClick(){
		Log.info("What if screen: Change pay date widget click");
		findElement(changePayDateWidget, driver).click();
	}	
	
	public void payAllClick() {
		waitFor(payAll);
		Log.info("What if screen: Pay all click");
		findElement(payAll, driver).click();
		delay();		
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }	
	}
	
	public void payMoreClick() {
		waitFor(payMore);
		Log.info("What if screen: Pay more click");
		findElement(payMore, driver).click();
		delay();	
		if(isWaitPopupDisplayed()) {
        	waitForVanishWaitPopup();
        }
	}
		
	public void turnOffInsuranceClick() {
		waitFor(turnOffInsurance);
		Log.info("What if screen: turn Off Insurance click");
		findElement(turnOffInsurance, driver).click();
		delay();	
		if(isWaitPopupDisplayed()) {
			waitForVanishWaitPopup();
	    }	
	}
	
	public void changePayDateClick() {
		waitFor(changePayDate);
		Log.info("What if screen: changePayDate click");
		findElement(changePayDate, driver).click();
		delay();	
		if(isWaitPopupDisplayed()) {
			waitForVanishWaitPopup();
	    }	
	}

}
