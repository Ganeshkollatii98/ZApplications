package BankingApp;

public class TransHistory {
	
	static int id =0;
	
	int Customer_id ;
	String TransType;
	int Balance;
	int Amount;
	int Trans_id;
	public TransHistory(int customer_id, String transType, int balance, int amount) {
		Customer_id = customer_id;
		TransType = transType;
		Balance = balance;
		Amount = amount;
		id++;
		Trans_id = id;
	}
	
	
	
	

}
