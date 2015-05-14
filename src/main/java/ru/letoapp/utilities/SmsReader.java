package ru.letoapp.utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class SmsReader {
	public static final Logger Log = Logger.getLogger(DashboardJsonHelper.class);
	
	public static String getOtpFromFile () throws IOException{
		String otp = null;
		String otp2 = null;
		//File file = new File("\\\\VM-LETO-MTEST\\Leto_sms\\sms.txt");	
		File file = new File("\\\\VM-LETO-MTEST\\c$\\LOGS\\AM\\message_log.txt");
	    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-8"));
	    while((otp = br.readLine()) != null) {	    	
	    	otp2 = otp;	    
	    }	    
	    br.close();		    
	    Pattern p = Pattern.compile("[0-9]{6,6}");
	    Matcher m = p.matcher(otp2);	    
	    m.find();	   
	    otp2 = m.group(0);     
		return otp2;
	}
}
