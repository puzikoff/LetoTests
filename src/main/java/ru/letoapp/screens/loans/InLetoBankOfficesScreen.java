package ru.letoapp.screens.loans;

import org.openqa.selenium.WebDriver;

import ru.letoapp.screens.AppScreenBase;

public class InLetoBankOfficesScreen extends AppScreenBase{
	
	private String titleText = "В офисах Лето Банка";
	
	public InLetoBankOfficesScreen(WebDriver driver) {
		super(driver);
	}

	public void verify() {		
		verify.assertEquals(getTitleFromActionBar(), titleText , "In leto bank offices screen: title");
		verify.assertAll();		
	}
}
