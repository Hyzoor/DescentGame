package gui.buttons;

import javax.swing.*;
import java.awt.event.*;

import classes.Game;
import classes.PanelManager;


public class AttackButton extends JButton implements ActionListener {

    private final int attackAssociated;

    //Constructor
    public AttackButton(int newAttackAssociated) {
        attackAssociated = newAttackAssociated;
        super.setText(Game.instance.getBattle().getPlayer().getAttackList().get(attackAssociated).getName());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Game.instance.getBattle().performPlayerAttack(attackAssociated);

        PanelManager.getBattlePanel().enablePlayerButtons(false);
        PanelManager.getBattlePanel().clearText();
        PanelManager.getBattlePanel().addText(
                String.format("%s has used %s. %s health: %d",
                        Game.instance.getBattle().getPlayer().toString(),
                        Game.instance.getBattle().getPlayer().getAttackList().get(attackAssociated).getName(),
                        Game.instance.getBattle().getEnemy().toString(),
                        Game.instance.getBattle().getEnemy().getHealth()
                )
        );

        Game.instance.getBattle().rotate();
    }
}
