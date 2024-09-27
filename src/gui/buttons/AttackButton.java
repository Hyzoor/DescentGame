package gui.buttons;

import classes.Battle;
import javax.swing.*;
import java.awt.event.*;

public class AttackButton extends JButton implements ActionListener{

    private final int attackAssociated;

    public AttackButton(int newAttackAssociated){
        attackAssociated = newAttackAssociated;
        super.setText(Battle.instance.getPlayer().getAttackList().get(attackAssociated).getName());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.print(super.getText());
        System.out.println();
        Battle.instance.performPlayerAttack(attackAssociated);

        Battle.instance.getEnemy().showHealth();
        System.out.println();

    }
}
