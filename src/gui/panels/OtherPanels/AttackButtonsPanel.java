package gui.panels.OtherPanels;

import javax.swing.*;
import java.awt.*;

import gui.buttons.AttackButton;

public class AttackButtonsPanel extends JPanel {


    public AttackButtonsPanel() {
        this.setLayout(new GridLayout(2, 2, 10, 10));
        this.add(new AttackButton(0));
        this.add(new AttackButton(1));
        this.add(new AttackButton(2));
        this.add(new AttackButton(3));
    }


    //Methods
    public void enableButtons(boolean option){
        for(Component button: this.getComponents()){
                button.setEnabled(option);
        }
    }

}
