package gui.panels.OtherPanels;

import javax.swing.*;
import java.awt.*;

import classes.entities.Entity;

public class EntityPanel extends JPanel {

    private final Entity entity;

    //Constructor
    public EntityPanel(Entity newEntity) {

        entity = newEntity;

        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel entityImage = new JLabel(getEntityImage());

        this.add(entityImage, BorderLayout.CENTER);
    }

    private ImageIcon getEntityImage() {

        return switch (entity.toString().toUpperCase()) {
            case "KNIGHT" -> new ImageIcon("src/resources/images/knight.png");
            case "MAGE" -> new ImageIcon("src/resources/images/mage.png");
            case "ROGUE" -> new ImageIcon("src/resources/images/rogue.png");
            case "DEFAULT" -> new ImageIcon("src/resources/images/knight.png");

            default -> null;
        };
    }
}
