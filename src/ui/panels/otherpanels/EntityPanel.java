package ui.panels.otherpanels;

import javax.swing.*;
import java.awt.*;

import classes.characters.Entity;

public class EntityPanel extends JPanel {

    private final Entity entity;

    //Constructor
    public EntityPanel(Entity newEntity) {

        entity = newEntity;

        this.setLayout(new BorderLayout());
//        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));

        JLabel entityImage = new JLabel(getEntityImage());

        this.add(entityImage, BorderLayout.CENTER);
    }

    private ImageIcon getEntityImage() {

        return switch (entity.toString().toUpperCase()) {
            case "KNIGHT" -> new ImageIcon("src/resources/images/knight.png");
            case "MAGE" -> new ImageIcon("src/resources/images/mage.png");
            case "ROGUE" -> new ImageIcon("src/resources/images/rogue.png");
            //TODO images for enemies
            case "GOBLIM" -> new ImageIcon("src/resources/images/rogue.png");
            case "SKELETON" -> new ImageIcon("src/resources/images/rogue.png");

            default -> null;
        };
    }
}
