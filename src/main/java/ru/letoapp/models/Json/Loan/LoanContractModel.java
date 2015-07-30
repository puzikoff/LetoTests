package ru.letoapp.models.Json.Loan;

import ru.letoapp.models.Json.Money;

public class LoanContractModel {
	public class PaymentsSchedule {
		public Payments payments;
		public String contractId;
		public String startDate;
		public String endDate;
		public Money originalDebtAmoint;
		public String id;
	};	
	
	public class Payments {
		public PaymentModel items[];
	}
	
	public PaymentsSchedule paymentsSchedule;
	public Money availableLimitAmount;
	public String contractNumber;	
	public String displayName;
	public String name;
	public String state;
	public String type;
	public String productId;
	public String openedDate;
	public Money depositAmount;
	public boolean hasOverdue;
	public String productUrl;
	public String signingDate;
	public Money incomingDueAmount;
	public boolean limitClosed;
	public String closingDate;
	public String accountNo;
	public Money debtAmount;
	public Money limitAmount;
	public Money originalDebtAmount;
	public Money creditAmount;
	public Money payedAmount;
	public Money debtDueAmount;
	public Money interestDueAmount;
	public Money graceAmount;
	public Money graceAmountRest;
	public double interestRate;
	public double originalInterestRate;
	public String statementDate;
	public String paymentTerms;
	public String productType;
	public String limitClosingDate;
	public String id;
	
	
	
	public String paymentDueDate;	
	public String closedDate;
	public Money paymentDueAmount;
	public Money paymentDueAmountRest;
	

}