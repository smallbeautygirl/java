package myjava.homework;// Represents a deposit ATM transaction

import java.io.IOException;
import java.util.Scanner;

public class Deposit extends Transaction {

    public Deposit(int accountNumber) {
        super(accountNumber);
    }

    @Override
    public void execute() {
        Screen screen = new Screen();
        try {

            screen.displayMessage("How much do you want to deposit : ");
            Keypad keyboard = new Keypad();
            int money = keyboard.getInput();

            money = this.bankDatabase.getTotalBalance(getAccountNumber()) + money;
            this.bankDatabase.setTotalBalance(getAccountNumber(), money);
            screen.displayMessageLine("Transaction Success");
        } catch (IOException e) {
            screen.displayMessageLine("error");
        }
    }

    /* Fill your code here */

}
