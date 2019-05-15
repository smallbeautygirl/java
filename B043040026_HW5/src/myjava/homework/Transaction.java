package myjava.homework;// Abstract superclass Transaction represents an ATM transaction

public abstract class Transaction {
	
	/* Fill your code here */
    private int accountNumber;

    protected BankDatabase bankDatabase;

    public Transaction(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public void setBankDatabase(BankDatabase bankDatabase) {
        this.bankDatabase = bankDatabase;
    }

    public abstract void execute();
	
}
