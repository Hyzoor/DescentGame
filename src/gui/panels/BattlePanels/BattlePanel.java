package gui.panels.BattlePanels;

import classes.Battle;

import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel {

    public BattlePanel(){

        this.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,1,20,20));
        southPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        southPanel.add(new BattleLogPanel());
        southPanel.add(new AttackButtonsPanel());

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1,2,30,30));
        northPanel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
        northPanel.add(new EntityPanel(Battle.instance.getPlayer()));
        northPanel.add(new EntityPanel(Battle.instance.getPlayer()));


        this.add(southPanel, BorderLayout.SOUTH);
        this.add(northPanel, BorderLayout.NORTH);

    }


}
