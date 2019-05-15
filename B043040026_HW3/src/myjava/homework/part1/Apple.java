package myjava.homework.part1;

public class Apple {
    private String variety;
    private int price;
    private double weight;

    public Apple(int i, double d) {
        price = i;
        weight = d;
    }

    public Apple(String s, int i, double d) {
        variety = s;
        price = i;
        weight = d;
    }

    public int getPrice() {
        return price;
    }

    protected void setPrice(int i) {
        price = i;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double d) {

        weight = d;
    }

    protected void setVariety(String s) {

        variety = s;
    }

}
