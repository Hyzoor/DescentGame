package ui.buttons;

import javax.swing.*;
import java.awt.event.*;

import game.Game;
import ui.PanelManager;


public class AttackButton extends JButton implements ActionListener {

    private final int attackAssociated;

    //Constructor
    public AttackButton(int newAttackAssociated) {
        attackAssociated = newAttackAssociated;
        super.setText(Game.instance.getPlayer().getAttackList().get(attackAssociated).getName());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        PanelManager.getBattlePanel().clearText();
        PanelManager.getBattlePanel().enablePlayerButtons(false);

        Game.instance.getPlayer().performAttackTo(Game.instance.getBattle().getEnemy(), attackAssociated);
        Game.instance.getBattle().rotate();

    }
}
