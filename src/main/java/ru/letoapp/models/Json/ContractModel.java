package ru.letoapp.models.Json;

public class ContractModel {
	String username;
	String contractNumber;
	String displayName;
	String name;
	String state;
	String type;
	String productId;
	String openedDate;
	String signingDate;
	String closingDate;
	String closedDate;
	String paymentDueDate;
	Money creditAmount;
	Money paymentDueAmount;
	Money	paymentDueAmountRest;
	boolean hasOverdue;
	FeeAmount[] feeAmounts;
	String graceDate;
	Money graceAmount;
	Money graceAmountRest;
	Money payedAmount;
	String paymentDueEventId;
	String productUrl;
	Money debtDueAmount;
	OverdueInfo overdueInfo;
	Money availableLimitAmount;
	Money depositAmount;
	Money interestDueAmount;
	Money limitAmount;
	String id;	
	
	public class FeeAmount {
		Money amount;
		String type;
	}
	
	public class OverdueInfo {
		int overduePaymentsCount;
		Money overduePaymentsAmount;
		Money overdueAmount;
		Money debtOverdueAmount;
		Money interestOverdueAmount;
	}

}
