/*********
 * This class is the main class in this project, it can also be called parent class

 * It has 3 children classes enheriting from it.
 * -the checking
 * -the saving and
 * -the investment account
 * 
 * We declared the name and the customer's id in this class as well.
 * It also contains the instances of the 3 children classes just to keep
 * things organized.
 * therefore in a bank account instance, there is a checking, saving and an
 * investment account.
 */

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
	
	// sets the name of the customer
	public void set_Name(String name)
	{
		customerName = name;    

	}
	// returns the name of the customer
	public String get_Name()
	{
		return customerName;
	}
	
	// sets the id of the customer
	public void set_Id(String id)
	{
		customerId = id;
	}
	//returns the id of the customer
	public String get_Id()
	{
		return customerId;
	}
                                       
	                                               
	                                               
	                                               
                                                
}                                               
                                                
                                                