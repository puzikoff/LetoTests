package ru.letoapp.screens.others;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.letoapp.screens.ScreenBase;

public class EditDisplayNameBlock extends ScreenBase{
	public static final Logger Log = Logger.getLogger(EditDisplayNameBlock.class);
	By editNameBtn = By.id("button_edit");
	By displayName = By.id("label_user_defined_name");
	By labelContractState = By.id("label_contract_state");
	By popupTitle = By.id("sdl__title");
	By editDisplayNamePopupNextBtn = By.id("sdl__positive_button");
	By editDisplayNamePopupCancelBtn = By.id("sdl__negative_button");
	By displayNameField = By.xpath("//EditText");

	public EditDisplayNameBlock(WebDriver driver) {
		super(driver);
	}
	
	public void editDisplayNameBtnClick() {
		waitFor(editNameBtn);
		Log.info("Edit display name block: Click edit button");
		driver.findElement(editNameBtn).click();
		delay();
	}
	
	public String getDisplayName() {
		Log.info("Edit display name block: Get display name");
		Log.info("Edit display name block: Display name: " + driver.findElement(displayName).getText());
		return driver.findElement(displayName).getText();
	}
	
	public String getLabelContractState() {
		List<WebElement> labelContractStates = driver.findElements(labelContractState);
		if(!labelContractStates.isEmpty()) {
			Log.info("Edit display name block: Get label contract state");
			Log.info("Edit display name block: Label contract state: " + driver.findElement(labelContractState).getText());
			return driver.findElement(labelContractState).getText();
		}
		Log.info("Edit display name block: No label contract state");
		return "No label contract state";
	}
	
	public void editDisplayName(String newDisplayName) {
		Log.info("Edit display name block: Edit display name");
		Log.info("Edit display name block: Old name: " + driver.findElement(displayNameField).getText());
		Log.info("Edit display name block: New name: " + newDisplayName);
		driver.findElement(displayNameField).clear();
		driver.findElement(displayNameField).sendKeys(newDisplayName);	
	}
	
	public void editDisplayNamePopupNextBtnClick() {
		Log.info("Edit display name block: Click next");
		driver.findElement(editDisplayNamePopupNextBtn).click();
		delay();
	}
	
	public void editDisplayNamePopupCancelBtnClick() {
		Log.info("Edit display name block: Click cancel");
		driver.findElement(editDisplayNamePopupCancelBtn).click();
		delay();
	}

}
