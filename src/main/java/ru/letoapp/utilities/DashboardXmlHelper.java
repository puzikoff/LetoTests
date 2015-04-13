package ru.letoapp.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;
import com.thoughtworks.xstream.XStream;

import ru.letoapp.models.Xml.AgreementModel;
import ru.letoapp.models.Xml.GetAgreementsInModel;
import ru.letoapp.models.Xml.GetAgreementsOutModel;

public class DashboardXmlHelper {
	public static final Logger Log = Logger.getLogger(DashboardXmlHelper.class);
	
	public static GetAgreementsOutModel getGetAgreementsOut() throws IOException{
		String dash_xml = "";
		String line = null;
		File file = new File("src/main/resources/GetAgreementsOut.xml");
	    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-8"));
	    while ((line = br.readLine()) != null) 	    	
            dash_xml = dash_xml + line;       
	    br.close();	    
	    XStream xstream = new XStream();	    
	    xstream.alias("GetAgreementsOut", GetAgreementsOutModel.class);
	    xstream.addImplicitCollection(GetAgreementsOutModel.AgreementsModel.class, "Agreement");	    
	    xstream.alias("Agreement", AgreementModel.class);		  
	    GetAgreementsOutModel getAgreementsOut = (GetAgreementsOutModel)xstream.fromXML(dash_xml);	  	
	    return getAgreementsOut;
	}
	
	public static GetAgreementsInModel getGetAgreementsIn() throws IOException{
		String dash_xml = "";
		String line = null;
		File file = new File("src/main/resources/GetAgreementsIn.xml");
	    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-16"));
	    while ((line = br.readLine()) != null) 	    	
            dash_xml = dash_xml + line;       
	    br.close();	    
	    XStream xstream = new XStream();	    
	    xstream.alias("GetAgreementsIn", GetAgreementsInModel.class);	    		  
	    GetAgreementsInModel getAgreementsIn = (GetAgreementsInModel)xstream.fromXML(dash_xml);	  	
	    return getAgreementsIn;
	}
	
	public static String getAccountNumber(String contractId) throws IOException {
		GetAgreementsOutModel card = new GetAgreementsOutModel();
		card = getGetAgreementsOut();
		for(int i = 0; card.Agreements.Agreement.get(i) != null; ++i) {
			if(card.Agreements.Agreement.get(i).AgreeId.contains(contractId)) {				
				return card.Agreements.Agreement.get(i).AccountNo;
			}
		}
		return "No such contract" + contractId;
	}
	
	public static String getFirstSum(String contractId) throws IOException {
		GetAgreementsOutModel card2 = new GetAgreementsOutModel();
		card2 = getGetAgreementsOut();
		for(int i = 0; card2.Agreements.Agreement.get(i) != null; ++i) {
			if(card2.Agreements.Agreement.get(i).AgreeId.contains(contractId)) {
				return card2.Agreements.Agreement.get(i).FirstSum;
			}
		}
		return "-1";
	}
	
	public static String getCrmClientId() throws IOException {
		GetAgreementsInModel card = new GetAgreementsInModel();
		card = getGetAgreementsIn();		
		return card.CRMClientId;
	}
	
	
	
}
