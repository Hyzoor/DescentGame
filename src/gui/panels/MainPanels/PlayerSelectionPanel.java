package gui.panels.MainPanels;

import java.awt.*;
import javax.swing.*;

import classes.entities.Player;
import gui.panels.OtherPanels.PlayerOptionPanel;

public class PlayerSelectionPanel extends JPanel {

    public PlayerSelectionPanel() {

        this.setLayout(new GridLayout(1, 3, 10, 10));

        this.add(new PlayerOptionPanel(new Player("Rogue")));
        this.add(new PlayerOptionPanel(new Player("Mage")));
        this.add(new PlayerOptionPanel(new Player("Knight")));
    }
}
