package ru.letoapp.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import org.apache.log4j.Logger;

import ru.letoapp.models.JsonModels.DashboardModel;

import com.google.gson.Gson;

public class DashboardJsonHelper {
	public static final Logger Log = Logger.getLogger(UserJsonHelper.class);
	
	public static DashboardModel getDashboard () throws IOException{
		String dash_json = null;
		File file = new File("src/main/resources/Dashboard_sb_JSON.txt");
	    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-8"));	    
	    dash_json = br.readLine();        
	    br.close();	
	    DashboardModel dashModel = new Gson().fromJson(dash_json, DashboardModel.class);
		return dashModel;
	}	

    public static String getCardSum(String cardName) throws IOException {    	
		DashboardModel dashModel = new DashboardModel();
		dashModel = getDashboard();
		for(int i = 0; dashModel.cardContracts.items[i] != null; i++) 
			if(dashModel.cardContracts.items[i].displayName.contains(cardName)) 				
				return String.valueOf(dashModel.cardContracts.items[i].cards.items[0].totalBalance);		
		return "No card with such name in JSON";
	}
}
