package ui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
import game.characters.Player;
import ui.PanelManager;

/**
 * Represents a button in the UI that restarts the game and resets the player's progress when clicked.
 */
public class RestartGameButton extends JButton implements ActionListener {

    /**
     * Constructs a button that resets the game when clicked.
     * Adds an action listener to handle the restart logic.
     */
    public RestartGameButton() {
        this.addActionListener(this);
        this.setText("Restart to Try Again");
    }

    /**
     * Resets the player's stats, battle counter, and creates a new battle when clicked.
     * Also switches the panel to the battle view.
     *
     * @param e The action event generated by the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Reset the player's stats by creating a new player without upgrades
        Player actualPlayer = Game.getInstance().getPlayer();
        Player playerWithoutUpgrades = new Player(actualPlayer.toString());
        Game.getInstance().setPlayer(playerWithoutUpgrades);

        // Reset the battle counter and initiate a new battle
        Game.getInstance().getBattleCounter().reset();
        Game.getInstance().createBattle();

        // Switch the panel to the battle view
        PanelManager.changeToBattle();
    }
}