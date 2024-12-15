package ui.panels.mainpanels;

import java.awt.*;
import javax.swing.*;

import game.characters.Player;
import settings.Settings;
import ui.panels.otherpanels.PlayerOptionPanel;

/**
 * Represents the player selection panel in the game interface.
 *
 * This panel displays the available player options (Rogue, Mage, and Knight),
 * allowing the player to choose their character.
 */
public class PlayerSelectionPanel extends JPanel {

    /**
     * Background image for the player selection panel.
     */
    private final Image background;

    /**
     * Creates a new PlayerSelectionPanel with the available player options.
     */
    public PlayerSelectionPanel() {

        // Retrieve the image path from settings
        String imagesPath = Settings.getInstance().getFilePaths().get("images");

        ImageIcon imageIcon = new ImageIcon(imagesPath + "combat-background.jpg");
        background = imageIcon.getImage();

        // Set layout and add player options
        this.setLayout(new GridLayout(1, 3, 20, 20));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(new PlayerOptionPanel(new Player("Rogue")));
        this.add(new PlayerOptionPanel(new Player("Mage")));
        this.add(new PlayerOptionPanel(new Player("Knight")));
    }

    /**
     * Paints the background of the panel.
     *
     * @param g Graphics object used for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
