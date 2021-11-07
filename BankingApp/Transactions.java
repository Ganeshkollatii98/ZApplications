package BankingApp;

import java.util.HashMap;

public class Transactions {
	//int transCount =1;
	static HashMap<Integer,User> Customer = new HashMap<>();
	static HashMap<Integer,TransHistory> transHistory = new HashMap<>();
	static String[] pswdHistory = new String[3];
	static HashMap<Integer,String[]> pswdH = new HashMap<Integer,String[]>();
	public void NewAccount(User user) {
		
		for(Integer x:Customer.keySet())
		{
			if(x == user.Cust_id)
			{
				System.out.println("User is Already Exits");
				return;
			}
		}
		Customer.put(user.Cust_id,user);
		//pswdHistory[2] = user.Password;
		//transCount++;
		//System.out.println("New Account was created Successfully");
	}
	
	public void CashDeposit(int AccountNum,String Password,int amount) {
		
		for(User x :Customer.values())
		{
			if(x.AccountNo == AccountNum && x.Password.equals(Password))
			{
				x.Balance +=amount;
				//transCount++;
				System.out.println(x.toString());
				TransHistory transH = new TransHistory(x.Customer_id,"Deposit",x.Balance,amount);
				
				//transHistory.put(transH.Trans_id, transH);
				//transHistory.put(trans, null)
				return;
			}
			
		}
		
		System.out.println("Insuffient Balance");
		
	}
	public void ATMWithdrawal(int AccountNum,String Password,int amount) {
		
		
		for(User x :Customer.values())
		{
			if((x.AccountNo == AccountNum && x.Password.equals(Password)) && x.Balance >= amount)
			{
				x.Balance -=amount;
				//transCount++;
				System.out.println(".......................Transcation Successfully Done ......\n................Collect Your Money...........");
				System.out.println(x.toString());
				return;
			}
		
				
		}
		System.out.println("Insuffient Balance");
		
	}
	public void TransferTo(int Sender,int Receiver,int amount,String Password) {
		
		for(User x :Customer.values())
		{
			if(x.AccountNo == Sender && x.Password.equals(Password) && x.Balance >= amount)
			{
				
				for(User y :Customer.values()) {
					
					if(y.AccountNo == Receiver) {
					    x.Balance -=amount;
					    y.Balance +=amount;
					//transCount++;}
				}
			}
				
		}
			else
			{
				System.out.println("Insuffient Balance");
			}
		
		
	}}
	public void PrintCustomer() {
		
		for(User x :Customer.values())
		{
			System.out.println(x.toString());
		}
	}
	
	
	

}
