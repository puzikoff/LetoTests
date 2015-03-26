package ru.letoapp.tests;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.utilities.DashboardJsonHelper;
import ru.letoapp.utilities.DashboardXmlHelper;

public class xmlModelTest {
	final Logger Log = Logger.getLogger(xmlModelTest.class);
	
	@Test
	
	public void xmltest () throws IOException {
		String s = DashboardXmlHelper.getAccountNumber("13493048");
		String d = DashboardXmlHelper.getFirstSum("13493048"); 
	    System.out.println("Acoount number: " + s);
	    System.out.println("Firstsum: " + d);
	    String c = DashboardXmlHelper.getCrmClientId();
	    System.out.println("CRMClientId: " + c);
	}

}
