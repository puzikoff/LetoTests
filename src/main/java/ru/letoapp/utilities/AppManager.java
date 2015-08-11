package ru.letoapp.utilities;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import io.selendroid.standalone.log.LogLevelEnum;
import io.selendroid.common.device.DeviceTargetPlatform;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.letoapp.screens.cards.CardScreen;
import ru.letoapp.screens.cards.CreditDetailsScreen;
import ru.letoapp.screens.cards.HowToUseCardScreen;
import ru.letoapp.screens.cards.HowWorksBlockFundsScreen;
import ru.letoapp.screens.deposits.DepositScreen;
import ru.letoapp.screens.loans.AnotherBankPaymentScreen;
import ru.letoapp.screens.loans.InLetoBankOfficesScreen;
import ru.letoapp.screens.loans.LoanContractScreen;
import ru.letoapp.screens.loans.LoanInsuranceScreen;
import ru.letoapp.screens.loans.LoanScreen;
import ru.letoapp.screens.loans.PaymentsInTerminalsSecreen;
import ru.letoapp.screens.loans.PaymentsScheduleScreen;
import ru.letoapp.screens.loans.WhatIfLoanScreen;
import ru.letoapp.screens.others.AboutBankAndAppScreen;
import ru.letoapp.screens.others.AboutBankScreen;
import ru.letoapp.screens.others.AuthScreen;
import ru.letoapp.screens.others.BankRequisitesScreen;
import ru.letoapp.screens.others.CommonTimelineScreen;
import ru.letoapp.screens.others.ContactsScreen;
import ru.letoapp.screens.others.CreditCardsListScreen;
import ru.letoapp.screens.others.DashboardScreen;
import ru.letoapp.screens.others.IncorrectLoginPasswordScreen;
import ru.letoapp.screens.others.LoansListScreen;
import ru.letoapp.screens.others.ResetSecurityCodeScreen;
import ru.letoapp.screens.others.TimelineScreen;
import ru.letoapp.screens.others.WhatIfScreen;
import ru.letoapp.screens.payments.AccountInfoScreen;
import ru.letoapp.screens.payments.AmountScreen;
import ru.letoapp.screens.payments.MenuScreen;
import ru.letoapp.screens.payments.PaymentToolScreen;
import ru.letoapp.screens.payments.StatusScreen;
import ru.letoapp.screens.registration.AccountCredentialsScreen;
import ru.letoapp.screens.registration.CardCredentialsScreen;
import ru.letoapp.screens.registration.DboScreen;
import ru.letoapp.screens.registration.ForgotAccountOrAccessCodeScreen;
import ru.letoapp.screens.registration.ForgotCardNumberOrAccessCodeScreen;
import ru.letoapp.screens.registration.ForgotPswScreen;
import ru.letoapp.screens.registration.RegistrationMethodScreen;
import ru.letoapp.screens.registration.SendEmailScreen;
import ru.letoapp.screens.registration.SetLoginScreen;
import ru.letoapp.screens.registration.SetPasswordScreen;
import ru.letoapp.screens.registration.SecurityCodeScreen;
import ru.letoapp.screens.registration.SmsCodeScreen;
import ru.letoapp.screens.services.ChangePaymentDateScreen;
import ru.letoapp.screens.services.ReducePaymentScreen;
import ru.letoapp.screens.services.VerificationCodeScreen;
import ru.letoapp.screens.wallet.WalletScreen;


