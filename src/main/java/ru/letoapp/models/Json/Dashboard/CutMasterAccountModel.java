package ru.letoapp.models.Json.Dashboard;

import ru.letoapp.models.Json.Money;

public class CutMasterAccountModel {
	public class Accounts {
		public CutAccountModel items[];
	}
	public Accounts accounts;
	public String username;
	public String contractNumber;
	public String displayName;
	public String name;
	public String state;
	public String type;
	public String productId;
	public String openedDate;
	public String signingDate;
	public String paymentDueDate;
	public Money availableLimitAmount;
	public String id;

}
