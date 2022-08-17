package application;

public class Savings extends BankAccount{

	Savings(String Name, String id) {
		super(Name, id);

	}

	int compare = 0;
	private double savingsAmount = balance;

	void setSavings ()
	{
		savingsAmount = balance;
	}
	double getSaving()
	{
		return savingsAmount;
	}

	public void deposit(double toDeposit) {
		if (toDeposit != compare)
		{
			balance = balance + toDeposit;
		}
	}
	
	public void withdraw(double toWithdraw) {
		if (toWithdraw != compare)
		{
			if (balance > toWithdraw)
			{
				balance = balance - toWithdraw;

			}
			//balance = balance - toWithdraw;
		}
		
	}

}
