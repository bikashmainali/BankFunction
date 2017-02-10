package proj1fa15;
/**
 * <p>Title: Project 1- Account class</p>
 *
 * <p>Description: Account class store all the information of the customer.
 * 				   This class store a customer reference.
 * 				   Balance in that account and Account number.
 * 				   It also contains withdrawal and deposit method perform transaction.</p>
 *
 * @author Bikash Mainali
 */

public class Account 
{
	//instance variable

	private Customer cReference;
	private double cBalance;
	private int cAccount;
	
	/**
	 * parameterized constructor 
	 * @param reference take the reference of the customer	
	 * @param balance balance of specific account
	 * @param accountNo account number of customer
	 */
	public Account(Customer reference, double balance, int accountNo)
	{
		cReference = reference;
		cBalance = balance;
		cAccount = accountNo;
	}

	/**
	 * returns the reference of a customer
	 * @return the reference of a customer
	 */
	public Customer getcReference() 
	{
		return cReference;
	}
	
	
	/**
	 * set the value passed as a customer reference
	 * @param cReference set the value passed as a customer reference
	 */
	public void setcReference(Customer cReference) 
	{
		this.cReference = cReference;
	}
	
	
	/**
	 * return the balance of the account
	 * @return cBalance the balance of the account
	 */
	public double getcBalance() 
	{
		return cBalance;
	}

	/**
	 * set the balance of the customer  
	 * @param cBalance set the balance of the customer
	 */
	public void setcBalance(double cBalance) 
	{
		this.cBalance = cBalance;
	}

	/**
	 * returns the account number of the customer 
	 * @return cAccount returns the account number of the customer 
	 */
	public int getcAccount() 
	{
		return cAccount;
	}

	/**
	 * set the account of the customer as cAccount.
	 * @param cAccount set the current account number to the account number passed.
	 */
	public void setcAccount(int cAccount) 
	{
		this.cAccount = cAccount;
	}
	
	/**
	 * this method withdrawal check if the current balance of the account is greater or less than the amount of withdrawal.
	 * if current balance is less than the amount of withdrawal then it return false. Else withdraw complete and return true. 
	 * @param withdrawalAmmount check if it is less the current balance of the account.
	 * @return status of the withdrawal. if the withdrawal is successful than it returns true else it will return false.
	 */
	public boolean withdrawal(double withdrawalAmmount)
	{
		boolean status = false; 
		if (cBalance > withdrawalAmmount){
			cBalance = cBalance - withdrawalAmmount;
			status = true; 
		}
			return status;
	
	}
	
	/**
	 * deposit the amount passed as the parameter.
	 * @param depAmount add to the current balance of the account.
	 * @return true.
	 */
	public boolean deposit(double depAmount)
	{
		cBalance = cBalance + depAmount;	
		return true;
	}
	
	/**
	 * toString method
	 * creates & returns a String with value of all the instance variables
	 * @return the state of the object
	 */
	public String toString()
	{
		return cReference + "\n" + 
			   "Balance: "+ cBalance + "\n" + 
			   "Account: " +  cAccount + "\n\n";
	}

	
}
