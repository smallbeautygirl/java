package myjava.homework;


import java.util.ArrayList;

public class Permutation extends fourStarGame {
    public void checkOfWin() {

        ArrayList<Integer> a1 = getUserNums();
        ArrayList<Integer> a2 = getWinNums();
        if (a1.size() == 0) {
            return;
        } else {
            if (a1.equals(a2)) {
                System.out.println("**You win!");
            } else {
                System.out.println("**You lose!");
            }
        }
    }
}
