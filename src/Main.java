import classes.Battle;
import classes.entitys.Enemy;
import classes.entitys.Knight;
import gui.GUI;

public class Main {
    public static void main(String[] args){


        Knight knight1 = new Knight();
        Enemy enemy1 = new Enemy();

        Battle battle = new Battle(knight1, enemy1);
        battle.start();


        GUI.createFrame();

    }

}
