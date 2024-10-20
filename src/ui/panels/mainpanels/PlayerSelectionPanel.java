package ui.panels.mainpanels;

import java.awt.*;
import javax.swing.*;

import classes.characters.Player;
import ui.panels.otherpanels.PlayerOptionPanel;

public class PlayerSelectionPanel extends JPanel {

    public PlayerSelectionPanel() {

        String[] playersAvailable = {"Rogue", "Mage", "Knight"};

        JPanel gridPanel = new JPanel(new GridLayout(1,3,20,20));

        gridPanel.add(new PlayerOptionPanel(new Player("Rogue")));
        gridPanel.add(new PlayerOptionPanel(new Player("Mage")));
        gridPanel.add(new PlayerOptionPanel(new Player("Knight")));

        this.setLayout(new BorderLayout());
        this.add(gridPanel, BorderLayout.CENTER);
    }
}
