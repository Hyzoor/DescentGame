package gui.panels.BattlePanels;

import classes.entitys.Entity;
import javax.swing.*;

public class EntityPanel extends JPanel{

    Entity entity;

    public EntityPanel(Entity newEntity){

        entity = newEntity;
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JLabel entityLabel = new JLabel(getEntityImage());





        this.add(entityLabel);
    }

    private ImageIcon getEntityImage(){

        ImageIcon entityImage = new ImageIcon();

        switch(entity.toString()){

            case "KNIGHT":
                return new ImageIcon("src/images/knight.png");

            case "MAGE":
                return new ImageIcon("src/images/mage.png");

            case "ROGUE":
                return new ImageIcon("src/images/rogue.png");

        };

        return null;
    }

}
