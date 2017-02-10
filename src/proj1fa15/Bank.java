package proj1fa15;

import java.util.*;
import java.io.*;
/**
 * <p>Title: Project 1- Bank class</p>
 *
 * <p>Description: Bank contains an array to store upto 10 accounts.
 * 				   An instance variable to store number of account in the bank.
 * 				   Reads data from an external file and pass that data to initialize customer and account object.
 * 				   perform findString method and BalanceInquiry operation on itself.
 * 				   It also contains withdrawal and deposit method perform transaction.</p>
 *
 * @author Bikash Mainali
 */

public class Bank 
{ 
	// instance variables
	private int numberOfAccount;
	private Account[] accounts;
	private Account account;

	/**
	 * Default Bank constructor -- gets called when an object of the Bank class is instantiated with no parameter.
	 * -- It reads data from "bankdata.txt" and store value. It creates customer and account object. 
	 * And place that account object in accounts array. 
	 * @throws Exception
	 */
	public Bank() throws Exception
	{
		accounts = new Account[10];
		numberOfAccount = 0;
		//scanner class
		Scanner fileScan = new Scanner(new File("bankdata.txt"));
		while (fileScan.hasNext() && (numberOfAccount<10)) 
		{
			String firstName = fileScan.next(); 
			String lastName = fileScan.next(); 
			int age = fileScan.nextInt();
			String phone = fileScan.next();
			double balance = fileScan.nextDouble();
			int accountNo = fileScan.nextInt();

			//create customer from the data get from the file bankdata.txt
			Customer customer = new Customer(firstName, lastName, age, phone);

			account = new Account(customer, balance, accountNo);
			accounts[numberOfAccount] = account;
			numberOfAccount++;
		}
		//scanner close
		fileScan.close();
		
	}

	
	
	/**
	 * deposit method -- it call deposit method in account class if account number passed is found in the array.
	 * @param accountNumber is the account number to make the deposit to.
	 * @param depositAmount is the amount that one want to put in.
	 * @return String as the status of deposit.
	 */
	public String deposit(int accountNumber, double depositAmount)
	{
		String status="";
		boolean depositstatus = false;
		int i = 0;
		while (i<numberOfAccount && depositstatus == false)
		{
			if(accounts[i].getcAccount() == accountNumber)
			{
				depositstatus = accounts[i].deposit(depositAmount);
			
			}
			if (depositstatus == true){
				status = "You deposit is complete.\n"+
						"Your new balance is " + accounts[i].getcBalance()  ;
			}
			i++;
		}
		
		if (depositstatus == false){
			status = "You deposit is not complete.\n"+
					"Try again by re-entering correct account Number.";
		}

		return status;		
	}

	/**
	 * withdrawal method -- it call withdrawal method in account class if account number passed is found in the array.
	 * @param accountNumber is the account number to make the withdrawal from.
	 * @param withdrawalAmount is the amount that one want to take out. 
	 * @return String as the status of withdraw.
	 */
	public String withdrawal(int accountNumber, double withdrawalAmount)
	{
		String status="";
		boolean withdraw = false;
		int i = 0;
		while ( i<numberOfAccount && (withdraw == false))
		{
			if(accounts[i].getcAccount() == accountNumber)
			{
				withdraw = accounts[i].withdrawal(withdrawalAmount);
				
				if (withdraw == true)
				{
					status = "You withdrawal is complete.\n"+
							"Your new Balance is $" + accounts[i].getcBalance();			
				}
			}
			i++;
		}
		
		if (withdraw == false){
			status = "You deposit is not complete.\n"+
					"Try again by re-entering correct account Number.\n" +
					"Or withdrawal amount less than your balance.";
		}
		return status;	
	}

	/**
	 * balanceInquiry method -- it displays balance in the account if the accountNumber match
	 * @param accountNumber as the account number of the account.
	 * @return String as the status of balance.
	 */
	public String balanceInquiry(int accountNumber)
	{
		String balance="";
		boolean found = true;
		int i = 0;
		while (i<numberOfAccount && (found))
		{
			if(accounts[i].getcAccount() == accountNumber)
			{
				//				balance = accNum + ": " + accounts[i].getcBalance();
				balance = "Your balance is: " + accounts[i].getcBalance();
				found = false;
			}
			i++;
		}

		if(found)
			balance = balance + "Account that you passed: " + accountNumber + " is not found";
		return balance;
	}

	/**
	 * return all the search result that match the criteria.
	 * @param option check if it less than or greater than search option.
	 * @param value check value according to option parameter.
	 * @return detail of the account that match the given criteria.
	 */
	public String findString(int option, double value)
	{
		String str= "";
		if (option == 0)
		{
			for (int i=0; i<numberOfAccount; i++)
			{
				if (accounts[i].getcBalance() > value)
					str = str + accounts[i].toString();
			}
		}
		if (option == 1)
		{
			for (int i=0; i<numberOfAccount; i++)
			{
				if (accounts[i].getcBalance() < value)
					str = str + accounts[i].toString();
			}
		}
		return str;
	}

	/**
	 * toString method -- this method returns the state of the bank object
	 * @return a reference to a String object that contains the all information of the account.
	 */
	public String toString()
	{
		String str= "";
		for (int i = 0; i < numberOfAccount ; i++)
			str = str + accounts[i].toString();
		return str;
	} 
	
}
