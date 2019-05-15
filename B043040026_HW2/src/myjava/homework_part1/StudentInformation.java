package myjava.homework_part1;

public class StudentInformation {
    private String id;
    private String name;
    private int score;

    public StudentInformation() {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public void setID(String newId) {
        id = newId;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setScore(int newScore) {
        score = newScore;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setData(String d1, String d2, int d3) {
        id = d1;
        name = d2;
        score = d3;
    }

    public void show_data() {
        System.out.println("Student id :" + id);
        System.out.println("Student name :" + name);
        if (score < 60) {
            System.out.println("Student " + name + " fail this project");
        } else {
            System.out.println("Student " + name + " pass this project");
        }
    }

}
