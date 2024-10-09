package gui;

import javax.swing.*;
import java.awt.*;

import gui.panels.MainPanels.BattlePanel;
import gui.panels.MainPanels.PlayerSelectionPanel;
import gui.panels.MainPanels.TitleScreen;

public class MainFrame extends JFrame {

    // Attributes - Panels
    private final TitleScreen titleScreen = new TitleScreen(this);
    private final PlayerSelectionPanel playerSelectionPanel = new PlayerSelectionPanel();
    private BattlePanel battlePanel;

    // Constructor
    public MainFrame() {

        this.setTitle("The Descent - RogueLike Game");
        this.setSize(600, 450);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.add(titleScreen, BorderLayout.CENTER);

        this.setVisible(true);
    }

    // Methods
    public void changeToClassSelectionPanel() {
        this.remove(titleScreen);
        this.add(playerSelectionPanel, BorderLayout.CENTER);
        this.repaint();
        this.revalidate();
    }

    public void changeToBattlePanel() {
        this.remove(playerSelectionPanel);
        battlePanel = new BattlePanel();
        this.add(battlePanel);
        this.repaint();
        this.revalidate();
    }

    // Setters and Getters
    public BattlePanel getBattlePanel() {
        return battlePanel;
    }
}

