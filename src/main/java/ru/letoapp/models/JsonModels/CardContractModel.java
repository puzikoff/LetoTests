package ru.letoapp.models.JsonModels;

public class CardContractModel {
	public class Accounts {
		public AccountModel items[];
	}
	public Accounts accounts;
	public class Cards{
		public CardModel items[];	
	}
	public Cards cards;
	public String username;
	public String contractNumber;
	public String displayName;
	public String name;
	public String state;	
	public String type;	
	public String productId;
	public String openDate;
	public String signingDate;	
	public String closingDate;
	public String paymentDueDate;
	public Money depositAmount;
	public Money creditAmount;
	public Money paymentDueAmount;
	public Money paymentDueAmountRest;
	public Money overDuepaymentsAmount;
	public Money debtAmount;
	public Money interestDueAmount;
	public FeeAmount feesDueAmounts;
	public boolean hasOverdue;
	public String id;
	
	public class FeeAmount {
		public Money amount;
		public String type;
	}
}
