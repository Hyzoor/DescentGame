package ui.panels.otherpanels;

import java.awt.*;
import javax.swing.*;

import game.characters.Player;
import ui.buttons.SelectClassButton;

public class PlayerOptionPanel extends JPanel {

    public PlayerOptionPanel(Player classOption) {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(new SelectClassButton(classOption.toString()), BorderLayout.CENTER);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(200, 10, 10, 10));
        buttonPanel.setOpaque(false);

        this.setLayout(new GridLayout(2, 1, 10, 10));
        this.add(new EntityPanel(classOption));
        this.add((buttonPanel));
        this.setOpaque(false);

    }
}
