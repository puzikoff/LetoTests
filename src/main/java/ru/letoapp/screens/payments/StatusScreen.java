package ru.letoapp.screens.payments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class StatusScreen extends AppScreenBase{
	By status = By.xpath("//TextView[@id = 'label_status']");
	By progressBar = By.xpath("//ProgressBar[@id = 'progress_loading']");
	String successStatusText = "Успешно";
	String failedStatusText = "Отклонена";
	By editTemplateNameFiled = By.xpath("//EditText[@id = 'edit_template_name']");
	By templateHint = By.xpath("//EditText[@id = 'edit_template_name']//preceding-sibling::TextView");
	String templateHintText = "Вы можете создать шаблон перевода, чтобы в дальнейшем платить быстрее.";
	By createTemplateBtn = By.xpath("//Button[@id='button_create_template']");
	

	public StatusScreen(WebDriver driver) {
		super(driver);
	}

	public void editTemplateName(String templateName) {
		Log.info("Payment status screen: edit template name, new name: " + templateName);
		findElement(editTemplateNameFiled, driver).clear();
		findElement(editTemplateNameFiled, driver).sendKeys(templateName);
		delay();
	}
	
	public void createTemplaetBtnClick() {
		Log.info("Payment status screen: create template btn click");
		clickAndWaitSpinerToVanish(createTemplateBtn);		
	}
	
	public void waitForVanishUpdateStatus() {		
		waitFor(progressBar);
		Log.info("Payment status screen: create template btn click");
		waitForVanish(progressBar);	
	}
}
