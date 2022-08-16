package application;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class BankFunctions {

	String[] accountInfo = {"",""};
	BankAccount customer = new BankAccount("", "");
	
	Savings saveMoney = new Savings("", "");
	Checking checkingMoney = new Checking("", "");
	Investment investmentMoney = new Investment("", "");
	

	String[] output = {"checking", "saving","investment"};
	
	double moneyToCompute[] = {0,0,0}; 
	double withdrawToCompute[]= {0,0,0};
	int check = 0;
	Stage applicationStage;
	
	@FXML
	void enterAccountInfo(ActionEvent event) {
		
		
		Scene mainScene = applicationStage.getScene();
    	VBox allRows = new VBox();
    	ArrayList<TextField> moneyTextFields = new ArrayList<TextField>();
    		HBox checkingRow1 = new HBox();
    		HBox checkingRow2 = new HBox();
        	Label checkingLabel1 = new Label("Enter the customer's full name");
        	Label checkingLabel2 = new Label("Enter the customer's account number");

        	TextField checkingTextfield1 = new TextField();
        	TextField checkingTextfield2 = new TextField();

        	
        	moneyTextFields.add(checkingTextfield1);
        	moneyTextFields.add(checkingTextfield2);

        	checkingRow1.getChildren().addAll(checkingLabel1,checkingTextfield1);
        	checkingRow1.getChildren().addAll(checkingLabel2,checkingTextfield2);

        	allRows.getChildren().add(checkingRow1);
        	allRows.getChildren().add(checkingRow2);

    	Button doneButton = new Button("Done");
        doneButton.setOnAction(doneEvent-> loadtheAccountEntered(mainScene,moneyTextFields,check));
        allRows.getChildren().add(doneButton);
    	
    	
    	Scene valueEntered = new Scene(allRows);
    	applicationStage.setScene(valueEntered);
		
	
	
	}
	void loadtheAccountEntered(Scene mainScene, ArrayList<TextField> checkingTextfield, int check)
    {
    	for(int i = 0; i <2; i++)
    	{
    		accountInfo[i] = checkingTextfield.get(i).getText();
    	}
    	
    	customer.customerName = accountInfo[0];
    	customer.customerId = accountInfo[1];
    	if(isValidAccountNumber(customer.customerId)) {
    		System.out.println("The customer's ID: " + customer.customerId);
    	}
    	else
    		System.out.println(customer.customerId + " Is invalid ID, the ID should be a 6 digits integer number");
    		
    	if(isValidName(customer.customerName)) {
    		System.out.println("The customer's name: " +customer.customerName);
    	}
    	else
        	System.out.println(customer.customerName + " This is Inavalid Name. your name should be in form of (firstname lastname)");
    	
    	

    		
	    		
		applicationStage.setScene(mainScene);
    }
	
	
	
	// this function loggs the user input entered in the changing scene text field for
	//the deposit and withdraw function.
	// money to compute is an array of double declared at the top of the program to
	//store the 3 values from the changing scene 
	  void loadtheAmountEntered(Scene mainScene, ArrayList<TextField> checkingTextfield, int check)
	    {
	    	for(int i = 0; i <3; i ++)
	    	{
	    		if(check == 0)
	    		{
		    		moneyToCompute[i] = Double.parseDouble(checkingTextfield.get(i).getText());

	    		}
	    		if(check == 1)
	    		{
	    			withdrawToCompute[i] = Double.parseDouble(checkingTextfield.get(i).getText());

	    		}

	    	}
	  
	    	computeResult();
	    	applicationStage.setScene(mainScene);
	    }
	// this function creates a new scene. it is used also for the function withdraw
	  // just to prevent the code duplication
	@FXML
	void depositMoney(ActionEvent event) {
		
		Scene mainScene = applicationStage.getScene();
    	int threeValuesToEnter = 3;
    	VBox allRows = new VBox();
    	ArrayList<TextField> moneyTextFields = new ArrayList<TextField>();
    	for(int i = 0; i <threeValuesToEnter; i++)
    	{
    		HBox checkingRow = new HBox();
    		
        	Label checkingLabel = new Label("Enter the deposit amount for the " + output[i] + " account");
        	TextField checkingTextfield = new TextField();
        	
        	moneyTextFields.add(checkingTextfield);
        	checkingRow.getChildren().addAll(checkingLabel,checkingTextfield);

        	allRows.getChildren().add(checkingRow);
    	}
    	Button doneButton = new Button("Done");
        doneButton.setOnAction(doneEvent-> loadtheAmountEntered(mainScene,moneyTextFields,check));
        allRows.getChildren().add(doneButton);
    	
    	
    	Scene valueEntered = new Scene(allRows);
    	applicationStage.setScene(valueEntered);

		
		
		

	}
	
	@FXML
	void withdrawMoney(ActionEvent event) {
		check = 1;
		depositMoney(event);

	}
	
	@FXML
	void showAccountInformation(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox rows = new VBox();
		Label customerName = new Label("Customer name: " + customer.customerName);
		Label customerID = new Label("Customer ID: " + customer.customerId);
		Label checkingAmount = new Label("Checking account amount: " + 
				Double.toString(checkingMoney.balance));
		Label savingAmount = new Label("Saving account amount: " + Double.toString(saveMoney.balance));
		Label investmentAmount = new Label("Investment account amount: " + 
				Double.toString(investmentMoney.balance));
		rows.getChildren().addAll(customerName,customerID,checkingAmount,savingAmount,investmentAmount);
		Button doneButton = new Button("Done");
        doneButton.setOnAction(doneEvent-> applicationStage.setScene(mainScene));
        rows.getChildren().add(doneButton);
		
		Scene showAccountInfoPage = new Scene(rows,400,400);
		applicationStage.setScene(showAccountInfoPage);
	}

	
	
	 void computeResult() {
	  
		 // this operation was done prevent memory leaks
		 customer.savingsAccount = saveMoney;
			customer.checkingAccount = checkingMoney;
			customer.investAccount = investmentMoney;
	    	
	    	if (check == 0)
	    	{
	    		// it was prefered to store the value entered in the chaging 
	    		//scene in a double first before because arrays are passed by reference
	    		// this prevents possible privacy leaks
	    		double toCompute1 = moneyToCompute[0];
	    		double toCompute2 = moneyToCompute[1];
	    		double toCompute3 = moneyToCompute[2];
	    		customer.checkingAccount.deposit(toCompute1);
	    		customer.checkingAccount.setCheckingAmount();
	    		customer.savingsAccount.deposit(toCompute2);
	    		customer.savingsAccount.setSavings();
	    		customer.investAccount.deposit(toCompute3);
	    		customer.investAccount.setInvestment();
	    		
	    		System.out.println("CHECKING AMOUNT ENTERED:  "+customer.checkingAccount.getCheckingAmount());
		    	System.out.println("SAVING AMOUNT ENTERED:  "+customer.savingsAccount.getSaving());
		    	System.out.println("INVESTMENT AMOUNT ENTERED:  "+customer.investAccount.getInvestment());
		    
	    	}
	    	if(check == 1)
	    	{
	    		// it was prefered to store the value entered in the chaging 
	    		//scene in a double first before because arrays are passed by reference
	    		// this prevents possible privacy leaks
	    		double toWithdraw1 = withdrawToCompute[0];
	    		double toWithdraw2 = withdrawToCompute[1];
	    		double toWithdraw3 = withdrawToCompute[2];

	    		customer.checkingAccount.withdraw(toWithdraw1);
	    		customer.checkingAccount.setCheckingAmount();
	    		customer.savingsAccount.withdraw(toWithdraw2);
	    		customer.savingsAccount.setSavings();
	    		customer.investAccount.withdraw(toWithdraw3);
	    		customer.investAccount.setInvestment();
	    		
	    		System.out.println("CHECKING AMOUNT ENTERED:  "+customer.checkingAccount.getCheckingAmount());
		    	System.out.println("SAVING AMOUNT ENTERED:  "+customer.savingsAccount.getSaving());
		    	System.out.println("INVESTMENT AMOUNT ENTERED:  "+customer.investAccount.getInvestment());
		    
	    	}
	    	
	    }
	 /*
	  * Function Name: isValidAccountNumber
	  * Arguments: String accountNumber( this is the customer ID)
	  * 
	  * this method validates the bank account number
	  * the bank account number is valid if it is 6 digits integer number.
	  * the first digit can not be 0
	  */
	 boolean isValidAccountNumber(String accountNumber) {
		 boolean valid = true;
		 
		 try 
			{ 
				Integer.parseInt(customer.customerId);  
				
			}  
			catch (NumberFormatException e)  
			{ 
				valid = false;
				//System.out.println(customer.customerId + " is not a valid account number"); 
			} 
		 
		 if(valid && customer.customerId.length() != 6)
			 valid = false;
			 
		 
		 return valid;
	 }
	 
	 /* Function Name: isValidName()
	  * arguments: String customerName
	  * 
	  * This function validates customer's name
	  * A name is valid if it is only contains alphabetics characters,
	  * if it has a first name and a last name
	  */
	 boolean isValidName(String customerName) {
		boolean validName = true;
		int numberOfSpace =0;
		
		for(int i=0; i<=customer.customerName.length()-1; i++) {
			if(customer.customerName.charAt(i)== ' ') {
				numberOfSpace++;
			}
		}
		
		if(!Pattern.matches("[a-zA-Z]+", customerName))
			validName = false;
		
		else if(customerName == null)
			validName = false;
		
		else if(customerName.length() < 3)
			validName = false;
		
		//else if(numberOfSpace != 1)
			 //validName = false;
		
		
		return validName;
	 }
	 
	 /*
	  * Validate Deposit and withdraw amount
	  */
	 
	 boolean isValidAmount(double amount) {
		 boolean validAmount = true;
		 
		 if(!(amount > 0))
			 validAmount = false;
		 //String str = String.valueOf(amount);
		// else if(!)
		 
		 return validAmount;
	 }
	 
	
}