package myjava.homework;
import java.util.Random;

public class WildPokemon extends Pokemon{
    private int initalHp;

    public WildPokemon(){
        super((new Random()).nextInt(300-150+1)+150,(new Random()).nextInt(35-30+1)+30,0,"","Wildpokemon");
        this.initalHp=this.getHp();
    }

    public int getInitalHp() {
        return initalHp;
    }

    public int action(int wildAtk,int wildHp) {
        return 0;
    }
}