public class AppManager {	
	SelendroidConfiguration serverConfig;
	SelendroidLauncher server;
	SelendroidCapabilities capabilities;
	protected static WebDriver driver = null;
	protected static WebDriverWait waitDriver = null;
	private AuthScreen authScreen;
	private DashboardScreen dashboardScreen;
	private ContactsScreen contactsScreen;
	private CommonTimelineScreen commonTimelineScreen;
	private LoansListScreen loansListScreen;
	private LoanScreen loanScreen;
	private CreditCardsListScreen creditCardsListScreen;
	private CardScreen cardScreen;
	private DepositScreen depositScreen;
	private DboScreen dboScreen;
	private SendEmailScreen sendEmailScreen;
	private RegistrationMethodScreen registrationMethodScreen;
	private CardCredentialsScreen cardCredentialsScreen;
	private AccountCredentialsScreen accountCredentialsScreen;
	private SmsCodeScreen smsCodeScreen; 
	private SetLoginScreen setLoginScreen;
	private SetPasswordScreen setPasswordScreen;
	private SecurityCodeScreen securityCodeScreen;	
	private IncorrectLoginPasswordScreen incorrectLoginPasswordScreen;
	private ForgotPswScreen forgotPswScreen;
	private ForgotAccountOrAccessCodeScreen forgotAccountOrAccessCodeScreen;
	private ForgotCardNumberOrAccessCodeScreen forgotCardNumberOrAccessCodeScreen;
	private AboutBankAndAppScreen aboutBankAndAppScreen;
	private AboutBankScreen aboutBankScreen; 
	private BankRequisitesScreen bankRequisitesScreen;
	private ResetSecurityCodeScreen resetSecurityCodeScreen;
	private WhatIfLoanScreen whatIfLoanScreen;
	private PaymentsScheduleScreen paymentsScheduleScreen;
	private InLetoBankOfficesScreen inLetoBankOfficesScreen;
	private AnotherBankPaymentScreen anotherBankPaymentScreen;
	private PaymentsInTerminalsSecreen paymentsInTerminalsSecreen;
	private LoanContractScreen loanContractScreen;
	private TimelineScreen timelineScreen;
	private LoanInsuranceScreen loanInsuranceScreen;
	private ReducePaymentScreen reducePaymentScreen;
	private VerificationCodeScreen verificationCodeScreen;
	private WalletScreen walletScreen;
	private MenuScreen menuScreen;
	private AccountInfoScreen accountInfoScreen;
	private AmountScreen amountScreen;
	private PaymentToolScreen paymentToolScreen;	
	private StatusScreen statusScreen;
	private HowToUseCardScreen howToUseCardScreen; 
	private HowWorksBlockFundsScreen howWorksBlockFundsScreen;
	private CreditDetailsScreen creditDetailsScreen;
	private WhatIfScreen whatIfScreen;
	private ChangePaymentDateScreen changePaymentDateScreen;
		
	public void init() {		
		authScreen = new AuthScreen(driver);
		dashboardScreen = new DashboardScreen(driver);
		contactsScreen = new ContactsScreen(driver);
		commonTimelineScreen = new CommonTimelineScreen(driver);
		loansListScreen = new LoansListScreen(driver);
		loanScreen = new LoanScreen(driver);
		creditCardsListScreen = new CreditCardsListScreen(driver);
		cardScreen = new CardScreen(driver);
		depositScreen = new DepositScreen(driver);
		dboScreen = new DboScreen(driver);
		sendEmailScreen = new SendEmailScreen(driver);
		registrationMethodScreen = new RegistrationMethodScreen(driver);
		cardCredentialsScreen = new CardCredentialsScreen(driver);
		accountCredentialsScreen = new AccountCredentialsScreen(driver);
		smsCodeScreen = new SmsCodeScreen(driver);
		setLoginScreen = new SetLoginScreen(driver);
		setPasswordScreen = new SetPasswordScreen(driver);
		securityCodeScreen = new SecurityCodeScreen(driver);		
		incorrectLoginPasswordScreen = new IncorrectLoginPasswordScreen(driver);
		forgotPswScreen = new ForgotPswScreen(driver);
		forgotAccountOrAccessCodeScreen = new ForgotAccountOrAccessCodeScreen(driver);
		forgotCardNumberOrAccessCodeScreen = new ForgotCardNumberOrAccessCodeScreen(driver);
		aboutBankAndAppScreen = new AboutBankAndAppScreen(driver);
		aboutBankScreen = new AboutBankScreen(driver);
		bankRequisitesScreen = new BankRequisitesScreen(driver);
		resetSecurityCodeScreen = new ResetSecurityCodeScreen(driver);
		whatIfLoanScreen = new WhatIfLoanScreen(driver);
		paymentsScheduleScreen = new PaymentsScheduleScreen(driver);
		inLetoBankOfficesScreen = new InLetoBankOfficesScreen(driver);
		anotherBankPaymentScreen = new AnotherBankPaymentScreen(driver);
		paymentsInTerminalsSecreen = new PaymentsInTerminalsSecreen(driver);
		loanContractScreen = new LoanContractScreen(driver);
		timelineScreen = new TimelineScreen(driver);
		loanInsuranceScreen = new LoanInsuranceScreen(driver);
		reducePaymentScreen = new ReducePaymentScreen(driver);
		verificationCodeScreen = new VerificationCodeScreen(driver);
		walletScreen = new WalletScreen(driver);
		menuScreen = new MenuScreen(driver);
		accountInfoScreen = new AccountInfoScreen(driver);
		amountScreen = new AmountScreen(driver);
		paymentToolScreen = new PaymentToolScreen(driver);		
		statusScreen= new StatusScreen(driver);
		howToUseCardScreen = new HowToUseCardScreen(driver); 
		howWorksBlockFundsScreen = new HowWorksBlockFundsScreen(driver);
		creditDetailsScreen = new CreditDetailsScreen(driver);
		whatIfScreen = new WhatIfScreen(driver);
		changePaymentDateScreen = new ChangePaymentDateScreen(driver);
	}
	
