package ui.panels.otherpanels;

import javax.swing.*;
import java.awt.*;

import ui.buttons.AttackButton;

public class AttackButtonsPanel extends JPanel {


    public AttackButtonsPanel() {
        this.setLayout(new GridLayout(2, 2, 10, 10));
        this.add(new AttackButton(0));
        this.add(new AttackButton(1));
        this.add(new AttackButton(2));
        this.add(new AttackButton(3));
        this.setOpaque(false);
    }


    //Methods
    public void enableButtons(boolean option){
        for(Component button: this.getComponents()){
                button.setEnabled(option);
        }
    }

}
