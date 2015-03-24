package ru.letoapp.tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import ru.letoapp.utilities.UserXmlHelper;

public class utilsTest {
	public static final Logger Log = Logger.getLogger(utilsTest.class);	
    
    @Test
    public void utilstests() throws Exception {    	
        String xmlField = UserXmlHelper.getFieldValueFromXml("13493048", "MonDate");
        Log.error("Status: " + xmlField);
            	
    }

}
