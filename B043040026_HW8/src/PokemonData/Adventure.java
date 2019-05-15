package PokemonData;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Adventure {
    public static List<Pokemon> Encounter(int map) {
        Random random = new Random();
        List<Pokemon> list = new ArrayList<Pokemon>();//store random pokemon

        Pokemon rattata = new Rattata();
        Pokemon pikachu = new Pikachu();
        Pokemon gloom = new Gloom();
        Pokemon zapdos = new Zapdos();
        Pokemon pidgey = new Pidgey();
        Pokemon eevee = new Eevee();
        Pokemon arcanine = new Arcanine();
        Pokemon moltres = new Moltres();

        int number = 0;//wildpokemon 數量
        number = random.nextInt(4) + 4;//隨機產生4~7隻野生寶可夢

        if (map == 1) {
            int wildpokemon = 0;

            for (int i = 0; i < number; ++i) {
                wildpokemon = random.nextInt(100); //產生一個介於0~99的亂數

                if (wildpokemon < 50) { //產生Rattata 50%
                    list.add(rattata);
                } else if (wildpokemon < 80) { //產生 Pikachu 30%
                    list.add(pikachu);
                } else if (wildpokemon < 95) { //產生Gloom 15%
                    list.add(gloom);
                } else { //產生Zapdos 5%
                    list.add(zapdos);
                }
            }

        } else {
            int wildpokemon = 0;
            for (int i = 0; i < number; ++i) {
                wildpokemon = random.nextInt(100); //產生一個介於0~99的亂數

                if (wildpokemon < 50) { //產生Pidgey 50%
                    list.add(pidgey);
                } else if (wildpokemon < 80) { //產生 Eevee 30%
                    list.add(eevee);
                } else if (wildpokemon < 95) { //產生Arcanine 15%
                    list.add(arcanine);
                } else { //產生Moltres 5%
                    list.add(moltres);
                }
            }
        }

        return list;
    }

    public static <T extends Pokemon> List<T> CatchScenes(List<T> lists) {
        DecimalFormat df2 = new DecimalFormat("##.00");//小數點後兩位
        DecimalFormat df3 = new DecimalFormat("##.000");//小數點後3位
        Random random = new Random();
        Scanner keyboard = new Scanner(System.in);
        List<T> catchPokemonList = new ArrayList<>();
        //進入冒險地圖
        for (int i = 0; i < lists.size(); ++i) {
            Pokemon pokemon = lists.get(i);
            int round_number=1,initialcatchProbapility=0;

            //initialize the catch probability
            initialcatchProbapility = random.nextInt(99)+1;//11~99

            //initialize the wildpokemon's runway probability = 5%
            int wildpokemonRunwayProbability=5;
            while(true){
                System.out.println("Pokemon : "+pokemon.toString());
                System.out.println("HP : "+pokemon.HP+"   ATK : "+pokemon.ATK+"   DEF : "+pokemon.DEF+"   CP :"+pokemon.CombatPower());
                double finalHeight = Double.parseDouble(df2.format(pokemon.Height/100.0));
                double finalWeight = Double.parseDouble(df3.format(pokemon.Weight/1000.0));
                System.out.println("Height : "+finalHeight+" m   Weight : "+finalWeight+" kg\n");

                System.out.println("Round : "+round_number);
                System.out.print("Choose your action (1: Catch, 2: Runaway): ");
                int action=0;
                action = keyboard.nextInt();

                if(action == 1){//throw the ball
                    System.out.println("Throw the poke Ball...");
                    int ball=0;
                    ball = random.nextInt(100);//0~99

                    //Excellent Catch
                    if(ball<5){
                        initialcatchProbapility+=10;//捕獲機率+10
                        System.out.println("Excellent Catch!");
                        if(pokemon.Catch(initialcatchProbapility)){
                            System.out.println("Catch success!");
                            System.out.println();
                            catchPokemonList.add((T) pokemon);
                            break;
                        }
                        else{
                            System.out.println("Catch failure...");
                        }
                    }else if(ball<20){//Great Catch
                        initialcatchProbapility+=5;//捕獲機率+5
                        System.out.println("Great Catch!");
                        if(pokemon.Catch(initialcatchProbapility)){
                            System.out.println("Catch success!");
                            System.out.println();
                            catchPokemonList.add((T) pokemon);
                            break;
                        }
                        else{
                            System.out.println("Catch failure...");
                        }
                    }else{
                        if(pokemon.Catch(initialcatchProbapility)){
                            System.out.println("Catch success!");
                            System.out.println();
                            catchPokemonList.add((T) pokemon);
                            break;
                        }
                        else{
                            System.out.println("Catch failure...");
                        }
                    }

                }else{
                    System.out.println("Runaway...");
                    System.out.println();
                    break;
                }


                boolean fled=pokemon.Runaway(round_number);
                if(fled){
                    System.out.println();
                    break;
                }
                round_number++;
                System.out.println();
            }
        }

        return catchPokemonList;
    }

}
