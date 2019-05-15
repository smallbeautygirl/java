package myjava.homework;// Represents a balance inquiry ATM transaction

public class BalanceInquiry extends Transaction{

	/* Fill your code here */

    public BalanceInquiry(int accountNumber)
    {
        super(accountNumber);
    }

    @Override
    public void execute() {
        Screen screen = new Screen();
        screen.displayMessageLine("Balance Information ");

        int TotalBalance =this.bankDatabase.getTotalBalance(this.getAccountNumber());

        screen.displayMessageLine("Total Balance : "+TotalBalance);
    }
}
