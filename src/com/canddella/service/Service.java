package com.canddella.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.canddella.entity.Account;
import com.canddella.entity.Customer;

public class Service {

	public static Account createAccount() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter account number:");
		String accNum = scanner.nextLine();
		System.out.println("Enter account Type:");
		String accType = scanner.nextLine();
		System.out.println("Enter account created date:");
		String accCreateDate = scanner.nextLine();
		System.out.println("Enter account balanace:");
		double accBalance = scanner.nextDouble();

		return new Account(accNum, accType, accCreateDate, accBalance);

	}

	public static Customer createCustomer(Account account) {
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter customer code:");
		String cusCode = scanner.nextLine();
		System.out.println("Enter customer Name:");
		String cusName = scanner.nextLine();
		System.out.println("Enter customer Type:");
		String cusType = scanner.nextLine();

		ArrayList<Account> accountList = new ArrayList<Account>();
		accountList.add(account);

		Customer customer = new Customer(cusCode, cusName, cusType, accountList);

		return customer;
	}

	public static void displayAccount(ArrayList<Customer> customerList) {

		System.out.println("***********Customer-Account Details***********");
		System.out
				.println("Customer code:    " + " Customer Name:    " + " Account Type:    " + "Account Balance:    ");

		for (Customer customer : customerList) {
			if (customer != null) {
				for (Account account : customer.getAccountList()) {
					if (account != null) {

						System.out.println("     "+customer.getCustomerCode()+"     "+ "        "+customer.getCustomerName()
								+"         "+account.getAccountType()+"     "+"       "+ account.getBalance());
					}

				}

			}
		}

	}

	public static void addMultipleAccount(ArrayList<Customer> customerList) {
		Scanner scanner=new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter Customer Id:");
		String cusId=scanner.nextLine();
		for(Customer customer:customerList)
		{
			if(customer!=null)
			{
				if(cusId.equalsIgnoreCase(customer.getCustomerCode()))
				{
					customer.getAccountList().add(Service.createAccount());
				}
			}
		}
		
	}

	public static void manageAccount(ArrayList<Customer> customerList) {
		Scanner scanner=new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Enter Customer ID:");
		String cusId= scanner.nextLine();
		
		
		HashMap<String,Customer> hashMapCusIdCusObj=new HashMap<String,Customer>();
		for(Customer customer:customerList)
		{
			if(customer!=null)
			{
				hashMapCusIdCusObj.put(customer.getCustomerCode(),customer);
			}
		}
		if(hashMapCusIdCusObj.get(cusId)!=null)
		{	
			Customer cusObj=hashMapCusIdCusObj.get(cusId);
			System.out.println(cusObj.getCustomerName()+"has following accounts");
			for(Account account:cusObj.getAccountList()) {
				if(account!=null)
				{
					System.out.println(account.getAccountType()+"-"+account.getAccountNo());
				}
			}
		System.out.println("Select Account type:");	
		String choice=scanner.nextLine();
		
		System.out.println("Select option:\n1.Deposit\n2.withdrawal");
		int decision=scanner.nextInt();
		
		HashMap<String,Account> hashMapAccTypeAccObj=new HashMap<String,Account>();
		for(Account account:cusObj.getAccountList())
		{
			if(account!=null)
			{
				hashMapAccTypeAccObj.put(account.getAccountType(), account);
			}
		}
		Account accountObj=hashMapAccTypeAccObj.get(choice);
		switch(decision)
		{
		case 1:
			System.out.println("\n***Deposit_Amount***\nenter the amount");
			double depositAmount=scanner.nextDouble();
			
			accountObj.setBalance(accountObj.getBalance()+depositAmount);
			System.out.println("Depositedd successfully");
			break;
		case 2:
			System.out.println("\n***Withdraw Amount***\nenter the amount");
			double withdrawAmount=scanner.nextDouble();
			
			if(withdrawAmount<accountObj.getBalance())
			{
			accountObj.setBalance(accountObj.getBalance()-withdrawAmount);
			}
			else
			{
				System.out.println("Insufficient Balance");
			}
			break;
		default:
			break;
		}
		}
	}

	

}
