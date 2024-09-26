package gui;
import classes.Battle;

import javax.swing.*;

public class GUI extends JFrame{

    public static void createFrame(){

        JFrame mainFrame = new JFrame("DESCENT GAME");
        mainFrame.setSize(800,600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.add(new BattlePanel());


//        mainFrame.setLayout(null);
        mainFrame.setVisible(true);

    }

}
