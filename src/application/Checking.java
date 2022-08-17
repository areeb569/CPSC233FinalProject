package application;

import java.util.ArrayList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Checking extends BankAccount
	{
	private double checkingAmount = 0;
	

		
		
		
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

		
		public void deposit(double amount) {
			
				if (amount != 0)
				{
					balance = balance + amount;
				}
		
		}

		public void withdraw(double amount)
		{
			if (amount != 0)
			{
				balance = balance - amount;
				
			}
		}

		
	}
		
		
	
			
		
	
	

	

 
