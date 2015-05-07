package ru.letoapp.tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import ru.letoapp.utilities.SmsReader;

public class SmsTest{
	public static final Logger Log = Logger.getLogger(SmsTest.class);
	
	@Test
	public void smsTest() throws IOException {
		String otp;
		otp = SmsReader.getOtpFromFile();
		Log.error(otp);
		
	}

}
