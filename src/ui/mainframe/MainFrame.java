package ui.mainframe;

import javax.swing.*;
import java.awt.*;

import ui.PanelManager;

public class MainFrame extends JFrame {

    // Constructor
    public MainFrame() {

        this.setTitle("The Descent - RogueLike Game");
        this.setSize(800, 600);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(PanelManager.getTitleScreenPanel());

        this.setVisible(true);
    }

}

