package ru.letoapp.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import ru.letoapp.models.DashboardModel;

import com.google.gson.Gson;

public class ModelTest {
	public static void main(String args[]) throws IOException {
		final Logger Log = Logger.getLogger(ModelTest.class);
		
		File file = new File("src/main/resources/Dashboard_sb_JSON.txt");
        BufferedReader br = new BufferedReader (
            new InputStreamReader(
                new FileInputStream( file ), "UTF-8"
            )
        );
        
        String json = null;
        
        json = br.readLine();        
        br.close();	
        
       DashboardModel model = new Gson().fromJson(json, DashboardModel.class);
        Log.error(model.loanContracts.items[1].displayName);
        Log.error(model.loanContracts.items[1].contractNumber);
        Log.error(model.cardContracts.items[1].displayName);
        Log.error(model.cardContracts.items[1].contractNumber);
        Log.error(model.depositContracts.items[1].displayName);
        Log.error(model.depositContracts.items[1].contractNumber);
        Log.error(model.masterAccount.accounts.items[0].contractId);
        Log.error(model.masterAccount.accounts.items[0].name);
        Log.error(model.session.account.name);
        Log.error(model.session.user.inetuserstatus);
        Log.error(model.contacts.web);        
	}

}
