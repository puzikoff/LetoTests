package ru.letoapp.models;

public class DepositContractModel {
	public class Accounts {
		public AccountModel items[];
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
	public String closedDate;
	public String closingDate;
	public int depositTerm;
	public boolean transferAvailable;
	public boolean withdrawalAvailable;
	public Money minTransferAmount;
	public Money maxTransferAmount;
	public Money availableLimitAmount;
	public String id;

}
