package ru.letoapp.tests;
import com.google.gson.*;
import org.apache.log4j.Logger;
import ru.letoapp.models.Json.Loan.PaymentModel;
import ru.letoapp.utilities.JsonHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestGson {
	public static final Logger Log = Logger.getLogger(TestGson.class);

    public static void main(String [ ] args) throws IOException    
    {
    	String payment_json = null;
		File file = new File("src/main/resources/payment.json");
	    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-8"));	    
	    payment_json = br.readLine();        
	    br.close();	  
		
      Gson gson = new GsonBuilder()
                .registerTypeAdapter(PaymentModel.class, new JsonHelper.VaidateDeserializer<PaymentModel>())
                .create();
        PaymentModel paymentModel = gson.fromJson(payment_json, PaymentModel.class); 
        Log.info("3::   " + paymentModel.debtDueAmount.amount);
    }
    

  
}