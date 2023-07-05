package com.canddella.entity;

public class Account {
	private String accountNo;
	private String accountType;
	private String accountCreateDate;
	private double balance;
	
	
	public Account() {
		
	}
	public Account(String accountNo, String accountType, String accountCreateDate, double accBalance) {
		super();
		this.accountNo = accountNo;
		this.accountType = accountType;
		this.accountCreateDate = accountCreateDate;
		this.balance = accBalance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountCreateDate() {
		return accountCreateDate;
	}
	public void setAccountCreateDate(String accountCreateDate) {
		this.accountCreateDate = accountCreateDate;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	

	

}
