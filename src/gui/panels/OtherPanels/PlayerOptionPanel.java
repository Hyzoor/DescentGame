package gui.panels.OtherPanels;

import java.awt.*;
import javax.swing.*;

import classes.entities.Player;
import gui.buttons.SelectClassButton;

public class PlayerOptionPanel extends JPanel {

    public PlayerOptionPanel(Player classOption) {

        JPanel buttonSelectClass = new JPanel();
        buttonSelectClass.add(new SelectClassButton(classOption));
        buttonSelectClass.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        this.setLayout(new BorderLayout());
        this.add(buttonSelectClass, BorderLayout.SOUTH);
        this.add(new EntityPanel(classOption), BorderLayout.CENTER);
    }
}
