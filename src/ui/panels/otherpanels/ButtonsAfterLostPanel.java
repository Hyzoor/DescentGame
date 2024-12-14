package ui.panels.otherpanels;

import ui.buttons.ChangeClassButton;
import ui.buttons.RestartGameButton;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the panel that is displayed after the player loses a battle.
 * It contains buttons that allow the player to either restart the game or change their class.
 */
public class ButtonsAfterLostPanel extends JPanel {

    /**
     * Creates a new ButtonsAfterLostPanel and initializes it with the buttons for restarting the game and changing class.
     */
    public ButtonsAfterLostPanel() {
        this.setLayout(new GridLayout(1, 2, 10, 10)); // Layout for the buttons in one row with two columns
        this.add(new RestartGameButton()); // Add button to restart the game
        this.add(new ChangeClassButton()); // Add button to change player class
        this.setOpaque(false); // Set the panel to be transparent
    }
}
