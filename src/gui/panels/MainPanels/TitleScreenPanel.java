package gui.panels.MainPanels;

import javax.swing.*;
import java.awt.*;

import gui.buttons.TitleScreenStartButton;

public class TitleScreenPanel extends JPanel {

    public TitleScreenPanel() {

        JLabel titleLabel = new JLabel("The Descent", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.NORTH);
        this.add(new TitleScreenStartButton(), BorderLayout.CENTER);

    }
}
