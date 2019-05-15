package PokemonData;

import java.util.Random;

public class Moltres extends Pokemon{
    private int Level;
    private int Fluctuation;
    private int CorrectHeight;
    private int CorrectWeight;

    public Moltres(){
        this.Level = 10;
        this.Fluctuation = 10;
        this.CorrectHeight = 10;
        this.CorrectWeight = 1000;
        this.Name = "Moltres";
        Random random = new Random();
        int addORsub=0;
        //set HP
        addORsub = random.nextInt(1);
        this.Fluctuation = random.nextInt(this.Fluctuation+1);//0~10
        if(addORsub==0){
            this.HP = this.HP * this.Level+this.Fluctuation;
        }else{
            this.HP = this.HP * this.Level-this.Fluctuation;
        }

        //set ATK
        addORsub = random.nextInt(1);
        this.Fluctuation = random.nextInt(this.Fluctuation+1);//0~10
        if(addORsub==0){
            this.ATK = this.ATK * this.Level+this.Fluctuation;
        }else{
            this.ATK = this.ATK * this.Level-this.Fluctuation;
        }

        //set DEF
        addORsub = random.nextInt(1);
        this.Fluctuation = random.nextInt(this.Fluctuation+1);//0~10
        if(addORsub==0){
            this.DEF = this.DEF * this.Level+this.Fluctuation;
        }else{
            this.DEF = this.DEF * this.Level-this.Fluctuation;
        }

        //set Height
        addORsub = random.nextInt(1);
        this.CorrectHeight = random.nextInt(this.CorrectHeight+1);//0~10
        if(addORsub==0){
            this.Height = this.Height+this.CorrectHeight;
        }else{
            this.Height = this.Height-this.CorrectHeight;
        }

        //set Weight
        addORsub = random.nextInt(1);
        this.CorrectWeight = random.nextInt(this.CorrectWeight+1);//0~1000
        if(addORsub==0){
            this.Weight = this.Weight+this.CorrectWeight;
        }else{
            this.Weight = this.Weight-this.CorrectWeight;
        }
    }
}
