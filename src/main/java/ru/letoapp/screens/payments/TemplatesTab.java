package ru.letoapp.screens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import ru.letoapp.screens.AppScreenBase;
import ru.letoapp.screens.popups.EditDisplayNamePopup;
import ru.letoapp.screens.popups.TemplateContextMenu;
import ru.letoapp.screens.popups.TemplateDeleteConfirmationPopup;

public class TemplatesTab extends AppScreenBase{
	EditDisplayNamePopup editDisplayNamePopup;
	TemplateDeleteConfirmationPopup templateDeleteConfirmationPopup;
	TemplateContextMenu templateContextMenu;
	
	String templatesHintText = "Отмеченные звездочкой шаблоны будут вынесены в главное меню";
	By templatesHint = By.xpath("//TemplatesListFooterView_/ImageView/following-sibling::TextView");	
	
	public TemplatesTab(WebDriver driver) {
		super(driver);
		templateDeleteConfirmationPopup = PageFactory.initElements(driver, TemplateDeleteConfirmationPopup.class);
		editDisplayNamePopup = PageFactory.initElements(driver, EditDisplayNamePopup.class);
		templateContextMenu = PageFactory.initElements(driver, TemplateContextMenu.class);
		templateDeleteConfirmationPopup.setDriver(driver);
		editDisplayNamePopup.setDriver(driver);
		templateContextMenu.setDriver(driver);
	}
	
	public EditDisplayNamePopup getEditDisplayNamePopup() {
		return editDisplayNamePopup;
	}
	
	public TemplateDeleteConfirmationPopup getTemplateDeleteConfirmationPopup() {
		return templateDeleteConfirmationPopup;
	}
	
	public TemplateContextMenu getTemplateContextMenu() {
		return templateContextMenu;
	}
	
	public void addToFavoriteBtnClick(String templateName) {
		Log.info("Payments and transfers screen, templates tab: Add to favorite: " + templateName);
		findElement(By.xpath("//TextView[@value='" + templateName + "']/../preceding-sibling::ImageButton"), driver).click();
		delay();
	}
	
	public void payWithTemplate(String templateName) {
		Log.info("Payments and transfers screen, templates tab: Pay with template: " + templateName);
		findElement(By.xpath("//TextView[@value='" + templateName + "']/.."), driver).click();
		delay();
	}
	
	public void openTemplateContextMenu(String templateName) {
		Log.info("Payments and transfers screen, templates tab: Open context menu: " + templateName);
		findElement(By.xpath("//TextView[@value='" + templateName + "']/../following-sibling::ImageButton"), driver).click();
		delay();
	}

	public void removeFromFavoriteBtnClick(String templateName) {
		Log.info("Payments and transfers screen, templates tab: remove from favorite: " + templateName);
		findElement(By.xpath("//TextView[@value='" + templateName + "']/../preceding-sibling::ImageButton"), driver).click();
		delay();
	}

}
