package application;                            
 public class BankAccount {                     
	double balance;                                
	Investment investAccount ;                     
	Savings savingsAccount ;                        
	Checking checkingAccount ;               
	private String customerName;    
	private String customerId;               
	                                               
	BankAccount(String name, String id)            
	 {                                             
		 customerName = name;                         
		 customerId = id;                             
	 }  
	
	public void set_Name(String name)
	{
		customerName = name;    

	}
	public String get_Name()
	{
		return customerName;
	}
	
	public void set_Id(String id)
	{
		customerId = id;
	}
	public String get_Id()
	{
		return customerId;
	}
	                                               
	//public abstract void deposit(double amount); 
	                                               
	                                               
	//public abstract void withdraw(double amount);
	                                               
	                                               
	                                               
	                                               
                                                
}                                               
                                                
                                                