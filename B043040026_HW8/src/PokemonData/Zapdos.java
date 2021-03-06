package PokemonData;

import java.util.Random;

public class Zapdos extends Pokemon {
    private int Level;
    private int Fluctuation;
    private int CorrectHeight;
    private int CorrectWeight;

    public Zapdos(){
        this.Level = 5;
        this.Fluctuation = 5;
        this.CorrectHeight = 5;
        this.CorrectWeight = 50;
        this.Name = "Zapdos";
        Random random = new Random();
        int addORsub=0;
        //set HP
        addORsub = random.nextInt(1);
        this.Fluctuation = random.nextInt(this.Fluctuation+1);//0~5
        if(addORsub==0){
            this.HP = this.HP * this.Level+this.Fluctuation;
        }else{
            this.HP = this.HP * this.Level-this.Fluctuation;
        }

        //set ATK
        addORsub = random.nextInt(1);
        this.Fluctuation = random.nextInt(this.Fluctuation+1);//0~5
        if(addORsub==0){
            this.ATK = this.ATK * this.Level+this.Fluctuation;
        }else{
            this.ATK = this.ATK * this.Level-this.Fluctuation;
        }

        //set DEF
        addORsub = random.nextInt(1);
        this.Fluctuation = random.nextInt(this.Fluctuation+1);//0~5
        if(addORsub==0){
            this.DEF = this.DEF * this.Level+this.Fluctuation;
        }else{
            this.DEF = this.DEF * this.Level-this.Fluctuation;
        }

        //set Height
        addORsub = random.nextInt(1);
        this.CorrectHeight = random.nextInt(this.CorrectHeight+1);//0~5
        if(addORsub==0){
            this.Height = this.Height+this.CorrectHeight;
        }else{
            this.Height = this.Height-this.CorrectHeight;
        }

        //set Weight
        addORsub = random.nextInt(1);
        this.CorrectWeight = random.nextInt(this.CorrectWeight+1);//0~50
        if(addORsub==0){
            this.Weight = this.Weight+this.CorrectWeight;
        }else{
            this.Weight = this.Weight-this.CorrectWeight;
        }
    }
}
