package proj1fa15;

/**
 * <p>Title: Project 1--Application class</p>
 *
 * <p>Description: Project1App implements all the other class to make the 
 * 				   bank application work properly.I handle all the Graphic user parts of 
 * 				   the program to make it user friendly. It display choices to user and 
 *				   perform the request as the user choice. </p>
 *
 * @author Bikash Mainali
 */
import javax.swing.*;

public class Project1App 
{

	// content for button 
	private static String[] choices = {"Display All Accounts", "Display Selected Accounts", "Balance Inquiry", "Deposit", "Withdrawal", "Exit"};
	private static String[] choicesToSearch = {"Balance Greater Than", "Balance less Than"};

	//to reduce code redundancy i make another method so i can call it from time to time.
	/**
	 * this methos show status of the the requested information.
	 * @param str it is the message to display on the top of the pane.
	 * @param status is the content to display on the body.
	 */
	private static void jShow(String str, String status)
	{
		JOptionPane.showMessageDialog(
				null,
				str,
				status,
				JOptionPane.DEFAULT_OPTION);
	}
	
	/**
	 *  this static method accepts str as a parameter and display that message in scrollPane.
	 *  @param str is the text message to display the text on scroll pane.
	 */
	public static void showText(String str) 
	{
		JTextArea text1 = new JTextArea(20,30);
		// creating scroll object by sending size of panel

		text1.setText(str);
		JScrollPane scroll1 = new JScrollPane(text1);
		JOptionPane.showMessageDialog(
				null,
				scroll1,
				"Match on our records",
				JOptionPane.DEFAULT_OPTION);
	}

	//main method starts
	public static void main(String[] args) throws Exception 
	{
		Bank mybank = new Bank();
		// to make sure that at first it should go inside while method.
		int choiceOnMainMenu = 1;       			

		// check for user choice
		while (choiceOnMainMenu !=5) 
		{
		 choiceOnMainMenu = JOptionPane.showOptionDialog(null,
					"Enter your choice on the main application".toUpperCase(), 			//text displayed in the window
					"Bikash Mainali's Bank application".toUpperCase(),          //text displayed in the window's title bar
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE,
					null,
					choices,                			//text to be displayed in each button
					choices[0]); 
			switch (choiceOnMainMenu) 
			{
			case 0:
				showText(mybank.toString());
				break;

			case 1:
				int choiceSearchOption = JOptionPane.showOptionDialog(null,
						"Enter your choice to search", 		//text displayed in the window
						"Bikash Mainali's Bank application",//text displayed in the window's title bar
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null,		
						choicesToSearch,                	//text to be displayed in each button
						choicesToSearch[0]);				//choose choicesToSearch[0] as a default choice 
				// get user input from showInputDialog Box.
				// Convert the user input from string to Double.
				// store it in the variable name amount.
				double amount = Double.parseDouble(JOptionPane.showInputDialog("Enter amount to complete your search"));

				showText(mybank.findString(choiceSearchOption, amount));

				break;
			case 2:
				// get user input from showInputDialog Box.
				// Convert the user input from string to int.
				// store it in the variable name balInq.
				int balInq = Integer.parseInt(JOptionPane.showInputDialog("Please enter account number to view balance"));

				jShow(mybank.balanceInquiry(balInq), "Balance inquiry Status");
				break;
			case 3:
				int accNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter account number to deposit balance"));
				double deposit = Double.parseDouble(JOptionPane.showInputDialog("Please enter amount of money you want to deposit"));
				jShow(mybank.deposit(accNum,deposit), "Deposit Status");
				break;

			case 4:
				int acccNum = Integer.parseInt(JOptionPane.showInputDialog("Please enter account number to withdraw balance"));
				double withdraw = Double.parseDouble(JOptionPane.showInputDialog("Please enter amount of money you want to withdraw"));

				jShow(mybank.withdrawal(acccNum,withdraw), "withdraw Status");
				break;
			default:
				JOptionPane.showMessageDialog(null, "You may close this window now.\nThank you for using Bikash Mainali's Bank");
				break;
			}
		}

	}
}
