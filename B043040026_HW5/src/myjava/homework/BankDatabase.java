package myjava.homework;// Represents the bank account information database

public class BankDatabase {
	
	private Account[] accounts; // array of Accounts
	
    // no-argument BankDatabase constructor initializes accounts
	public BankDatabase () {
		accounts = new Account[4];  // just 4 accounts for testing
		accounts[0] = new Account(111, 222, 5000,0,'A');
		accounts[1] = new Account(222, 333, 4000,0,'B');
		accounts[2] = new Account(333, 444, 3000,0,'C');
		accounts[3] = new Account(444, 555, 2000,0,'D');
	}
	
	/* Fill your code here */
	public boolean authenticateUser(int i1,int i2){
		for (int i=0; i < accounts.length;++i){
			if(i1==accounts[i].getAccountNumber() && accounts[i].validatePIN(i2)){
				return true;
			}
		}
		return false;
	}

	public int getTotalBalance(int in){
		return getAccountIndex(in).getTotalBalance();
	}

	public char getCreditLevel(int in){

		return getAccountIndex(in).getCreditLevel();
	}

	public int getDebt(int in){
		return getAccountIndex(in).getDebt();
	}

	public void setTotalBalance(int i1,int i2){
		getAccountIndex(i1).setTotalBalance(i2);
	}

	public void setDebt(int i1,int i2){
		getAccountIndex(i1).setDebt(i2);
	}

	public Account getAccountIndex(int in){
		for (int i=0; i < accounts.length;++i){
			if(accounts[i].getAccountNumber()==in){
				return accounts[i];
			}
		}
		throw new IndexOutOfBoundsException();
	}


}
