package myjava.homework;

import java.util.InputMismatchException;

public abstract class  Pokemon {
    private int hp;
    private int atk;
    private int unique;
    private String unique_name;
    private String class_name;

    public Pokemon(int hp,int atk,int unique,String unique_name,String class_name){
        this.hp=hp;
        this.atk=atk;
        this.unique=unique;
        this.unique_name=unique_name;
        this.class_name = class_name;
    }
    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getUnique(){
        return unique;
    }

    public String getUnique_name(){
        return unique_name;
    }

    public String getClassName(){
        return class_name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(int atk){
        this.atk = atk;
    }

    public void setUnique(int unique){
        this.unique = unique;
    }

    public abstract int action(int wildAtk,int wildHp) throws Exception;
}
