package ui.panels.otherpanels;

import javax.swing.*;
import java.awt.*;

import game.characters.Enemy;
import game.characters.Entity;
import game.characters.Player;
import settings.Settings;

/**
 * Represents a panel that displays an entity (player or enemy) with their respective image.
 * This panel is used to display either the player's or enemy's sprite in the battle UI.
 */
public class EntityPanel extends JPanel {

    /**
     * Constructor to create an EntityPanel that displays the image of the provided entity.
     *
     * @param entity The entity (player or enemy) whose image will be displayed.
     */
    public EntityPanel(Entity entity) {

        JLabel entityImage = new JLabel(getEntityImage(entity));

        this.setLayout(new GridLayout(1, 1, 0, 0));
        this.add(entityImage);
        this.setOpaque(false);
    }

    /**
     * Returns the image icon for the given entity (player or enemy).
     *
     * @param entity The entity whose image is to be retrieved.
     * @return An ImageIcon representing the entity's sprite.
     */
    private ImageIcon getEntityImage(Entity entity) {

        String playersSpritesDirectory = Settings.getInstance().getFilePaths().get("playersSprites");
        String enemiesSpritesDirectory = Settings.getInstance().getFilePaths().get("enemiesSprites");


        if (entity instanceof Enemy) {
            return new ImageIcon(enemiesSpritesDirectory + entity.toString().toLowerCase() + ".png");
        } else if (entity instanceof Player) {
            return new ImageIcon(playersSpritesDirectory + entity.toString().toLowerCase() + ".png");
        }

        return null;
    }
}
