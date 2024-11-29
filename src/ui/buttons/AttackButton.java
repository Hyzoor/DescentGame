package ui.buttons;

import javax.swing.*;
import java.awt.event.*;

import game.Game;
import game.characters.Attack;
import game.characters.Entity;
import ui.PanelManager;


public class AttackButton extends JButton implements ActionListener {

    private final Attack attackAssociated;

    //Constructor
    public AttackButton(Attack newAttackAssociated) {
        attackAssociated = newAttackAssociated;
        super.setText(attackAssociated.getName());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        PanelManager.getBattlePanel().getBattleTextArea().clearText();
        PanelManager.getBattlePanel().enableAttackButtons(false);


        Entity enemy = Game.getInstance().getEnemy();
        Entity player = Game.getInstance().getPlayer();

        player.performAttackTo(enemy, attackAssociated);

        Game.getInstance().getBattle().rotate();

    }
}
