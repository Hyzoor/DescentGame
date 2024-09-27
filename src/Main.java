import classes.*;
import classes.entitys.*;
import gui.MainFrame;


public class Main {
    public static void main(String[] args) {

        Knight knight1 = new Knight();
        Mage mage1 = new Mage();
        Rogue rogue1 = new Rogue();
        Enemy enemy1 = new Enemy();

        Battle battle = new Battle(mage1, enemy1);
//        Battle battle = new Battle(knight1, enemy1);


        MainFrame mainFrame = new MainFrame();


        battle.start();

    }
}

