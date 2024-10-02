package gui;

import gui.panels.BattlePanels.BattlePanel;
import gui.panels.ClassSelectionPanels.ClassSelectionPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private ClassSelectionPanel classSelectionPanel = new ClassSelectionPanel();
    private BattlePanel battlePanel;

    public MainFrame() {

        this.setTitle("The Descent - RogueLike Game");
        this.setSize(600, 450);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());



        this.add(classSelectionPanel, BorderLayout.CENTER);


        this.setVisible(true);
    }


    public void changeToBattlePanel(){
        this.remove(classSelectionPanel);
        battlePanel = new BattlePanel();
        this.add(battlePanel);
        this.repaint();
        this.revalidate();
    }
}


