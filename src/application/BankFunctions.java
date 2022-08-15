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
	
	String[] output = {"cheking", "saving","investment"};
	double moneyToCompute[] = {0,0,0}; 
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
	
	  void loadtheAmountEntered(Scene mainScene, ArrayList<TextField> checkingTextfield)
	    {
	    	for(int i = 0; i <3; i ++)
	    	{
	    		moneyToCompute[i] = Double.parseDouble(checkingTextfield.get(i).getText());

	    	}
	    	for(int i = 0; i <3; i ++)
	    	{
	    		System.out.println("the amount Entered for " +  output[i] + " is:  "+moneyToCompute[i]);
	    		//moneyToCompute[i] = Double.parseDouble(checkingTextfield.get(i).getText());

	    	}
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
        doneButton.setOnAction(doneEvent-> loadtheAmountEntered(mainScene,moneyTextFields));
        allRows.getChildren().add(doneButton);
    	
    	
    	Scene valueEntered = new Scene(allRows);
    	applicationStage.setScene(valueEntered);

		
		
		
		/*Scene mainScene = applicationStage.getScene();
		double me = 234;
		
		VBox rows = new VBox();
		
		HBox deposit = new HBox();
		Label enterDeposit = new Label("Enter the amount of money that you would "
				+ "like to deposit from your account: ");
		TextField depositNum = new TextField();
		deposit.getChildren().addAll(enterDeposit, depositNum);
		
		rows.getChildren().addAll(deposit);
		
		Scene enterDepositScene = new Scene(rows,600,150);
		applicationStage.setScene(enterDepositScene);
		
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
		rows.getChildren().add(doneButton);
	*/
	}
	
	@FXML
	void withdrawMoney(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox rows = new VBox();
		double ruth = 0;
		double me = 9;
		
		HBox withdraw = new HBox();
		Label enterWithdraw = new Label("Enter the amount of money that you would "
				+ "like to deposit into your account: ");
		TextField withdrawNum = new TextField();
		withdraw.getChildren().addAll(enterWithdraw, withdrawNum);
		
		rows.getChildren().addAll(withdraw);
		
		Scene enterWithdrawScene = new Scene(rows,600,150);
		applicationStage.setScene(enterWithdrawScene);
		
		Button doneButton = new Button("Done");
		doneButton.setOnAction(doneEvent -> applicationStage.setScene(mainScene));
		rows.getChildren().add(doneButton);
	}
	
	@FXML
	void showAccountInformation(ActionEvent event) {
		
	}
}