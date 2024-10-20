package ui.panels.otherpanels;

import java.awt.*;
import javax.swing.*;

import classes.characters.Player;
import ui.buttons.SelectClassButton;

public class PlayerOptionPanel extends JPanel {

    public PlayerOptionPanel(Player classOption) {

        JPanel buttonSelectClass = new JPanel();
        buttonSelectClass.setLayout(new GridLayout(2,1));
        buttonSelectClass.add(new SelectClassButton(classOption));
        buttonSelectClass.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10 ));

        this.setLayout(new BorderLayout());
        this.add(new EntityPanel(classOption), BorderLayout.CENTER);
        this.add((buttonSelectClass), BorderLayout.SOUTH);
    }
}