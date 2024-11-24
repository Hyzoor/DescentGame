package ui.panels.otherpanels;

import ui.buttons.ChangeClassButton;
import ui.buttons.RestartGameButton;

import javax.swing.*;
import java.awt.*;

public class ButtonsAfterLostPanel extends JPanel {
    public ButtonsAfterLostPanel() {
        this.setLayout(new GridLayout(1, 2, 10, 10));
        this.add(new RestartGameButton());
        this.add(new ChangeClassButton());
        this.setOpaque(false);
    }
}
