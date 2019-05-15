package myjava.homework.part1;

public class ARGSomething {
    //type 1
    private int avg(int i1, int i2) {
        int out;
        out = (i1 + i2) / 2;
        return out;
    }

    public int avg(int i1, int i2, int i3) {
        int out;
        out = (i1 + i2 + i3) / 3;
        return out;
    }

    public int avg(int i1, int i2, int i3, int i4) {
        int out;
        out = (i1 + i2 + i3 + i4) / 4;
        return out;
    }

    //type 2
    public double avg(double d1, double d2) {
        double out;
        out = (d1 + d2) / 2;
        return out;
    }

    public double avg(double d1, double d2, double d3, double d4) {
        double out;
        out = (d1 + d2 + d3 + d4) / 4;
        return out;
    }

    public double avg(double d1, double d2, double d3) {
        double out;
        out = (d1 + d2 + d3) / 3;
        return out;
    }

    //type 3
    static String avg(String s) {
        return ("The number of this word is " + s.length());
    }

    static String avg(String s1, String s2) {
        double out = ((double) s1.length() + (double) s2.length()) / 2;
        return ("The number of these words is " + out);
    }

    static String avg(String s1, String s2, String s3) {
        double out = ((double) s1.length() + (double) s2.length() + (double) s3.length()) / 3;
        return ("The number of these words is " + out);
    }

    //type4
    static String avg(Apple a) {
        double out = a.getWeight() / a.getPrice();
        return ("The price per gram is " + out);
    }

    static String avg(Apple a, Apple b) {
        double out = (a.getWeight() + b.getWeight()) / (a.getPrice() + b.getPrice());
        return ("The price per gram is " + out);
    }

    static String avg(Apple a, Apple b, Apple c) {
        double out = (a.getWeight() + b.getWeight() + c.getWeight()) / (a.getPrice() + b.getPrice() + c.getPrice());

        return ("The price per gram is " + out);
    }

    public static void main(String[] args) {
        // You cannot modify anything in the main function!!!!
        ARGSomething t = new ARGSomething();
        System.out.println(t.avg(10, 20));
        System.out.println(t.avg(20, 60, 120));
        System.out.println(t.avg(10, 20, 30, 40));

        System.out.println(t.avg(0.1, 0.2));
        System.out.println(t.avg(20, 60.0, 120));
        System.out.println(t.avg(10, 20, new Integer(30), 40.0));

        System.out.println(avg("Apple"));
        System.out.println(avg("Apple", "Cat"));
        System.out.println(avg("Apple", "Cat", new String("Bee")));

        System.out.println(avg(new Apple(10, 59.5)));
        System.out.println(avg(new Apple(10, 59.5), new Apple("Washington", 30, 80.3)));
        Apple green = new Apple("Granny Smith", 30, 88);
        System.out.println(avg(new Apple(10, 59.5), new Apple("Washington", 30, 80.3), green));
    }

}
