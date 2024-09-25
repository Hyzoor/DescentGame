package classes;

import classes.entitys.Knight;
import classes.entitys.Mage;
import classes.entitys.Rogue;

public class Main {
    public static void main(String[] args){

        Knight knight1 = new Knight();
        Mage mage1 = new Mage();
        Rogue rogue1 = new Rogue();


        Battle battle = new Battle(knight1, rogue1);
        battle.start();



    }

}
