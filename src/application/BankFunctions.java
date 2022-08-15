package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankFunctions {
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
	
	@FXML
	void depositMoney(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
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
	}
	
	@FXML
	void withdrawMoney(ActionEvent event) {
		Scene mainScene = applicationStage.getScene();
		
		VBox rows = new VBox();
		
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