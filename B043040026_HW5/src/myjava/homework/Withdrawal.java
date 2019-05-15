package myjava.homework;// Represents a withdrawal ATM transaction

import java.io.IOException;
import java.util.Scanner;

public class Withdrawal extends Transaction{

    public Withdrawal(int accountNumber)
    {
        super(accountNumber);
    }
    @Override
    public void execute() {

        Screen screen = new Screen();
        try {
            screen.displayMessage("How mush do you want to withdraw : ");
            Keypad keyboard = new Keypad();
            int money;
            money=keyboard.getInput();

            money = this.bankDatabase.getTotalBalance(getAccountNumber())-money;
            this.bankDatabase.setTotalBalance(getAccountNumber(),money);

            screen.displayMessageLine("Transaction Success");
        } catch (IOException e) {
            screen.displayMessageLine("error");
        }
    }

    /* Fill your code here */

}
