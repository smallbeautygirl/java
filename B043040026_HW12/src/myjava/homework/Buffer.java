package myjava.homework;

import java.util.ArrayList;

public interface Buffer {
    public void set(int value) throws InterruptedException;

    public int get(String name) throws InterruptedException;

    public void displayState(String operation) throws InterruptedException;

    public void printFinal(ArrayList arrayList, int sum, String name) throws InterruptedException;
}
