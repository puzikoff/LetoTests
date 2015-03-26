package ru.letoapp.tests;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.models.JsonModels.DashboardModel;
import ru.letoapp.utilities.DashboardJsonHelper;


public class ModelTest {
	final Logger Log = Logger.getLogger(ModelTest.class);
	
	@Test
	public void test() throws IOException {		
		//String s = DashboardJsonHelper.getCardSum("Картаff");
		//Log.error("Card sum: " + s);
		DashboardModel mod = DashboardJsonHelper.getDashboard();
		Log.error("lengrth " + mod.cardContracts.items.length);
	}

}
