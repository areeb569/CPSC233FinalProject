package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class BankFunctions {

	String[] accountInfo = {"",""}; // to store the account info strored in the texfield
	BankAccount customer = new BankAccount("", "");  // ounce customer's bank instance
	
	double me = 0;
	// this 3 were created and initialised so that it doesn't have to be initialized 
	// everytime the compute function is called because it creates a memory leak
	Savings saveMoney = new Savings("", ""); 
	Checking checkingMoney = new Checking("", "");
	Investment investmentMoney = new Investment("", "");
	

	String[] output = {"checking", "saving","investment"};
	
	double moneyToCompute[] = {0,0,0}; 
	double withdrawToCompute[]= {0,0,0};
	int check = 0;
	Stage applicationStage;
	
	/**
	 * This method is utilized when you click the 'Enter account information' button. It
	 * contains labels and textfields just like when you open the application and click that
	 * button. It just sets the textfields and labels and adds them onto a new scene, where
	 * the user can enter in their input. 
	 * 
	 */
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
	
	/**
	 * This method just saves account info the user has entered and saves them in variables for
	 * future use.
	 */
	void loadtheAccountEntered(Scene mainScene, ArrayList<TextField> checkingTextfield, int check)
    {
    	for(int i = 0; i <2; i++)
    	{
    		accountInfo[i] = checkingTextfield.get(i).getText();
    	}
    	 customer.set_Name(accountInfo[0]);
    	 customer.set_Id(accountInfo[1]);
    	if(isValidAccountNumber(customer.get_Id())) {
    		System.out.println("The customer's ID: " + customer.get_Id());
    	}
    	else
    		System.out.println(customer.get_Id() + " Is invalid ID, the ID should be a 6 digits integer number");
    		
    	if(isValidName(customer.get_Name())) {
    		System.out.println("The customer's name: " +customer.get_Name());
    	}
    	else
        	System.out.println(customer.get_Name() + " This is Inavalid Name. your name should be in form of (firstname lastname)");
    	
    	

    		
	    		
		applicationStage.setScene(mainScene);
    }
	
	
	
	private void set_Name(String string) {
		// TODO Auto-generated method stub
		
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
	  /**
	   *This function is utilized when you click the deposit button. It has labels and textfields
	   *where it asks you to enter a deposit amount for 3 different accounts. It adds the labels and
	   *textfields to a new scene where the user can enter information for depositing money for
	   *each of the 3 bank accounts.
	   */
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
	
	/**This function does the same thing as the deposit money function, except it withdraws
	 * money.
	 */
	@FXML
	void withdrawMoney(ActionEvent event) {
		check = 1;
		depositMoney(event);

	}
	
	/**
	 *This method is utilized when you click the 'Show account information' button. It has a bunch
	 *of labels and adds them to a new scene. When you click on this button, it shows all of the
	 *information that the user has entered for their customer info and the amount of money
	 *that they have in each of their 3 bank accounts.
	 */
	@FXML
	void showAccountInformation(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox rows = new VBox();
		Label customerName = new Label();
		if(isValidName(customer.get_Name())) {
			customerName.setText("Customer name: " + customer.get_Name());
		}
		else {
			customerName.setText(customer.get_Name()+ " Invalid customer name");
		}
		
		Label customerID = new Label();
		if(isValidAccountNumber(customer.get_Id())) {
			customerID.setText("Customer ID: " + customer.get_Id());
		}
		else {
			customerID.setText(customer.get_Id()+ " Invalid customer ID");
		}
		//Label customerID = new Label("Customer ID: " + customer.get_Id());
		
		Label checkingAmount = new Label("Checking account amount: " + 
				Double.toString(checkingMoney.getCheckingAmount()));
		
		Label savingAmount = new Label("Saving account amount: " + Double.toString(saveMoney.getSaving()));
		Label investmentAmount = new Label("Investment account amount: " + 
				Double.toString(investmentMoney.getInvestment()));
		rows.getChildren().addAll(customerName,customerID,checkingAmount,savingAmount,investmentAmount);
		Button doneButton = new Button("Done");
        doneButton.setOnAction(doneEvent-> applicationStage.setScene(mainScene));
        rows.getChildren().add(doneButton);
		
		Scene showAccountInfoPage = new Scene(rows,400,400);
		applicationStage.setScene(showAccountInfoPage);
	}

	
	
	 private boolean isValidId(String get_Id) {
		// TODO Auto-generated method stub
		return false;
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
				Integer.parseInt(customer.get_Id());  
				
			}  
			catch (NumberFormatException e)  
			{ 
				valid = false; 
			} 
		 
		 if(customer.get_Id().length() != 6)
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
		int numberOfWords =0;
		char c[] = new char[customerName.length()];
		
		for(int i =0; i< customerName.length();i++) {
			c[i] = customerName.charAt(i);
			
			 if( ((i>0)&&(c[i]!=' ')&&(c[i-1]==' ')) || ((c[0]!=' ')&&(i==0)) )  
                 numberOfWords++;  
			
				
		}
		
		 if(customerName == null)
			validName = false;
		
		else if(customerName.length() < 3)
			validName = false;
		
		else if(numberOfWords != 2)
			 validName = false;
		
		 String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}"
		 		+ "1234567890";
		 
		 for (int i=0; i < customerName.length() ; i++)
	        {
	            char ch = customerName.charAt(i);
	            if(specialCharactersString.contains(Character.toString(ch))) {
	            	validName = false;
	                break;
	            }    
	            
	        }
		
		return validName;
	 }
	 
	 /*
	  * Validate Deposit and withdraw amount
	  */
	 
	 boolean isValidAmount(double amount) {
		 boolean validAmount = true;
		
		 if(!(amount > 0) || amount > customer.checkingAccount.getCheckingAmount() )
			 validAmount = false;
		 		 
		 return validAmount;
	 }
	 
	 /*
	  * Validate withdraw amount
	  */
	 boolean isValidWithdraw(double toWithdraw) {
		 boolean validWith = true;
		 
		 if( !(toWithdraw > 0))
			 validWith = false;
		 
		 return validWith;
	 }
	 
	 
	
}