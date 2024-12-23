package ui.buttons;

import game.Game;
import game.characters.Player;
import settings.Settings;
import ui.PanelManager;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a button in the UI that grants a power-up to a player's stat when clicked.
 */
public class PowerUpButton extends JButton implements ActionListener {

    private final String statToIncrease;

    /**
     * Constructs a button with the specified stat to increase and adds an action listener to handle button clicks.
     *
     * @param newStatToIncrease The name of the stat to increase (e.g., "health", "strength").
     */
    public PowerUpButton(String newStatToIncrease) {
        statToIncrease = newStatToIncrease.toLowerCase();
        this.setText("Get " + statToIncrease + " power up !");
        this.addActionListener(this);
    }

    /**
     * Increases the player's stat by applying a multiplier from settings and disables the power-up buttons.
     *
     * @param e The action event generated by the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Player player = Game.getInstance().getPlayer();

        double powerUpMultiplier = Settings.getInstance().getMultipliers().get("powerUp");

        int actualValue = player.getStats().get(statToIncrease);
        int newValue = (int) (actualValue * powerUpMultiplier);

        player.setStatValue(statToIncrease, newValue);

        // Disables the power-up buttons after the stat is upgraded
        PanelManager.getBattlePanel().enablePowerUpButtons(false);
    }
}
