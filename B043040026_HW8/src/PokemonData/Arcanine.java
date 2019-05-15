package PokemonData;

import java.util.Random;

public class Arcanine extends Pokemon{
    private int Level;
    private int Fluctuation;
    private int CorrectHeight;//Height 浮動值
    private int CorrectWeight;//Weight 浮動值

    public Arcanine(){
        Random random = new Random();
        this.Name = "Arcanine";
        this.Level = 15;
        this.Fluctuation = 15;
        this.CorrectHeight = 15;
        this.CorrectWeight = 15;
        int fluctuation=0,addORsub;

        //set HP
        addORsub = random.nextInt(1);
        fluctuation = random.nextInt(this.Fluctuation+1);//0~15
        if(addORsub==0){
            this.HP = this.HP * this.Level+fluctuation;
        }else{
            this.HP = this.HP * this.Level-fluctuation;
        }

        //set ATK
        addORsub = random.nextInt(1);
        fluctuation = random.nextInt(this.Fluctuation+1);//0~15
        if(addORsub==0){
            this.ATK = this.ATK * this.Level+fluctuation;
        }else{
            this.ATK = this.ATK * this.Level-fluctuation;
        }

        //set DEF
        addORsub = random.nextInt(1);
        fluctuation = random.nextInt(this.Fluctuation+1);//0~15
        if(addORsub==0){
            this.DEF = this.DEF * this.Level+fluctuation;
        }else{
            this.DEF = this.DEF * this.Level-fluctuation;
        }

        //set Height
        addORsub = random.nextInt(1);
        this.CorrectHeight = random.nextInt(this.CorrectHeight+1);//0~15
        if(addORsub==0){
            this.Height = this.Height+this.CorrectHeight;
        }else{
            this.Height = this.Height-this.CorrectHeight;
        }

        //set Weight
        addORsub = random.nextInt(1);
        this.CorrectWeight = random.nextInt(this.CorrectWeight+1);//0~15
        if(addORsub==0){
            this.Weight = this.Weight+this.CorrectWeight;
        }else{
            this.Weight = this.Weight-this.CorrectWeight;
        }
    }
}
