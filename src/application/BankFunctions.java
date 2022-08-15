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
	
	//BankAccount customer = new BankAccount("", "");
	//customer.savingsAccount = new Savings(nameEntered, accountEntered);
	//customer.checkingAccount= new Checking(nameEntered, accountEntered);
	//customer.investAccount= new Investment(nameEntered, accountEntered);

	
	
	BankAccount customer = new BankAccount("Ruth", "45678");
	
	Savings saveMoney = new Savings("","");
	Checking checkingMoney = new Checking("","");
	Investment investmentMoney = new Investment("","");
	
	//customer.savingsAccount = new Savings("Ruth", "45678");
	// initialise();



	String[] output = {"cheking", "saving","investment"};
	double moneyToCompute[] = {0,0,0}; 
	double withdrawToCompute[]= {0,0,0};
	int check = 0;
	Stage applicationStage;
	
	@FXML
	void enterAccountInfo(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox rows = new VBox();
		
		HBox accountID = new HBox();
		Label enterAccountID = new Label("Enter account ID Number: ");
		TextField IDNum = new TextField();
		accountID.getChildren().addAll(enterAccountID, IDNum);
		
		rows.getChildren().addAll(accountID);
		
		Scene enterAccountInfoScene = new Scene(rows,400,150);
		applicationStage.setScene(enterAccountInfoScene);
		
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
		rows.getChildren().add(doneButton);
	}
	
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
	    	for(int i = 0; i <3; i ++)
	    	{
	    		//System.out.println("the amount Entered for " +  output[i] + " is:  "+moneyToCompute[i]);
	    		//moneyToCompute[i] = Double.parseDouble(checkingTextfield.get(i).getText());


	    		if(check == 0)
	    		{
		    		System.out.println("the amount Entered for deposit " +  output[i] + " is:  "+moneyToCompute[i]);

		    		System.out.println("check value is: "+ check);
		    		System.out.println("the value in withdraw is "+ withdrawToCompute[i]);
	    		}
	    		if(check == 1)
	    		{
		    		System.out.println("the amount Entered for withdraw " +  output[i] + " is:  "+withdrawToCompute[i]);
		    		System.out.println("check value is: "+ check);
		    		System.out.println("the value in deposit is "+ moneyToCompute[i]);
	    		}
	    		
	    	}
	    	
	    	computeResult();
	    	applicationStage.setScene(mainScene);
	    }
	
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
		
	}

	
	
	 void computeResult() {
		 double me = 0;
	    //	String nameEntered = "Ruth";
	    	//String accountEntered = "345678900";
	    	
	    	
	    // trying to save it in the class
	    	//BankAccount customer = new BankAccount(nameEntered, accountEntered);
	    	//customer.savingsAccount = new Savings(nameEntered, accountEntered);
	    	//customer.checkingAccount= new Checking(nameEntered, accountEntered);
	    	//customer.investAccount= new Investment(nameEntered, accountEntered);
	    	
	    	// if the choice entered is 1 we need to deposit the money
		 customer.savingsAccount = saveMoney;
			customer.checkingAccount = checkingMoney;
			customer.investAccount = investmentMoney;
	    	
	    	if (check == 0)
	    	{
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
	
}