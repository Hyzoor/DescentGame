package classes;

import classes.entitys.Enemy;
import classes.entitys.Knight;
import classes.entitys.Mage;
import classes.entitys.Rogue;
import gui.BattlePanel;
import gui.GUI;

public class Main {
    public static void main(String[] args){


        Knight knight1 = new Knight();
        Enemy enemigo1 = new Enemy();

        Battle battle = new Battle(knight1, enemigo1);
        battle.start();


        GUI.createFrame();

    }

}
