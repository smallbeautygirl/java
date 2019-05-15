package PokemonData;

import java.util.Random;

public class Pokemon {
    protected String Name;
    protected int HP;
    protected int ATK;
    protected int DEF;
    protected int Height;
    protected int Weight;
    protected int CatchRate;

    public Pokemon() {
        this.HP = 10;
        this.ATK = 2;
        this.DEF = 2;
        this.Height = 87;//cm
        this.Weight = 7000;//g
        Random random = new Random();
        this.CatchRate = random.nextInt(99)+1;//1~99
    }

    public String toString() {
        return this.Name;
    }

    public boolean Catch(int propability) {
        if (propability >= this.CatchRate) {
            return true;
        }
        return false;
    }

    public int CombatPower() {
        return (int) (this.HP * 2 + this.ATK * 1.5 + this.DEF);
    }

    public boolean Runaway(int round) {
        int wildpokemonRunawayProbability=5;//initialize the wildpokemon's runway probability
        wildpokemonRunawayProbability+=(round*5);
        Random random = new Random();
        int runawayProbability=random.nextInt(99)+1;//1~99

        //判斷野生寶可夢是否會逃跑
        if(wildpokemonRunawayProbability<runawayProbability){
            return false;
        }else{
            return true;
        }
    }
}
