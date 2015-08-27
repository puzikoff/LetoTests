package ru.letoapp.utilities;

import gnu.trove.set.hash.THashSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;

import ru.letoapp.models.Json.Dashboard.DashboardModel;
import ru.letoapp.models.Json.Loan.LoanContractModel;

import com.google.common.collect.ObjectArrays;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

public class JsonHelper {
	public static final Logger Log = Logger.getLogger(JsonHelper.class);
	
	public static DashboardModel getDashboard () throws IOException{
		String dash_json = null;
		File file = new File("src/main/resources/Dashboard.json");
	    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-8"));	    
	    dash_json = br.readLine();        
	    br.close();	
	    DashboardModel dashModel = new Gson().fromJson(dash_json, DashboardModel.class);
		return dashModel;
	}
	
	public static LoanContractModel getLoanContract () throws IOException{
		String contract_json = null;
		File file = new File("src/main/resources/LoanContract.json");
	    BufferedReader br = new BufferedReader (new InputStreamReader(new FileInputStream( file ), "UTF-8"));	    
	    contract_json = br.readLine();        
	    br.close();	
	    LoanContractModel contrModel = new Gson().fromJson(contract_json, LoanContractModel.class);
		return contrModel;
	}	

    public static String getCardSum(String cardName) throws IOException {    	
		DashboardModel dashModel = new DashboardModel();
		dashModel = getDashboard();
		for(int i = 0; dashModel.cardContracts.items[i] != null; ++i) 
			if(dashModel.cardContracts.items[i].displayName.contains(cardName)) 				
				return String.valueOf(dashModel.cardContracts.items[i].cards.items[0].totalBalance);		
		return "No card with such name in JSON " + cardName;
	}
    
    public static class VaidateDeserializer<T> implements JsonDeserializer<T> {
        private Set<String> fields = null; 
        private Set<String> notNullFields = null; 

        @SuppressWarnings("rawtypes")
		public void init(Type type) {
            Class cls = (Class) type;
            Field[] fieldsArray = ObjectArrays.concat(cls.getDeclaredFields(), cls.getFields(), Field.class); 
            fields = new THashSet<String>(fieldsArray.length);
            Log.info("1::   " + fields.toString());
            notNullFields = new THashSet<String>(fieldsArray.length);
            Log.info("2::   " + notNullFields.toString());
            for(Field field: fieldsArray) {
                String name = field.getName().toLowerCase(); 
                Annotation[] annotations = field.getAnnotations();

                boolean isNotNull = false;
                for(Annotation annotation: annotations) {
                    if(annotation instanceof NotNull) { 
                        isNotNull = true;
                    } else if(annotation instanceof SerializedName) {
                        name = ((SerializedName) annotation).value().toLowerCase(); 
                    }
                }
                fields.add(name);
                if(isNotNull) {
                    notNullFields.add(name);
                }
            }
        }

        public T deserialize(JsonElement json, Type type,
                             JsonDeserializationContext context)
                throws JsonParseException {
            if(fields == null) {
                init(type);
            }
            Set<Map.Entry<String, JsonElement>> entries = json.getAsJsonObject().entrySet();
            Set<String> keys = new THashSet<String>(entries.size());
            for (Map.Entry<String, JsonElement> entry : entries) {
                if(!entry.getValue().isJsonNull()) { 
                    keys.add(entry.getKey().toLowerCase());
                }
            }
            if (!fields.containsAll(keys)) { 
                throw new JsonParseException("Parse error! The json has keys that isn't found in Java object:" + type);
            }
            if (!keys.containsAll(notNullFields)) { 
                throw new JsonParseException("Parse error! The NotNull fields is absent in json for object:" + type + notNullFields);
            }
            return new Gson().fromJson(json, type); 
        }
    }
}
