package ui.panels.otherpanels;

import javax.swing.*;
import java.awt.*;

import game.characters.Enemy;
import game.characters.Entity;
import game.characters.Player;
import settings.Settings;

public class EntityPanel extends JPanel {


    //Constructor
    public EntityPanel(Entity entity) {

        JLabel entityImage = new JLabel(getEntityImage(entity));

        this.setLayout(new GridLayout(1, 1, 0, 0));
        this.add(entityImage);
        this.setOpaque(false);
    }

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
