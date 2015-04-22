package ru.letoapp.screens.deposits;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.screens.AppScreenBase;
import ru.letoapp.screens.others.EditDisplayNameBlock;

public class DepositScreen extends AppScreenBase{
	public static final Logger Log = Logger.getLogger(DepositScreen.class);
	private DepositTab depositTab;
	private DepositManagementTab depositManagementTab;
	private EditDisplayNameBlock editDisplayName;
	String actionBarTitle = "Вклад";	
	By depositTabBtn = By.xpath("//TextView[@value='ВКЛАД']");	
	By infoTabBtn = By.xpath("//TextView[@value='ИНФОРМАЦИЯ']");	
	
	public DepositScreen(WebDriver driver) {
		super(driver);
		depositTab = PageFactory.initElements(driver,DepositTab.class);
		depositManagementTab = PageFactory.initElements(driver, DepositManagementTab.class);
		editDisplayName = PageFactory.initElements(driver, EditDisplayNameBlock.class);
		depositTab.setDriver(driver);
		depositManagementTab.setDriver(driver);
		editDisplayName.setDriver(driver);
	}
	
	public DepositTab getDepositTab(){
		return depositTab;
	}
	
	public DepositManagementTab getDepositManagementTab(){
		return depositManagementTab;
	}
	
	public EditDisplayNameBlock getEditDisplayName() {
		return editDisplayName;
	}

	public void depositInfoTabClick() {
		Log.info("Deposit Screen: Managementd tab click");
		driver.findElement(infoTabBtn).click();
		delay();		
	}
	
	public void depositTabClick() {
		Log.info("Deposit Screen: Deposit tab click");
		driver.findElement(depositTabBtn).click();
		delay();
	}
}
