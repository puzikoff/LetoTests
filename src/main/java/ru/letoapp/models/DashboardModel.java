package ru.letoapp.models;

public class DashboardModel {
	public MasterAccountModel masterAccount;
	public class CardContracts{
		public CardContractModel items[];
	}
	public CardContracts cardContracts;
	public class LoanContracts{
		public LoanContractModel items[];
	}
	public LoanContracts loanContracts;
	public class DepositContracts {
		public DepositContractModel items[];
	}
	public DepositContracts depositContracts;
	public PlannedExpense plannedExpense;
	public Contacts contacts;
	public Session session;
	int importantEventCount;
	String advice;
	int unreadMessageCount;
	
	public class PlannedExpense {
		String date;
		Money amount;
	}
	
	public class Contacts {
		public String phone;
		public String alternativePhone;
		public String web;
		public String email;
	}
	
	public class Session {
		public class SessionAccount {
			public String cn;
			public String extattr1;
			public String extattr2;
			public String users[];
			public String name;
			public String id;
		}	
		public class SessionUser {
			public String userid;
			public String objectguid;
			public String cn;
			public String givenname;
			public String sn;
			public String description;
			public String changepassword;
			public String mail;
			public String lastlogon;
			public String whencreated;
			public String employeenumber;
			public String telephonenumber;
			public String manager;
			public String postaladdress;
			public String inetuserstatus;
			public String preferredlocale;
			public String logoncount;
			public String pwdlastset;
			public String badpwdcount;
			public String badpasswordtime;
			public String msisdnnumber; 
			public String impasswordresetforcereset;
			public String impasswordresetoptions;
			public String impasswordresetquestionanswer;
			public String impasswordhistory;
			public String attribute01;
			public String attribute02;
			public String attribute03;
			public String attribute04;
			public String attribute05;
		}
		public SessionAccount account;
		public SessionUser user;
	}	
}