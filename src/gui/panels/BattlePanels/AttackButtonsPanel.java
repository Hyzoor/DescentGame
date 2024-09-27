package gui.panels.BattlePanels;

import gui.buttons.AttackButton;
import javax.swing.*;
import java.awt.*;

public class AttackButtonsPanel extends JPanel {

    public AttackButtonsPanel() {

        this.setLayout(new GridLayout(2, 2, 10, 10));
        this.add(new AttackButton(0));
        this.add(new AttackButton(1));
        this.add(new AttackButton(2));
        this.add(new AttackButton(3));

    }
}
