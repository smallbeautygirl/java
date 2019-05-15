package myjava.homework_part2;

import java.util.ArrayList;

public class ItemList {
    private ArrayList<String> id = new ArrayList<String>();

    public void addItem(String newitem) {
        id.add(newitem);
    }

    public void remove(String s) {
        id.remove(s);
    }

    public void printList() {
        System.out.println("show the list");
        for (int i = 0; i < id.size(); ++i) {
            System.out.println((i + 1) + " : " + id.get(i));
        }
    }
}
