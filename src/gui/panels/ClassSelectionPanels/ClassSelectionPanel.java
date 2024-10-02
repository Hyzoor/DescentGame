package gui.panels.ClassSelectionPanels;

import classes.entitys.Knight;
import classes.entitys.Mage;
import classes.entitys.Rogue;
import gui.panels.EntityPanel;

import javax.swing.*;
import java.awt.*;

public class ClassSelectionPanel extends JPanel {

    public ClassSelectionPanel(){

        this.setLayout(new GridLayout(1,3,20,20));

        this.add(new ClassOptionPanel(new Rogue()));
        this.add(new ClassOptionPanel(new Mage()));
        this.add(new ClassOptionPanel(new Knight()));
    }

}
