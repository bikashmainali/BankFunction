package proj1fa15;
/**
 * <p>Title: Project 1- Customer class</p>
 *
 * <p>Description: Customer contains firstName, lastName, age and phoneNumber of customer.</p>
 *
 * @author Bikash Mainali
 */
public class Customer {
	// instance variables
	private String fName;
	private String lName;
	private int age;
	private String pNum;
	
	/**
     * parameterized Customer constructor --
     * gets called when an object of the Customer class is instantiated sending firstName as String type,
     * lastName as String type, customerAge as int type, customerPhoneNum as String type.
     * @param firstName as the First Name of the customer, lastName as the Last Name of the customer,
     * customerAge as the age of customer, customerPhoneNum as the Phone Number of the customer    
     * */
	public Customer(String firstName, String lastName, int customerAge, String customerPhoneNum){
		fName = firstName;
		lName = lastName;
		age = customerAge;
		pNum = customerPhoneNum;
	}
	
	/**
	 * getfName method
	 * this accessor method returns the value stored in the fName instance variable
	 * @return value stored in first name
	 */
	public String getfName() {
		return fName;
	}

	/**
	 * setfName method
	 * this mutator method changes the value stored in the fName instance variable 
	 * based upon the value of the parameter
	 * @param fName the value to store in the instance variable fName.
	 */
	public void setfName(String fName) {
		this.fName = fName;
	}
	
	/**
	 * getlName method
	 * this accessor method returns the value stored in the lName instance variable
	 * @return value stored in Last name
	 */
	public String getlName() {
		return lName;
	}

	/**
	 * setlName method
	 * this mutator method changes the value stored in the lName instance variable 
	 * based upon the value of the parameter
	 * @param lName the value to store in the instance variable lName.
	 */
	public void setlName(String lName) {
		this.lName = lName;
	}
	
	/**
	 * getAge method
	 * this accessor method returns the value stored in the Age instance variable
	 * @return value stored in age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * setAge method
	 * this mutator method changes the value stored in the setAge instance variable 
	 * based upon the value of the parameter
	 * @param age the value to store in the instance variable age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * getpNum method
	 * this accessor method returns the value stored in the pNum instance variable
	 * @return value stored in Phone Number
	 */
	public String getpNum() {
		return pNum;
	}

	/**
	 * setpNum method
	 * this mutator method changes the value stored in the setpNum instance variable 
	 * based upon the value of the parameter
	 * @param pNum the value to store in the instance variable pNum
	 */
	public void setpNum(String pNum) {
		this.pNum = pNum;
	}
	
	/**
	 * toString method
	 * creates & returns a String with value of all the instance variables
	 * @return the state of the object
	 */
	public String toString(){
		return "Name: " + fName + " " + lName + "\n" + 
				"Age: "+ age + "\n" + 
				"Phone Number: " +  pNum;
	}	
}
