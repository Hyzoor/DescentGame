package ui.panels.mainpanels;

import java.awt.*;
import javax.swing.*;

import game.characters.Player;
import settings.Settings;
import ui.panels.otherpanels.PlayerOptionPanel;

public class PlayerSelectionPanel extends JPanel {

    private final Image background;

    public PlayerSelectionPanel() {

        String imagesPath = Settings.getInstance().getFilePaths().get("images");

        ImageIcon imageIcon = new ImageIcon(imagesPath + "combat-background.jpg");
        background = imageIcon.getImage();

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
