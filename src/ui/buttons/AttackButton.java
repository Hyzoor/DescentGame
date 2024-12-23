package ui.buttons;

import javax.swing.*;
import java.awt.event.*;
import game.Game;
import game.characters.Attack;
import game.characters.Entity;
import ui.PanelManager;

/**
 * Represents a button in the UI that, when clicked, performs an attack on an enemy using an associated Attack instance.
 * @see Attack
 */
public class AttackButton extends JButton implements ActionListener {

    private final Attack attackAssociated;

    /**
     * Constructs a button with an associated attack.
     *
     * @param newAttackAssociated The Attack instance to be executed when the button is pressed.
     */
    public AttackButton(Attack newAttackAssociated) {
        attackAssociated = newAttackAssociated;
        super.setText(attackAssociated.getName());
        this.addActionListener(this);
    }

    /**
     * Action to be performed when the button is clicked. Executes the associated attack and updates the battle UI.
     *
     * @param e The action event generated by the button click.
     */
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
