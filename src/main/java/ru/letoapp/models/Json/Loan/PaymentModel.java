package ru.letoapp.models.Json.Loan;

import javax.validation.constraints.NotNull;

import ru.letoapp.models.Json.Money;

public class PaymentModel {
	@NotNull
	public String links[];
	public String term;
	public String state;
	@NotNull
	public Money debtDueAmount;
	@NotNull
	public Money debtPayedAmount;
	public Money payedAmount;
	@NotNull
	public Money dueAmount;
	public Money interestDueAmount;
	@NotNull
	public Money restAmount;
	public Money interestPayedAmount;
	public FeeAmount feesDueAmounts[];
	public FeeAmount feesPayedAmounts[];
	public Money advanceAmount;
	public Money debtPaymentsAmount;
	public String id;
	
	public class FeeAmount {
		public Money amount;
		public String name;
		public String type;
	}
	

}
