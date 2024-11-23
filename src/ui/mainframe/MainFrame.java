package ui.mainframe;

import javax.swing.*;
import java.awt.*;

import ui.PanelManager;

public class MainFrame extends JFrame {

    // Constructor
    public MainFrame() {

        this.setTitle("The Descent - RogueLike Game");
        this.setSize(1200, 750);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);

        this.add(PanelManager.getTitleScreenPanel());

        this.setVisible(true);
    }

}

