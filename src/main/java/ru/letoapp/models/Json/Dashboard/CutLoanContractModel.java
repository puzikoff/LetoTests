package ru.letoapp.models.Json.Dashboard;

import ru.letoapp.models.Json.Money;

public class CutLoanContractModel {
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
	public double originalInterestRate;
	public String productId;
	public String openedDate;
	public String signingDate;
	public String paymentDueDate;
	public String closingDate;
	public String closedDate;
	public Money paymentDueAmount;
	public Money paymentDueAmountRest;
	public Money availableLimitAmount;
	public Money depositAmount;
	public Money originalDebtAmount;
	public boolean hasOverdue;
	public boolean limitClosed;
	public String id;

}
