package classes;

import classes.entitys.Enemy;
import classes.entitys.Knight;
import gui.GUI;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {


        Knight knight1 = new Knight();
        Enemy enemigo1 = new Enemy();


        Battle battle = new Battle(knight1, enemigo1);


        SwingUtilities.invokeLater(() -> {
            GUI.createFrame();
        });


        battle.start();
    }
}
