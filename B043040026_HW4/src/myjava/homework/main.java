package myjava.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] arg){

        while(true) {
            try {
                System.out.println("Choose your Four Star Game type : (1:myjava.homework.Combination 2:myjava.homework.Permutation 3: Exit)");
                Scanner input = new Scanner(System.in);
                int type = input.nextInt();
                Permutation per = new Permutation();
                Combination com = new Combination();
                switch (type) {
                    case 1:
                        com.generateWinNums();
                        com.generateUserNums();
                        com.checkOfWin();
                        break;
                    case 2:
                        per.generateWinNums();
                        per.generateUserNums();
                        per.checkOfWin();
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Input error!!");
                        break;
                }
            }catch(InputMismatchException e){
                System.out.println("Input error : ONLY Integers.");
            }
        }
    }
}
