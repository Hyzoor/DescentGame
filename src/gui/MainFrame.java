package gui;

import gui.panels.BattlePanels.BattlePanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {

        this.setTitle("The Descent - RogueLike Game");
        this.setSize(600, 450);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());



        this.add(new BattlePanel());
        this.setVisible(true);
    }
}
