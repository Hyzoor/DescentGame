package ui.panels.otherpanels;

import javax.swing.*;
import java.awt.*;

import game.Game;
import game.characters.Attack;
import game.characters.Player;
import ui.buttons.AttackButton;

/**
 * Represents the panel that contains buttons for the player's attack actions.
 * Each attack button allows the player to perform a specific attack during the battle.
 */
public class AttackButtonsPanel extends JPanel {

    /**
     * Creates a new AttackButtonsPanel and initializes it with attack buttons.
     * The buttons correspond to the player's available attacks.
     */
    public AttackButtonsPanel() {
        this.setLayout(new GridLayout(2, 2, 10, 10)); // Layout for the buttons
        this.setOpaque(false); // Set the panel to be transparent

        // Add the attack buttons to the panel
        addAttackButtons();
    }

    /**
     * Enables or disables all the buttons in the panel.
     *
     * @param option true to enable the buttons, false to disable them.
     */
    public void enableButtons(boolean option) {
        for (Component button : this.getComponents()) {
            button.setEnabled(option);
        }
    }

    /**
     * Adds buttons for each attack available to the player.
     * Each attack is represented by an AttackButton.
     */
    private void addAttackButtons() {
        Player player = Game.getInstance().getPlayer();

        for (Attack attack : player.getAttackList()) {
            this.add(new AttackButton(attack));
        }
    }
}
