package ru.letoapp.screens.loans;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.screens.AppScreenBase;
import ru.letoapp.screens.others.EditDisplayNameBlock;

public class LoanScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(LoanScreen.class);
	private PaymentTab paymentTab;
	private LoanInfoTab loanInfoTab;
	private LoanManagementTab loanManagementTab;
	private EditDisplayNameBlock editDisplayName;
	String actionBarTitle = "Кредит";	
	By paymentTabBtn = By.xpath("//TextView[@value='ПЛАТЁЖ']");
	By infoTabBtn = By.xpath("//TextView[@value='ИНФОРМАЦИЯ']");
	By managementTabBtn = By.xpath("//TextView[@value='УПРАВЛЕНИЕ']");	

	public LoanScreen(WebDriver driver) {
		super(driver);	
		paymentTab = PageFactory.initElements(driver, PaymentTab.class);
		loanInfoTab = PageFactory.initElements(driver, LoanInfoTab.class);
		loanManagementTab = PageFactory.initElements(driver, LoanManagementTab.class);
		editDisplayName = PageFactory.initElements(driver, EditDisplayNameBlock.class);
		paymentTab.setDriver(driver);
		loanInfoTab.setDriver(driver);
		loanManagementTab.setDriver(driver);
		editDisplayName.setDriver(driver);
	}
	
	public PaymentTab getPaymentTab(){
		return paymentTab;
	}
	
	public LoanInfoTab getLoanInfoTab() {
		return loanInfoTab;
	}
	
	public LoanManagementTab getLoanManagementTab() {
		return loanManagementTab;
	}
	
	public EditDisplayNameBlock getEditDisplayName() {
		return editDisplayName;
	}
	
	public void infoTabClick() {
		Log.info("Loan Screen: Information tab click");
		driver.findElement(infoTabBtn).click();
		delay();
	}

	public void managementTabClick() {
		Log.info("Loan Screen: Managementd tab click");
		driver.findElement(managementTabBtn).click();
		delay();		
	}
	
	public void paymentTabClick() {
		Log.info("Loan Screen: Payment tab click");
		driver.findElement(paymentTabBtn).click();
		delay();
	}

}