package myjava.homework;
import java.lang.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prime {
    /* Check whether it's prime number */
    private static boolean isPrime(int num) {
        // Write down your code.
        int bound=(int)Math.floor(Math.sqrt(num));

        for(int i=2;i<=bound;++i){
            if(num%i==0) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int option, num, i, count = 0;
        Scanner scan = null;

        while (true) {
            try {
                /* Get standard input object. */
                scan = new Scanner(System.in);
                /* Print message. */
                System.out.println("1. Check whether it's prime number\n" + "2. Find prime number(2~N)\n" + "3. Leave");
                /* Input an integer. */
                option = scan.nextInt();
                switch (option) {
                    case 1:
                        /* Write down your code. */
                        /* Check whether it's prime number */
                        System.out.println("Input the number:");
                        num = scan.nextInt();
                        if(num<2)System.out.println("Input error : N must equal greater than 2\n");
                        else {

                            boolean check= isPrime(num);
                            if(check)System.out.println(num +" is a prime\n");
                            else System.out.println(num +" is not a prime\n");
                        }
                        break;
                    case 2:
                        /* Write down your code. */
                        /* Find prime number(2~N) */
                        System.out.println("Input the number:");
                        num = scan.nextInt();
                        if (num<2) {
                            System.out.println("Input error : N must equal greater than 2\n");
                        }
                        else {
                            for(i=2;i<=num;++i){
                                if(isPrime(i)) {
                                    System.out.print(i + "\t");
                                    if (++count == 10) {
                                        System.out.println();
                                        count = 0;
                                    }
                                }
                            }
                            System.out.println();
                        }
                        break;
                    case 3:
                        /* Write down your code. */
                        /* End the process */
                        System.out.println("Bye!!!\n");
                        return;

                    default:
                        System.out.println("Input error : incorrect option");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input error : ONLY Integers.");
            }
        }
    }
}