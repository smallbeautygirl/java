package myjava.homework_part2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {

        int option;
        String newitem, ritem;
        ItemList il = new ItemList();

        while (true) {
            try {
                Scanner scan = new Scanner(System.in);

                System.out.println("Type 1: add item to list");
                System.out.println("Type 2: remove item from list");
                System.out.println("Type 3: show the list");

                option = scan.nextInt();
                switch (option) {
                    case 1:
                        System.out.print("Add item name :");
                        newitem = scan.next();
                        il.addItem(newitem);
                        System.out.println();
                        break;

                    case 2:
                        System.out.println("remove item name");
                        ritem = scan.next();
                        il.remove(ritem);
                        System.out.println();
                        break;

                    case 3:
                        il.printList();
                        System.out.println();
                        break;

                    default:
                        throw new InputMismatchException();

                }
            } catch (InputMismatchException e) {
                System.out.println("Input error!!");
            }
        }
    }
}
