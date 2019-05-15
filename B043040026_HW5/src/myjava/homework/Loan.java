package myjava.homework;// Represents a withdrawal ATM transaction

import java.io.IOException;
import java.util.Scanner;

public class Loan extends Transaction {

    public Loan(int accountNumber) {
        super(accountNumber);
    }

    @Override
    public void execute() {

        int debt, loan, LoanLimit = 0;
        char CreditLevel;
        debt = this.bankDatabase.getDebt(getAccountNumber());
        Screen screen = new Screen();
        screen.displayMessageLine("Your debt : " + debt);
        CreditLevel = this.bankDatabase.getCreditLevel(getAccountNumber());

        switch (CreditLevel) {
            case 'A':
                LoanLimit = 11000;
                break;
            case 'B':
                LoanLimit = 9000;
                break;
            case 'C':
                LoanLimit = 7000;
                break;
            case 'D':
                LoanLimit = 5000;
                break;
            default:
                screen.displayMessage("error credit level");
                break;
        }

        if (debt == LoanLimit)
        {
            screen.displayMessageLine("Sorry, You can not loan any money now.");
            return;
        } else{
            LoanLimit = LoanLimit - debt;
            screen.displayMessage("Your loan limit is " + LoanLimit + ", How much do you want to loan : ");
            Keypad keyboard = new Keypad();


            try {
                loan = keyboard.getInput();

                if (loan > LoanLimit) {
                    screen.displayMessageLine("Transaction Error, You have not much Loan Limit");
                } else {
                    debt = this.bankDatabase.getDebt(getAccountNumber()) + loan;
                    this.bankDatabase.setDebt(getAccountNumber(), debt);
                    screen.displayMessageLine("Transaction Success");
                }
            } catch (IOException e) {
                screen.displayMessageLine(e.getMessage());
            }

        }
    }

    /* Fill your code here */

}
