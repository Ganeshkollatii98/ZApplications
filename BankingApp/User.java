package BankingApp;

import java.util.ArrayList;

public class User {
	static int Cust_id=10;
	String Name;
	int AccountNo;
	int Balance;
	String Password;
	int Customer_id;
	static int transCount=0;
	static ArrayList<Integer> TransDetails = new ArrayList<>();
	public User(String name, int accountNo, int balance, String password) {
		Name = name;
		AccountNo = accountNo;
		Balance = balance;
		Password = password;
		Customer_id =Cust_id++;
	}
	@Override
	public String toString() {
		return "User [Name=" + Name + ", AccountNo=" + AccountNo + ", Balance=" + Balance + ", Password=" + Password
				+ ", Customer_id ="+Customer_id+"]";
	}
	
	public int Count()
	{
		return ++transCount;
	}
	
	
	
}
