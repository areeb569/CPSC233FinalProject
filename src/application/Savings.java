package application;
//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
public class Savings extends BankAccount{

	Savings(String Name, String id) {
		super(Name, id);
	//	customerName = Name;
		//customerId = id;
	}

	private double savingsAmount = balance;

	/*void deposit(int amount)
	{
		if (amount != 0)
		{
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	*/
	void setSavings ()
	{
		savingsAmount = balance;
	}
	double getSaving()
	{
		return savingsAmount;
	}

	public void deposit(double amount) {
		if (amount != 0)
		{
			balance = balance + amount;
		}
	}
	
	public void withdraw(double amount) {
		if (amount != 0)
		{
			balance = balance - amount;
		}
		
	}

}
