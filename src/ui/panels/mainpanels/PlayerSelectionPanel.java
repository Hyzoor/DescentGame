package ui.panels.mainpanels;

import java.awt.*;
import javax.swing.*;

import classes.characters.Player;
import ui.panels.otherpanels.PlayerOptionPanel;

public class PlayerSelectionPanel extends JPanel {

    public PlayerSelectionPanel() {

        this.setLayout(new GridLayout(2, 3, 10, 10));

        this.add(new PlayerOptionPanel(new Player("Rogue")));
        this.add(new PlayerOptionPanel(new Player("Mage")));
        this.add(new PlayerOptionPanel(new Player("Knight")));
    }
}
