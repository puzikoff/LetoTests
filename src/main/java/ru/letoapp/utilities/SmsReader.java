package ru.letoapp.utilities;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import org.apache.log4j.Logger;

public class SmsReader {
	public static final Logger Log = Logger.getLogger(DashboardJsonHelper.class);
	
	public static String getOtpFromFile () throws IOException{
		String otp = null;
		File file = new File("\\\\VM-LETO-MTEST\\c$\\inetpub\\wwwroot\\idsrv\\20150506\\App_Data\\Messages\\message_log.txt");
	    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-8"));
	    while(br.readLine() != null) {
	    	otp = br.readLine();
	    	
	    }	
	    Log.info(otp);
	    br.close();	    
		return otp;
	}
}