	/* get Screens methods section */
	
	public AuthScreen getAuthScreen() {
		return authScreen;
	}
	
	public DashboardScreen getDashboardScreen() {
		return dashboardScreen;
	}
	
	public ContactsScreen getContactsScreen() {
		return contactsScreen;
	}
	
	public CommonTimelineScreen getCommonTimelineScreen() {
		return commonTimelineScreen;
	}
	
	public LoansListScreen getLoansListScreen() {
		return loansListScreen;
	}
	
	public LoanScreen getLoanScreen() {
		return loanScreen;
	}

	public CreditCardsListScreen getCreditCardsListScreen() {
		return creditCardsListScreen;
	}
	
	public CardScreen getCardScreen() {
		return cardScreen;
	}
	
	public DepositScreen getDepositScreen() {
		return depositScreen;
	}
	
	public DboScreen getDboScreen() {
		return dboScreen;
	}
	
	public SendEmailScreen getSendEmailScreen() {
		return sendEmailScreen;
	}
	
	public RegistrationMethodScreen getRegistrationMethodScreen() {
		return registrationMethodScreen;
	}
	
	public CardCredentialsScreen getCardCredentialsScreen() {
		return cardCredentialsScreen;
	}
	
	public AccountCredentialsScreen getAccountCredentialsScreen() {
		return accountCredentialsScreen;
	}
	
	public SmsCodeScreen getSmsCodeScreen() {
		return smsCodeScreen;
	}
	
	public SetLoginScreen getSetLoginScreen() {
		return setLoginScreen;
	}
	
	public SetPasswordScreen getSetPasswordScreen() {
		return setPasswordScreen;
	}
	
	public SecurityCodeScreen getSecurityCodeScreen() {
		return securityCodeScreen;
	}	
	
	public IncorrectLoginPasswordScreen getIncorrectLoginPasswordScreen() {
		return incorrectLoginPasswordScreen;
	}
	
	public ForgotPswScreen getForgotPswScreen() {
		return forgotPswScreen;
	}
	
	public ForgotAccountOrAccessCodeScreen getForgotAccountOrAccesCodeScreen() {
		return forgotAccountOrAccessCodeScreen;
	}
	
	public ForgotCardNumberOrAccessCodeScreen getForgotCardNumberOrAccessCodeScreen() {
		return forgotCardNumberOrAccessCodeScreen;
	}
	
	public AboutBankAndAppScreen getAboutBankAndAppScreen() {
		return aboutBankAndAppScreen;
	}
	
	public AboutBankScreen getAboutBankScreen() {
		return aboutBankScreen;
	}
	
	public BankRequisitesScreen getBankRequisitesScreen() {
		return bankRequisitesScreen;
	}
	
	public ResetSecurityCodeScreen getResetSecurityCodeScreen() {
		return resetSecurityCodeScreen;
	}
	
	public WhatIfLoanScreen getWhatIfLoanScreen() {
		return whatIfLoanScreen;
	}
	
	public PaymentsScheduleScreen getPaymentsScheduleScreen() {
		return paymentsScheduleScreen;
	}
	
	public InLetoBankOfficesScreen getInLetoBankOfficesScreen() {
		return inLetoBankOfficesScreen;
	}
	
	public AnotherBankPaymentScreen getAnotherBankPaymentScreen() {
		return anotherBankPaymentScreen;
	}
	
