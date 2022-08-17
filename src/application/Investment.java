package application;

public class Investment extends BankAccount {
	
	
	private double investmentAmount = 0;
	int compare = 0;

	Investment(String name, String id) {
		super(name, id);
		
	}
	
	void setInvestment ()
	{
		investmentAmount = balance;
	}
	public double getInvestment()
	{
		return investmentAmount;
	}

	// deposits the money in the account

	public void deposit(double toDeposit) {
		if (toDeposit != 0)
		{
			toDeposit = Math.abs(toDeposit);
			balance = balance + toDeposit;
		}
	}

	// withdraw from the account
	public void withdraw(double toWithdraw) {
		if (toWithdraw != 0)
		{
			if (balance > toWithdraw)
			{
				toWithdraw = Math.abs(toWithdraw);
				balance = balance - toWithdraw;

			}
		}
		
	}

}
