package ui.panels.otherpanels;

import java.awt.*;
import javax.swing.*;

import game.characters.Player;
import ui.buttons.SelectClassButton;

/**
 * Represents a panel for displaying an option to select a player's class.
 * This panel shows the entity image for the class and a button to select the class.
 */
public class PlayerOptionPanel extends JPanel {

    /**
     * Constructor to create a panel that displays a player's class option.
     *
     * @param classOption The player class (e.g., "Rogue", "Mage", "Knight") to be displayed.
     */
    public PlayerOptionPanel(Player classOption) {

        // Create a button panel to hold the SelectClassButton
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(new SelectClassButton(classOption.toString()), BorderLayout.CENTER); // Add the select button
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10)); // Set a border around the button panel
        buttonPanel.setOpaque(false); // Make the button panel transparent

        // Set the layout for the PlayerOptionPanel
        this.setLayout(new GridLayout(2, 1, 10, 10));
        this.add(new EntityPanel(classOption)); // Add the entity image for the class
        this.add((buttonPanel)); // Add the button panel
        this.setOpaque(false); // Make the PlayerOptionPanel transparent
    }
}
