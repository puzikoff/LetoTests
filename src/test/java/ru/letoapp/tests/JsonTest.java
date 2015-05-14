package ru.letoapp.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.models.Json.Dashboard.DashboardModel;
import ru.letoapp.utilities.JsonHelper;



public class JsonTest {
	public static final Logger Log = Logger.getLogger(JsonTest.class);
	
	@Test
	public void jsonTests() throws IOException {
		DashboardModel dm = JsonHelper.getDashboard();
		Log.info("Master account contract number: " + dm.masterAccount.contractNumber);
		Log.info("Loan name: " + dm.loanContracts.items[0].name);
		Log.info("Loan contract number: " + dm.loanContracts.items[0].contractNumber);
		
        
        
	}

}