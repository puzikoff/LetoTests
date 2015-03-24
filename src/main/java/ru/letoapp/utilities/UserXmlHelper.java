package ru.letoapp.utilities;

import org.apache.log4j.Logger;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class UserXmlHelper {
	public static final Logger Log = Logger.getLogger(UserXmlHelper.class);

	public static String getFieldValueFromXml(String contractId, String fieldName) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
	
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
	
		Document document = builder.parse("src/main/resources/Dashboard_XML.xml");
		NodeList agreementsList = document.getDocumentElement().getElementsByTagName("Agreement");
		NodeList agreementsDetailsList = null;
		
		for (int i = 0; i < agreementsList.getLength(); i++) {			
			agreementsDetailsList = agreementsList.item(i).getChildNodes();	
			for (int k = 1; k < agreementsDetailsList.getLength(); k = k + 2) {				
				Node detailsField = agreementsDetailsList.item(k);				
				if((detailsField.getNodeName().contains("AgreeId"))&&(detailsField.getTextContent().contains(contractId))) {
					Log.error("Found: " + detailsField.getNodeName() + " " + detailsField.getTextContent());
					for (; k < agreementsDetailsList.getLength(); k = k + 2) {
						detailsField = agreementsDetailsList.item(k);						
						if(detailsField.getNodeName().contains(fieldName))
							return detailsField.getTextContent();					
					}
				}				
			}
		}	
		return "No such contractId in agreement";

	}
		
}	
