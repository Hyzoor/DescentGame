package ui.panels.mainpanels;

import java.awt.*;
import javax.swing.*;

import game.characters.Player;
import ui.panels.otherpanels.PlayerOptionPanel;

public class PlayerSelectionPanel extends JPanel {

    private final Image background;

    public PlayerSelectionPanel() {

        background = new ImageIcon("src/resources/images/combat-background.jpg").getImage();

        this.setLayout(new GridLayout(1, 3, 20, 20));
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        this.add(new PlayerOptionPanel(new Player("Rogue")));
        this.add(new PlayerOptionPanel(new Player("Mage")));
        this.add(new PlayerOptionPanel(new Player("Knight")));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
