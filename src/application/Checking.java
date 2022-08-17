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
		//customerName = Name;
		//customerId = id;
		
	}
		
		void setCheckingAmount ()
		{
			checkingAmount = balance;
		}
		double getCheckingAmount()
		{
			return checkingAmount;
		}

		
		public void deposit(double toDeposit) {
			
				if (toDeposit != compare)
				{
					balance = balance + toDeposit;
				}
		
		}

		public void withdraw(double toWithdraw)
		{
			if (toWithdraw != compare)
			{
				//balance = balance - toWithdraw;
				if (balance > toWithdraw)
				{
					balance = balance - toWithdraw;

				}
				
			}
		}

		
	}
		
		
	
			
		
	
	

	

 