	public PaymentsInTerminalsSecreen getPaymentsInTerminalsSecreen() {
		return paymentsInTerminalsSecreen;
	}
	
	public LoanContractScreen getLoanContractScreen() {
		return loanContractScreen;
	}
	
	public TimelineScreen getTimelineScreen() {
		return timelineScreen;
	}
	
	public LoanInsuranceScreen getLoanInsuranceScreen() {
		return loanInsuranceScreen;
	}
	
	public ReducePaymentScreen getReducePaymentScreen() {
		return reducePaymentScreen;
	}
	
	public VerificationCodeScreen getVerificationCodeScreen() {
		return verificationCodeScreen;
	}
	
	public WalletScreen getWalletScreen(){
		return walletScreen;
	}
	
	public MenuScreen getMenuScreen(){
		return menuScreen;
	}
	
	public AccountInfoScreen getAccountInfoScreen(){
		return accountInfoScreen;
	}
	
	public PaymentToolScreen getPaymentToolScreen(){
		return paymentToolScreen;
	}
	public StatusScreen getStatusScreen(){
		return statusScreen;
	}
	
	public AmountScreen getAmountScreen(){
		return amountScreen;
	}
	
	public HowWorksBlockFundsScreen getHowWorksBlockFundsScreen() {
		return howWorksBlockFundsScreen;
	}
	
	public HowToUseCardScreen getHowToUseCardScreen() {
		return howToUseCardScreen;
	}
	
	public CreditDetailsScreen getCreditDetailsScreen() {
		return creditDetailsScreen;
	}
	
	public WhatIfScreen getWhatIfScreen() {
		return whatIfScreen;
	}
	
	public ChangePaymentDateScreen getChangePaymentDateScreen() {
		return changePaymentDateScreen;
	}
	
	/* Starting Selendroid */
	
	public void startServer(String appPath, boolean forceReinstall, boolean noClearData) 
	{
		serverConfig = new SelendroidConfiguration();
	    serverConfig.addSupportedApp(appPath);
	    serverConfig.setPort(4444);	    
	    serverConfig.setEmulatorPort(44444);	    
	    serverConfig.setDeviceLog(true);
	    serverConfig.setDeviceScreenshot(true);
	    serverConfig.setSelendroidServerPort(38080);
	    serverConfig.setForceReinstall(forceReinstall);
	    serverConfig.setNoClearData(noClearData);
	    serverConfig.setShouldKeepAdbAlive(true);
	    serverConfig.setPrintHelp(true);
	    serverConfig.setLogLevel(LogLevelEnum.INFO);
	    server = new SelendroidLauncher(serverConfig);
	    server.launchSelendroid();	            
	}

	public void initDriver(String appUnderTestId, String serverUrl, Boolean emulator, String appActivity) throws Exception 
	{
	    capabilities = new SelendroidCapabilities();        
	    capabilities.setAut(appUnderTestId);      
	    capabilities.setLaunchActivity(appActivity);   
	    if(emulator == true) {
	    	capabilities.setEmulator(true);
	    	capabilities.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
	    }
	    driver = new SelendroidDriver(new URL(serverUrl), capabilities);
	    waitDriver = new WebDriverWait(driver, 90);	 
	} 
	    
	public void initDriver(String appUnderTestId, String serverUrl, Boolean emulator) throws Exception
	{
	    capabilities = new SelendroidCapabilities();	    
	    capabilities.setAut(appUnderTestId);
	    if(emulator == true) {
	    	capabilities.setEmulator(true);
	    	capabilities.setPlatformVersion(DeviceTargetPlatform.ANDROID19);
	    }
	    driver = new SelendroidDriver(new URL(serverUrl), capabilities); 
	    waitDriver = new WebDriverWait(driver, 90);
	}
	
	public static void takeScreenshot()
    {       
       File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
       try {
    	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    	   String date = format.format(new Date());
           FileUtils.copyFile(scrFile, new File("Screenshots" + File.separator +  "screenshot-" +  date +".png"));
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebDriverWait getWaitDriver() {
		return waitDriver;
	}
	
	public SelendroidLauncher getServer() {
		return this.server;
	}
	
	public void stopServer() {
		if(server != null) {
			server.stopSelendroid();
		}
	}
	
	public void stopDriver() {
		if(driver != null) {
			driver.quit();
		}	
	}

	
}
