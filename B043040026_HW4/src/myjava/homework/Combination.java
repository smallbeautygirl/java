package myjava.homework;

import java.util.ArrayList;

public class Combination extends fourStarGame {
    public void checkOfWin() {
        ArrayList<Integer> a1 = getUserNums();
        ArrayList<Integer> a2 = getWinNums();
        int check = 0;

        if (a1.size() == 0) {
            return;
        } else {
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    if (a1.get(i) == a2.get(j)) {
                        check++;
                    }
                }
            }
            if (check == 4) {
                System.out.println("**You win!");
            } else {
                System.out.println("**You lose!");
            }
        }

    }
}
