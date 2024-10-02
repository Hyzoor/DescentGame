package gui.panels.ClassSelectionPanels;

import classes.entitys.Player;
import gui.buttons.SelectClassButton;
import gui.panels.EntityPanel;

import javax.swing.*;
import java.awt.*;

public class ClassOptionPanel extends JPanel {


    public ClassOptionPanel(Player classOption) {

        JPanel buttonSelectClass = new JPanel();
        buttonSelectClass.add(new SelectClassButton(classOption));
        buttonSelectClass.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        this.setLayout(new BorderLayout());
        this.add(buttonSelectClass, BorderLayout.SOUTH);
        this.add(new EntityPanel(classOption),BorderLayout.CENTER);

    }
}
