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


	public void deposit(double toDeposit) {
		if (toDeposit != 0)
		{
			balance = balance + toDeposit;
		}
	}


	public void withdraw(double toWithdraw) {
		if (toWithdraw != 0)
		{
			if (balance > toWithdraw)
			{
				balance = balance - toWithdraw;

			}
		//	balance = balance - toWithdraw;
		}
		
	}

}
