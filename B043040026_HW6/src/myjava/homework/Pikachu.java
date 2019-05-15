package myjava.homework;

import java.util.Random;
import java.util.Scanner;

public class Pikachu extends Pokemon {

    public Pikachu() {
        super(80, 40, 20, "EVA","Pikachu");
    }

    public int attack_skill() {
        Random random = new Random();
        int damage = random.nextInt(11) + this.getAtk();//bound =((ATK+10)-ATK)+1
        return damage;
    }

    public int defense_skill() {
        int temp = 2 * this.getUnique();
        if (temp > 200) {
            temp = 200;
        }
        this.setUnique(temp);
        return temp;
    }

    public int buff_skill() {
        int temp = 2 * this.getAtk();
        this.setAtk(temp);
        return temp;
    }


    public int action(int wildAtk, int wildHp) throws Exception {

        System.out.println("(1)Thunder Shock   (2)Double Team   (3)Thunder   (4)Catch");
        System.out.print("Action: (By default: (1))");
        Scanner keyboard = new Scanner(System.in);
        String option = keyboard.next();
        int attack = 0, defense = 0, buff = 0;

        Random random = new Random();
        double EVAprobability=random.nextInt(101) / 100.0;

        double threshold = random.nextInt(101)/100.0;

        if (option.equals("2")) {//Double Team(影子分身)

            defense = this.defense_skill();
            System.out.println("[Double Team]: EVA +" + this.getUnique() / 2 + " points");
            System.out.println("[Wild Pokemon]: " + wildAtk + " damage");

            //判斷是否能迴避 wildATK
            if (this.getUnique() >= wildAtk) {
                if(EVAprobability>threshold){
                    System.out.println("Evasion Succeed");
                    setUnique(getUnique()-wildAtk);//set 後來的EVA
                }
                else{
                    System.out.println("[Pikachu]: HP -" + wildAtk + " points");
                    this.setHp(this.getHp()-wildAtk);
                }
            } else {
                System.out.println("[Pikachu]: HP -" + wildAtk + " points");
                this.setHp(this.getHp()-wildAtk);
            }

            return 0;
        } else if (option.equals("3")) {//Thunder(打雷)

            buff = this.buff_skill();
            System.out.println("[Thunder]: ATK +" + this.getAtk() / 2 + " damage");
            System.out.println("[Wild Pokemon]: " + wildAtk + " damage");

            //判斷是否能迴避 wildATK
            if (this.getUnique() >= wildAtk) {
                if(EVAprobability>threshold){
                    System.out.println("Evasion Succeed");
                    setUnique(getUnique()-wildAtk);//set 後來的EVA
                }
                else{
                    System.out.println("[Pikachu]: HP -" + wildAtk + " points");
                    this.setHp(this.getHp()-wildAtk);
                }
            } else {
                System.out.println("[Pikachu]: HP -" + wildAtk + " points");
                this.setHp(this.getHp()-wildAtk);
            }

            return 0;
        } else if (option.equals("4")) {
            throw new Exception("");
        } else {//Thunder Shock(電擊)

            attack = attack_skill();
            System.out.println("[Thunder Shock]: " + attack + " damage");
            wildHp -= attack;//wildHP 要扣掉 pokemon的攻擊
            if(wildHp<0){
                return attack;
            }
            System.out.println("[Wild Pokemon]: " + wildAtk + " damage");

            //判斷是否能迴避 wildATK
            if (this.getUnique() >= wildAtk) {
                if(EVAprobability>threshold){
                    System.out.println("Evasion Succeed");
                    setUnique(getUnique()-wildAtk);//set 後來的EVA
                }
                else{
                    System.out.println("[Pikachu]: HP -" + wildAtk + " points");
                    this.setHp(this.getHp()-wildAtk);
                }
            } else {
                System.out.println("[Pikachu]: HP -" + wildAtk + " points");
                this.setHp(this.getHp()-wildAtk);
            }


            return attack;
        }
    }
}
