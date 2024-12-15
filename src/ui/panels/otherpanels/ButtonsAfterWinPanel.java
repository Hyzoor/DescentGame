package ui.panels.otherpanels;

import ui.buttons.NextBattleButton;
import ui.buttons.PowerUpButton;

import javax.swing.JPanel;
import java.awt.*;

/**
 * Represents the panel displayed after the player wins a battle.
 * It contains buttons for powering up player stats and proceeding to the next battle.
 */
public class ButtonsAfterWinPanel extends JPanel {

    /**
     * Creates a new ButtonsAfterWinPanel and initializes it with buttons to power up player stats and proceed to the next battle.
     */
    public ButtonsAfterWinPanel() {
        this.setLayout(new GridLayout(2, 2, 10, 10));
        this.add(new PowerUpButton("health"));
        this.add(new PowerUpButton("strength"));
        this.add(new PowerUpButton("defense"));
        this.add(new NextBattleButton());
        this.setOpaque(false);
    }

    /**
     * Enables or disables the power-up buttons.
     *
     * @param option true to enable, false to disable the power-up buttons.
     */
    public void enablePowerUpButtons(boolean option) {
        for (Component button : this.getComponents()) {
            if (!(button instanceof PowerUpButton)) {
                continue;
            }
            button.setEnabled(option);
        }
    }
}
