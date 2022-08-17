package application;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Checking extends BankAccount
	{
	private double checkingAmount = 0;
	int compare = 0;
	
		Checking(String Name, String id) {
		super(Name, id);
		
	}
	
		// sets the balance in the checking
		void setCheckingAmount ()
		{
			checkingAmount = balance;
		}
		// returns the amount in the checking account
		double getCheckingAmount()
		{
			return checkingAmount;
		}

		// deposits the money in the account
		public void deposit(double toDeposit) {
			
				if (toDeposit != compare)
				{
					toDeposit = Math.abs(toDeposit);
					balance = balance + toDeposit;
				}	
		}

		// withdraw from the account
		public void withdraw(double toWithdraw)
		{
			if (toWithdraw != compare)
			{
				if (balance > toWithdraw)
				{
					toWithdraw = Math.abs(toWithdraw);
					balance = balance - toWithdraw;

				}
			}
		}

		
	}
		
		
	
			
		
	
	

	

 
