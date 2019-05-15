package myjava.homework;

import java.util.Random;
import java.util.Scanner;

public class Charizard extends Pokemon {
    public Charizard() {
        super(200, 60, 30,"CRI","Charizard");
    }

    public int attack_skill() {
        Random random = new Random();
        int damage = random.nextInt(11) + this.getAtk();//bound =((ATK+10)-ATK)+1
        //if CRI等於100%時 ATK = 2*ATK
        if(this.getUnique()==100){
            damage = 2*this.getAtk();
        }
        this.setAtk(damage);
        return damage;
    }

    public int defense_skill() {
        return 0;
    }

    public int buff_skill() {
        int temp;
        temp=this.getUnique()+25;
        if(temp>100){
            temp=100;
        }
        return temp;
    }

    public int action(int wildAtk,int wildHp) throws Exception{
        System.out.println("(1)Flamethrower   (2)Parry   (3)Work Up   (4)Catch");
        System.out.print("Action: (By default: (1))");
        Scanner keyboard = new Scanner(System.in);
        String option = keyboard.next();

        int attack=0,defense=0,buff=0;

        if (option.equals("2")) {//Parry(格擋) ：反彈敵方傷害。

            System.out.println("[Parry]: return next damage");
            System.out.println("[Wild Pokemon]: " + wildAtk + " damage");
            System.out.println("[Charizard]: HP - "+wildAtk+" points");

            this.setHp(this.getHp()-wildAtk);//自己也會受到傷害
            wildHp = wildHp - wildAtk;
            return wildAtk;

        } else if (option.equals("3")) {//Work Up(自我激勵) ： CRI + 25%，上限 100%。
            buff = buff_skill();
            System.out.println("[Work Up]: CRI "+buff+"%");
            System.out.println("[Wild Pokemon]: " + wildAtk + " damage");
            System.out.println("[Charizard]: HP -"+wildAtk+" points");

            this.setHp(this.getHp()-wildAtk);

            this.setUnique(buff);

            //爆擊時傷害*2
            if(this.getUnique()==100){
                this.setAtk(this.getAtk()*2);
            }

            return 0;
        } else if (option.equals("4")) {
            throw new Exception("");
        } else {//Flamethrower(噴射火焰) ：產生 ATK ~ (ATK + 10)的傷害，爆擊時傷害*2
            attack = this.attack_skill();
            System.out.println("[Flamethrower]: "+attack+" damage");
            System.out.println("[Wild Pokemon]: " + wildAtk + " damage");
            System.out.println("[Charizard]: HP -"+wildAtk+" points");

            this.setHp(this.getHp()-wildAtk);
            return attack;
        }
    }

}
