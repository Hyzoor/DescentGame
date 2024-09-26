package gui.buttons;
import classes.Battle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AttackButton extends JButton implements ActionListener{

    private final int numberOfAttackAssociated;

    public AttackButton(int newAttackAssociated){
        numberOfAttackAssociated = newAttackAssociated;
        super.setText(Battle.instance.getPlayer().getAttackList().get(numberOfAttackAssociated).getName());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.print(super.getText());
        System.out.println();
        Battle.instance.performPlayerAttack(Battle.instance.getEnemy(), numberOfAttackAssociated);
        Battle.instance.getEnemy().showHealth();
        System.out.println();

    }
}
