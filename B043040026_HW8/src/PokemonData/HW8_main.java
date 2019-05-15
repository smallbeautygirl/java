package PokemonData;

import java.text.DecimalFormat;
import java.util.*;

import static PokemonData.Adventure.Encounter;
import static PokemonData.Adventure.CatchScenes;

public class HW8_main {
    public static <T> void main(String[] args) {

        while (true) {
            try {
                System.out.print("Select Adventure Map (1: Forest, 2:Grassland) :");//select map
                Scanner keyboard = new Scanner(System.in);
                int choice = keyboard.nextInt();//user's choice
                List<Pokemon> catchPokemonList=CatchScenes(Encounter(choice));//存會遭遇的pokemon

                DecimalFormat df2 = new DecimalFormat("##.00");//小數點後兩位
                DecimalFormat df3 = new DecimalFormat("##.000");//小數點後3位

                //判斷catchlist是否為空
                if(catchPokemonList.size()!=0){
                    System.out.println("My Pokemon List :");
                }

                //印出抓到的寶可夢資訊
                for(int i=0;i<catchPokemonList.size();++i){
                    System.out.println("Pokemon : "+catchPokemonList.get(i).toString());
                    System.out.println("HP : "+catchPokemonList.get(i).HP+"   ATK : "+catchPokemonList.get(i).ATK+"   DEF : "+catchPokemonList.get(i).DEF+"   CP :"+catchPokemonList.get(i).CombatPower());
                    double finalHeight = Double.parseDouble(df2.format(catchPokemonList.get(i).Height/100.0));
                    double finalWeight = Double.parseDouble(df3.format(catchPokemonList.get(i).Weight/1000.0));
                    System.out.println("Height : "+finalHeight+" m   Weight : "+finalWeight+" kg\n\n");
                }

            } catch (InputMismatchException E) {
                System.out.println("Please enter correct input!!");
            }
        }
    }
}
