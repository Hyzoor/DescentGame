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


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(new SelectClassButton(classOption.toString()), BorderLayout.CENTER);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10));
        buttonPanel.setOpaque(false);


        this.setLayout(new GridLayout(2, 1, 10, 10));
        this.add(new EntityPanel(classOption)); // Add the entity image for the class
        this.add((buttonPanel)); // Add the button panel
        this.setOpaque(false);
    }
}
