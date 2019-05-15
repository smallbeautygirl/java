package myjava.homework;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class HW6_main {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String role;//角色
        while (true) {
            try {
                System.out.println("(1) Pikachu (2) Bulbasaur (3) Charizard");
                System.out.print("Choose your pokemon (By default (1)) :");

                role = keyboard.next();//select which pokemon you want
                Pokemon pokemon = Select_Pokemon(role);
                WildPokemon wildPokemon = new WildPokemon();
                System.out.println("[Wild pokemon appeared!]");

                while (true) {
                    try {
                        //check if Hp is <0 ,if Hp<0 then set Hp to 0
                        if (pokemon.getHp() < 0) {
                            pokemon.setHp(0);
                        }
                        if (wildPokemon.getHp() < 0) {
                            wildPokemon.setHp(0);
                        }
                        System.out.println("----Pokemon----        ---Wild Pokemon---");
                        System.out.println("  HP:" + pokemon.getHp() + "          HP: " + wildPokemon.getHp());
                        System.out.println("  ATK:" + pokemon.getAtk() + "          ATK: " + wildPokemon.getAtk());
                        System.out.println("  " + pokemon.getUnique_name() + ":" + pokemon.getUnique());
                        System.out.println("-----------------          -------------------");

                        //check if the hp of pokemon or wildpoken zero
                        if (pokemon.getHp() == 0) {
                            System.out.println("You dead.");
                            return;
                        } else if (wildPokemon.getHp() == 0) {
                            System.out.println("You win.");
                            return;
                        }

                        //do the action
                        int action_wildHp;//動作的wildpokemon Hp
                        action_wildHp = pokemon.action(wildPokemon.getAtk(), wildPokemon.getHp());
                        wildPokemon.setHp(wildPokemon.getHp() - action_wildHp);//set

                    } catch (Exception e) {
                        System.out.println("[catch]: Throw the Poke Ball");
                        double probability = ((double) wildPokemon.getInitalHp() - (double) wildPokemon.getHp()) / (double) wildPokemon.getInitalHp();
                        Random random = new Random();
                        double OK_probability = (random.nextInt(101) / 100.0);

                        if (probability >= OK_probability) {
                            System.out.println("-----------------          -------------------");
                            System.out.println("you caught the wild pokemon");
                            return;
                        } else {
                            System.out.println("you did not catch the wild pokemon");
                            System.out.println("[Wild Pokemon]: "+wildPokemon.getAtk()+" damage");

                            if(pokemon.getClassName().equals("Pikachu")){

                                double EVAprobability=random.nextInt(101) / 100.0;

                                double threshold = random.nextInt(101)/100.0;
                                //判斷是否能迴避 wildpokemon atk
                                if (pokemon.getUnique() >= wildPokemon.getAtk()) {
                                    if(EVAprobability>threshold){
                                        System.out.println("Evasion Succeed");
                                        pokemon.setUnique(pokemon.getUnique()-wildPokemon.getAtk());//set 後來的EVA
                                    }
                                    else{
                                        System.out.println("[Pikachu]: HP -" + wildPokemon.getAtk() + " points");
                                        int temp;
                                        temp = pokemon.getHp() - wildPokemon.getAtk();
                                        pokemon.setHp(temp);
                                    }
                                } else {
                                    System.out.println("[Pikachu]: HP -" + wildPokemon.getAtk() + " points");
                                    int temp;
                                    temp = pokemon.getHp() - wildPokemon.getAtk();
                                    pokemon.setHp(temp);
                                }
                            }
                            else if(pokemon.getClassName().equals("Bulbasaur")){
                                //如果wildpokemon 造成的傷害大於LS bulbasaur先把LS扣掉 然後剩下的再從Hp扣
                                if(wildPokemon.getAtk()>pokemon.getUnique()){
                                    int temp;//後來的血量
                                    temp =  pokemon.getHp()- wildPokemon.getAtk()+pokemon.getUnique();
                                    pokemon.setHp(temp);

                                    int substract=wildPokemon.getAtk()-pokemon.getUnique();//實際扣掉的血量
                                    System.out.println("[Light Shield]: Shield -"+pokemon.getUnique()+" damage");
                                    System.out.println("[Bulbasaur]: HP -"+substract+" points");

                                    pokemon.setUnique(0);
                                }else{
                                    pokemon.setUnique(pokemon.getUnique()-wildPokemon.getAtk());
                                    System.out.println("[Lignt Shield]: Shield -"+wildPokemon.getAtk()+" damage");
                                }
                            }else{
                                System.out.println("[Charizard]: HP -"+wildPokemon.getAtk()+" points");
                                pokemon.setHp(pokemon.getHp()-wildPokemon.getAtk());
                            }

                        }
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Input error : ONLY Integers.");
            }

        }
    }

    private static Pokemon Select_Pokemon(String role) throws InputMismatchException {
        if (role.equals("2")) {
            return new Bulbasaur();
        } else if (role.equals("3")) {
            return new Charizard();
        } else {
            return new Pikachu();
        }
    }

}
