package myjava.homework;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {

    /* Fill your code here */
    boolean userAuthenticated;
    public BankDatabase bankDatabase;

    public void run() {
        while (true) {
            int accountNumber, pin;
            this.bankDatabase = new BankDatabase();
            Keypad keyboard = new Keypad();
            Screen screen = new Screen();
            try {
                screen.displayMessageLine("Welcome !");
                screen.displayMessage("Please enter your account number : ");
                accountNumber = keyboard.getInput();
                screen.displayMessage("Please enter your pin : ");
                pin = keyboard.getInput();
                this.userAuthenticated = this.bankDatabase.authenticateUser(accountNumber, pin);
                if (this.userAuthenticated) {
                    int choice;
                    while (true) {
                        screen.displayMessage("\nMain_menu :\n1. View my balance\n2. Withdraw\n3. Deposit\n4. Loan\n5. Exit\nEnter a choice : ");
                        choice = keyboard.getInput();
                        try {
                            Transaction transactionObject = this.transactionBuilder(choice, accountNumber);
                            transactionObject.setBankDatabase(this.bankDatabase);
                            transactionObject.execute();
                            System.out.println();
                        } catch (InputMismatchException e) {
                            if (choice==5) {
                                System.exit(0);
                            }
                            screen.displayMessageLine("Input error");
                        }
                    }
                } else {
                    screen.displayMessageLine("AccountNumber or Pin Error\n");
                }

            } catch (InputMismatchException e) {
                screen.displayMessageLine(e.getMessage());
            } catch (IOException e) {
                screen.displayMessageLine(e.getMessage());
            }
        }
    }

    private Transaction transactionBuilder(int choice, int accountNumber) throws InputMismatchException {
        switch (choice) {
            case 1:
                return new BalanceInquiry(accountNumber);
            case 2:
                return new Withdrawal(accountNumber);
            case 3:
                return new Deposit(accountNumber);
            case 4:
                return new Loan(accountNumber);
            default:
                throw new InputMismatchException();
        }
    }

}
