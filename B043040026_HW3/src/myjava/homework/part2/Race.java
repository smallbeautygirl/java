package myjava.homework.part2;

import java.util.Random;

public class Race {

    private int raceKind;

    public Race(int raceKind) {
        this.raceKind = raceKind;
    }

    public void start() {
        Random rd = new Random();
        String[] suit = new String[]{"_Club_", "_Diamond_", "_Heart_", "_Spade_"};
        String[] num = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        int my_num = rd.nextInt(13);   // number
        int my_suit = rd.nextInt(4);    // four suit

        //for you
        System.out.print("Your hand is ");
        System.out.print(suit[my_suit]);
        System.out.println(num[my_num]);

        //for computer
        int com_num = rd.nextInt(13);   // number
        int com_suit = rd.nextInt(4);    // four suit
        System.out.print("Com's hand is ");
        System.out.print(suit[com_suit]);
        //ensure computer's card is different to my card
        if (my_suit != com_suit) {
            System.out.println(num[com_num]);
        } else {
            com_num = com_num + 1;
            System.out.println(num[com_num]);
        }

        if (this.raceKind == RaceKind.BIG) {
            if ((my_num > com_num) || ((my_num == com_num) && (my_suit > com_suit))) {
                System.out.println(suit[my_suit] + num[my_num] + " is bigger than " + suit[com_suit] + num[com_num] + "\nSo, you win!\n");
            } else {
                System.out.println(suit[my_suit] + num[my_num] + " is smaller than " + suit[com_suit] + num[com_num] + "\nSo, Com win!\n");
            }
        } else {
            if ((my_num < com_num) || ((my_num == com_num) && (my_suit < com_suit))) {
                System.out.println(suit[my_suit] + num[my_num] + " is smaller than " + suit[com_suit] + num[com_num] + "\nSo, you win!\n");
            } else {
                System.out.println(suit[my_suit] + num[my_num] + " is bigger than " + suit[com_suit] + num[com_num] + "\nSo, Com win!\n");
            }
        }
    }
}