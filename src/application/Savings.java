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

	// deposits the money in the account

	public void deposit(double toDeposit) {
		if (toDeposit != compare)
		{
			toDeposit = Math.abs(toDeposit);
			balance = balance + toDeposit;
		}
	}
	// withdraw from the account
	public void withdraw(double toWithdraw) {
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
