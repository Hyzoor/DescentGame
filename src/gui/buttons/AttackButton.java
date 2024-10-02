package gui.buttons;

import classes.Battle;
import classes.Game;

import javax.swing.*;
import java.awt.event.*;

public class AttackButton extends JButton implements ActionListener{

    private final int attackAssociated;

    public AttackButton(int newAttackAssociated){
        attackAssociated = newAttackAssociated;
        super.setText(Game.instance.getBattle().getPlayer().getAttackList().get(attackAssociated).getName());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.print(super.getText());
        System.out.println();
        Game.instance.getBattle().performPlayerAttack(attackAssociated);

        Game.instance.getBattle().getEnemy().showHealth();
        System.out.println();

    }
}
