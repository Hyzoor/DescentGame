package gui.panels.MainPanels;

import javax.swing.*;
import java.awt.*;

import gui.buttons.TitleScreenStartButton;

public class TitleScreenPanel extends JPanel {

    public TitleScreenPanel() {

        JLabel titleLabel = new JLabel();
        titleLabel.setIcon(new ImageIcon("src/resources/images/title.png"));

        this.setLayout(new BorderLayout());
        this.add(titleLabel, BorderLayout.CENTER);
        this.add(new TitleScreenStartButton(), BorderLayout.SOUTH);

    }
}
