package gui.panels;

import gui.buttons.AttackButton;
import javax.swing.*;
import java.awt.*;

public class BattlePanel extends JPanel{

     AttackButton attackButton1, attackButton2, attackButton3;

    public BattlePanel() {

        this.setLayout(new GridLayout(2,2,10,10));

        attackButton1 = new AttackButton(0);
        attackButton1.setBounds(100, 100, 180, 40);

        attackButton2 = new AttackButton(1);
        attackButton2.setBounds(300, 100, 180, 40);

        attackButton3 = new AttackButton(2);
        attackButton3.setBounds(100, 160, 180, 40);

        this.add(attackButton1);
        this.add(attackButton2);
        this.add(attackButton3);

    }
}
