package com.canddella.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.canddella.entity.Account;
import com.canddella.entity.Customer;
import com.canddella.service.Service;

public class Utility {

	public static void main(String[] args) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		Scanner scanner = new Scanner(System.in);

		boolean decision = false;

		do {
			System.out.println("******Welcome to Bank******");
			System.out.println("1.Create Account\n2.Manage Account\n3.Display Account\n4.Exit");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter Customer Id:");
				scanner.nextLine();
				String cusId = scanner.nextLine();
				
				HashMap<String,Customer> hashMapCusIdObj = new HashMap<String,Customer>();
				
				for (Customer customer : customerList) {
					if (customer != null) {
						hashMapCusIdObj.put(customer.getCustomerCode(), customer);
					}
				}
				if (hashMapCusIdObj.get(cusId) != null) {

					Customer customerObj = hashMapCusIdObj.get(cusId);

					Account accountObj = Service.createAccount();

					customerObj.getAccountList().add(accountObj);

				} else {
					System.out.println("Account not found\nCreate new Account");
					Account account = Service.createAccount();
					customerList.add(Service.createCustomer(account));
					System.out.println("Account created Successfully...");
				}
				break;
			
			case 3:
				Service.displayAccount(customerList);
				break;
			case 2:
				Service.manageAccount(customerList);

				break;
			case 4:
				break;
			default:
				break;
			}
			System.out.println("Do you want to continue?\n1.Yes    2No");
			int ans = scanner.nextInt();
			if (ans == 1) {
				decision = true;
			} else if (ans == 2) {
				decision = false;
			} else
				System.out.println("Invalid Input:");

		} while (decision);

	}
}