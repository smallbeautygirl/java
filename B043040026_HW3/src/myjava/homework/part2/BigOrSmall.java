package myjava.homework.part2;

import java.util.Scanner;

import static java.lang.System.exit;

public class BigOrSmall {
    public static void main(String[] args) {
        String rule;//big or small
        Scanner keyboard = new Scanner(System.in);

        while (true) {
            System.out.println("Which game you want? (You can input big or small to play, or input exit to quit.)");
            rule = keyboard.next();

            if (rule.equals("big")) {
                Race rc_big = new Race(RaceKind.BIG);
                rc_big.start();
            } else if (rule.equals("small")) {
                Race rc_small = new Race(RaceKind.SMALL);
                rc_small.start();
            } else if (rule.equals("exit")) {
                System.out.println("Game Over!!");
                exit(0);
            } else {
                System.out.println("You have error input. The game is failed!");
            }
        }
    }
}
