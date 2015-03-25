package ru.letoapp.utilities;

import org.apache.log4j.Logger;
import java.io.*;
import org.json.*;

public class UserJsonHelper {
	public static final Logger Log = Logger.getLogger(UserJsonHelper.class);
	
	 public static String getDashboardFieldValue(String fileName, String cardName, String fieldName) throws IOException, FileNotFoundException, JSONException {	
		String fieldValue = null;
		File file = new File(fileName);
        BufferedReader br = new BufferedReader (
            new InputStreamReader(
                new FileInputStream( file ), "UTF-8"
            )
        );
        String userJSON = null;
        userJSON = br.readLine();
        br.close();	
        JSONObject obj = new JSONObject(userJSON);        
        JSONArray cards = obj.getJSONObject("cardContracts").getJSONArray("items");
        String dn = null;
        for(int i = 0; i < cards.length(); ++i) {
        	dn = cards.getJSONObject(i).getString("displayName");        	
        	if(dn.contains(cardName)) {        		
        		JSONArray cardDetails = cards.getJSONObject(i).getJSONObject("cards").getJSONArray("items");
        		for(int k = 0; k < cardDetails.length(); ++k) 
        			fieldValue = cardDetails.getJSONObject(k).getString(fieldName);        					
        		break;
        	}
        }
        return fieldValue;
	 }
	 
	 public static String getContractFieldValue(String fileName, String cardName, String fieldName) throws IOException, FileNotFoundException, JSONException {	
			String fieldValue = null;
			File file = new File(fileName);
	        BufferedReader br = new BufferedReader (
	            new InputStreamReader(
	                new FileInputStream( file ), "UTF-8"
	            )
	        );
	        String userJSON = null;
	        userJSON = br.readLine();
	        br.close();	
	        JSONObject obj = new JSONObject(userJSON);        
	        JSONArray cards = obj.getJSONObject("cardContracts").getJSONArray("items");
	        String dn = null;
	        for(int i = 0; i < cards.length(); ++i) {
	        	dn = cards.getJSONObject(i).getString("displayName");        	
	        	if(dn.contains(cardName)) {        		
	        		JSONArray cardDetails = cards.getJSONObject(i).getJSONObject("cards").getJSONArray("items");
	        		for(int k = 0; k < cardDetails.length(); ++k) 
	        			fieldValue = cardDetails.getJSONObject(k).getString(fieldName);        					
	        		break;
	        	}
	        }
	        return fieldValue;
		 }


}
