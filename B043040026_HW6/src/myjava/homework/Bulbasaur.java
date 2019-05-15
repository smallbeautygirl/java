package myjava.homework;

import java.util.Random;
import java.util.Scanner;

public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        super(40, 20, 0, "LS","Bulbasaur");
    }

    public int attack_skill() {
        Random random = new Random();
        return random.nextInt(11)+4*this.getAtk();//bound =((ATK*4+10)-ATK*4)+1
    }

    public int defense_skill() {
        Random random = new Random();
        return random.nextInt(11)+4*this.getAtk();//bound =((ATK*4+10)-ATK*4)+1
    }

    public int buff_skill() {
        Random random = new Random();
        return random.nextInt(11)+2*this.getAtk();//bound =((ATK*2+10)-ATK*2)+1
    }

    public int action(int wildAtk,int wildHp) throws Exception{
        System.out.println("(1)Leaf Razor   (2)Light Shield   (3)Synthesis   (4)Catch");
        System.out.print("Action: (By default: (1))");
        Scanner keyboard = new Scanner(System.in);
        String option = keyboard.next();

        int attack=0,defense=0,buff=0;


        if (option.equals("2")) {//Light Screen(光牆)
            defense = defense_skill();
            this.setUnique(this.getUnique()+defense);

            System.out.println("[Light Shield]: Shield +"+defense+" points");
            System.out.println("[Wild Pokemon]: "+wildAtk+" damage");

            //如果wildpokemon 造成的傷害大於LS bulbasaur先把LS扣掉 然後剩下的再從Hp扣
            if(wildAtk>this.getUnique()){
                int temp;//後來的血量
                temp =  this.getHp()- wildAtk+this.getUnique();
                setHp(temp);

                int substract=wildAtk-this.getUnique();//實際扣掉的血量
                System.out.println("[Light Shield]: Shield -"+getUnique()+" damage");
                System.out.println("[Bulbasaur]: HP -"+substract+" points");

                this.setUnique(0);
            }else{
                this.setUnique(this.getUnique()-wildAtk);
                System.out.println("[Lignt Shield]: Shield -"+wildAtk+" damage");
            }

            return 0;
        } else if (option.equals("3")) {//Synthesis(光合作用)

            buff = buff_skill();
            System.out.println(buff);

            if((buff+this.getHp()-wildAtk)>40){
                //buff+getHp()-wildAtk=40;
                buff = 40-this.getHp()+wildAtk;
                System.out.println("[Synthesis]: HP +"+buff+" points");
            }else{
                System.out.println("[Synthesis]: HP +"+buff+" points");
            }

            System.out.println("[Wild Pokemon]: "+wildAtk+" damage");

            //如果wildpokemon 造成的傷害大於LS bulbasaur先把LS扣掉 然後剩下的再從Hp扣
            if(wildAtk>this.getUnique()){
                int temp;//後來的血量
                temp =  this.getHp()- wildAtk+this.getUnique()+buff;
                setHp(temp);

                int substract=wildAtk-this.getUnique();//實際扣掉的血量
                System.out.println("[Light Shield]: Shield -"+getUnique()+" damage");
                System.out.println("[Bulbasaur]: HP -"+substract+" points");

                this.setUnique(0);
            }else{
                this.setUnique(this.getUnique()-wildAtk);
                System.out.println("[Lignt Shield]: Shield -"+wildAtk+" damage");
                setHp(this.getHp()+buff);
            }

            return 0;
        } else if (option.equals("4")) {
            throw new Exception("");
        } else {//Razor Leaf(飛葉快刀)
            attack = this.attack_skill();
            System.out.println("[Leaf Razor]: "+ attack+" damage");
            wildHp -= attack;//wildHP 要扣掉 pokemon的攻擊
            if(wildHp<0){
                return attack;
            }
            System.out.println("[Wild Pokemon]: "+wildAtk+" damage");

            //如果wildpokemon 造成的傷害大於LS bulbasaur先把LS扣掉 然後剩下的再從Hp扣
            if(wildAtk>this.getUnique()){
                int temp;//後來的血量
                temp =  this.getHp()- wildAtk+this.getUnique();
                setHp(temp);

                int substract=wildAtk-this.getUnique();//實際扣掉的血量
                System.out.println("[Light Shield]: Shield -"+getUnique()+" damage");
                System.out.println("[Bulbasaur]: HP -"+substract+" points");

                this.setUnique(0);
            }else{
                this.setUnique(this.getUnique()-wildAtk);
                System.out.println("[Lignt Shield]: Shield -"+wildAtk+" damage");
            }
            return attack;
        }

    }
}


