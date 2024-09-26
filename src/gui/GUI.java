package gui;
import classes.Battle;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{

    public static void createFrame(){

        JFrame mainFrame = new JFrame("DESCENT GAME");
        mainFrame.setSize(800,600);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        mainFrame.setLayout(new BorderLayout());

        mainFrame.add(new BattlePanel(), BorderLayout.SOUTH);

        mainFrame.setVisible(true);

    }

}
