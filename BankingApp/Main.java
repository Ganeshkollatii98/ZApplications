package BankingApp;

import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static User userObj ; 
	static Transactions Trns = new Transactions();
	static int acountNumgenerator = 100001;
	
	public static void main(String[] args)
	{
		Trns.NewAccount(new User("Kumar",11011,10000,"ApipNbjm"));
		Trns.NewAccount(new User("Madhu",22022,20000,"Cboljoh"));
		Trns.NewAccount(new User("Rahul",33033,30000,"dbnqvt"));
		Trns.NewAccount(new User("Robin",44044,40000,"kbwb22"));
		
		
		do
		{
			System.out.println("1.Start\n2.Exit\n");
			int choose = sc.nextInt();
			
			switch(choose) {
			case 1:
				start();
				break;
			case 2:
				System.exit(0);
				break;
			
			}
			
			
		}while(true);
	}

	private static void start() {
		// TODO Auto-generated method stub
		boolean flag = true;
		do {
			System.out.println("1.Openning\n2.CashDeposit\n3.ATMWithDrawal\n4.TranferTo\n5.TranferFrom\n6.signout");
			int choose = sc.nextInt();
			
			switch(choose)
			{
			case 1:
				System.out.println("Enter the Name ,initialAmount,Password:");
				String Name = sc.next();
				int balance = sc.nextInt();
				String Password = sc.next();
				String encptPswd = EncriptedPswd(Password);
				Openning(Name,balance,encptPswd);
				Trns.PrintCustomer();
				break;
			case 2:
				System.out.println("Enter the AccountNum , Password, Amount of Deposit");
				int AccountNum = sc.nextInt();
				String password = sc.next();
				int amount = sc.nextInt();
				
				String encrptPswd = EncriptedPswd(password);
				
				Trns.CashDeposit(AccountNum,encrptPswd ,amount);
				//Trns.transHistory.put(null, null)
				
				break;
			case 3:
				System.out.println("Enter the AccountNum , Password, WithDraw Amount");
				int AccountNum1 = sc.nextInt();
				String password1 = sc.next();
				int amount1 = sc.nextInt();
				
				String encrptPswd1 = EncriptedPswd(password1);
				Trns.ATMWithdrawal(AccountNum1,encrptPswd1, amount1);
				//Trns.PrintCustomer();
				break;
			case 4:
				System.out.println("Enter the Sender,Receiver , Amount to Tranfer, Password");
				int AccountNum2 = sc.nextInt();
				int AccountNum3 = sc.nextInt();
				String password2 = sc.next();
				int amount2 = sc.nextInt();
				
				String encrptPswd2 = EncriptedPswd(password2);
				
				Trns.TransferTo(AccountNum2,AccountNum3, 1500, "encrptPswd2");
				//Trns.PrintCustomer();
				break;
			case 5:
				break;
				
			case 6:
				flag = false;
				break;
			}
			
			
		}while(flag);
		
	}

	private static void Openning(String name, int balance, String encptPswd) {
		// TODO Auto-generated method stub
		//Random random = new Random();
		
		int AccountNo = acountNumgenerator;
		acountNumgenerator++;
		//int AccountNo = 11111;
		User obj=new User(name,AccountNo,balance,encptPswd);
		Trns.NewAccount(obj);
		AccountNo++;
		
	}

	private static String EncriptedPswd(String P){
		
		int len = P.length();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0 ; i < len ; i++) {
			
			if(P.charAt(i) >='a' && P.charAt(i) < 'z' || P.charAt(i) >='A' && P.charAt(i) < 'Z' || P.charAt(i) >='0' && P.charAt(i) < '9')
			{
				char ch = P.charAt(i);
				int temp = (int)ch+1;
				sb.append((char)temp);
				
			}
			else if(P.charAt(i) == 'z') sb.append('a');
			else if(P.charAt(i) == 'Z') sb.append('A');
			else if(P.charAt(i) =='9') sb.append('0');
			
		}
		return sb.toString();
	}
  private static String DecriptedPswd(String P){
		
		int len = P.length();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0 ; i < len ; i++) {
			
			if(P.charAt(i) >'a' && P.charAt(i) <= 'z' || P.charAt(i) >'A' && P.charAt(i) <= 'Z' || P.charAt(i) >'0' && P.charAt(i) <= '9')
			{
				char ch = P.charAt(i);
				int temp = (int)ch-1;
				sb.append((char)temp);
				
			}
			else if(P.charAt(i) == 'a') sb.append('z');
			else if(P.charAt(i) == 'A') sb.append('Z');
			else if(P.charAt(i) =='0') sb.append('9');
			
		}
		return sb.toString();
	}

	

}
