package ru.letoapp.models.XmlModels;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.log4j.Logger;
import com.thoughtworks.xstream.XStream;


public class xmlModelTest {
	final Logger Log = Logger.getLogger(xmlModelTest.class);
	
	public static void main (String args[]) throws IOException {
		String dash_xml = "";
		String line = null;
		File file = new File("src/main/resources/Dashboard_XML.xml");
	    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-8"));
	    while ((line = br.readLine()) != null) 	    	
            dash_xml = dash_xml + line;       
	    br.close();
	    //System.out.println(dash_xml);
	    XStream xstream = new XStream();
	    xstream.alias("GetAgreementsIn", GetAgreementsInModel.class);
	    xstream.alias("GetAgreementsOut", GetAgreementsOutModel.class);
	    xstream.addImplicitCollection(GetAgreementsOutModel.AgreementsModel.class, "Agreement");	    
	    xstream.alias("Agreement", AgreementModel.class);
		
	    //GetAgreementsOutModel model = (GetAgreementsOutModel)xstream.fromXML("src/main/resources/Dashboard_XML.xml");
	    //System.out.println(model.Agreements.Agreement.AccountNo);
	  
	    GetAgreementsOutModel getAgreementsOut = (GetAgreementsOutModel)xstream.fromXML(dash_xml);	  
	    System.out.println("Acoount number:" + getAgreementsOut.Agreements.Agreement.get(0).AccountNo);
	}

}
