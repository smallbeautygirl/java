package myjava.homework_part1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

public class Controller {
    public static void main(String[] args) {

        int option, count = 0, newscore;
        String newid, newname;

        Vector v = new Vector();

        while (true) {
            StudentInformation s = new StudentInformation();
            try {
                Scanner scan = new Scanner(System.in);

                System.out.println("Type 1: add a student's data(student ID,student name and student score)");
                System.out.println("Type 2: show student's data");
                System.out.println("Type 3: show all student's data.");

                option = scan.nextInt();
                switch (option) {
                    case 1:
                        System.out.print("Add new student's data :\nstudent id :");
                        newid = scan.next();
                        s.setID(newid);
                        System.out.print("student name :");
                        newname = scan.next();
                        s.setName(newname);
                        System.out.print("Score :");
                        newscore = scan.nextInt();
                        s.setScore(newscore);

                        count++;
                        System.out.println("This is student " + count + "\n");

                        v.addElement(s);
                        break;

                    case 2:
                        System.out.println("To show which student's information");
                        int which;
                        which = scan.nextInt();
                        if (which > count) {
                            System.out.println("Data no found\n");
                        } else {

                            s = (StudentInformation) v.get(which - 1);
                            s.show_data();


                            System.out.println("This is student " + which + "\n");
                        }
                        break;

                    case 3:
                        System.out.println("====Student's data====");
                        int pass = 0, fail = 0;
                        for (int i = 0; i < v.size(); ++i) {
                            s = (StudentInformation) v.get(i);
                            System.out.println("Number : " + (i + 1));
                            s.show_data();
                            System.out.println();
                            if (s.getScore() >= 60) {
                                pass++;
                            } else {
                                fail++;
                            }
                        }

                        System.out.println("===============");
                        System.out.println("Pass :" + pass);
                        System.out.println("No pass : " + fail + "\n");
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
