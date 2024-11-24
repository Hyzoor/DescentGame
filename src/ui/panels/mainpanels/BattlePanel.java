package ui.panels.mainpanels;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import game.BattleCounter;
import game.Game;
import ui.BattleTextArea;
import ui.panels.otherpanels.AttackButtonsPanel;
import ui.panels.otherpanels.ButtonsAfterLostPanel;
import ui.panels.otherpanels.ButtonsAfterWinPanel;
import ui.panels.otherpanels.EntityPanel;

public class BattlePanel extends JPanel {

    // Attributes - Components
    private final BattleTextArea battleTextArea = new BattleTextArea();
    private final ButtonsAfterWinPanel buttonsAfterWinPanel = new ButtonsAfterWinPanel();
    private AttackButtonsPanel attackButtonsPanel;
    private final Image background;
    private final JPanel southPanel = new JPanel();
    private final JPanel northPanel = new JPanel();

    // Constructor
    public BattlePanel() {
        background = new ImageIcon("src/resources/images/combat-background.jpg").getImage();
        this.setLayout(new BorderLayout());
        initializePanel();
    }

    // Methods

    public void enablePlayerButtons(boolean option) {
        attackButtonsPanel.enableButtons(option);
    }

    public void addButtonsAfterWinning() {
        buttonsAfterWinPanel.enablePowerUpButtons(true);
        southPanel.remove(attackButtonsPanel);
        southPanel.add(buttonsAfterWinPanel);
        this.repaint();
        this.revalidate();
    }

    public void addButtonsAfterLosing() {
        southPanel.remove(attackButtonsPanel);
        southPanel.add(new ButtonsAfterLostPanel());
        this.repaint();
        this.revalidate();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
    // Methods for constructor

    private void initializePanel() {


        northPanel.setLayout(new GridLayout(1, 2, 30, 30));
        northPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 100, 20));
        northPanel.setOpaque(false);

        southPanel.setLayout(new GridLayout(2, 1, 20, 20));
        southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        southPanel.setOpaque(false);
    }

    public void updatePanel() {
        this.southPanel.removeAll();
        this.northPanel.removeAll();

        southPanel.add(battleTextArea);
        southPanel.add(attackButtonsPanel = new AttackButtonsPanel());

        northPanel.add(new EntityPanel(Game.instance.getBattle().getPlayer()));
        northPanel.add(new EntityPanel(Game.instance.getBattle().getEnemy()));

        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.CENTER);
        this.repaint();
        this.revalidate();

    }



    //------------------ GETTERS ------------------//

    public ButtonsAfterWinPanel getButtonsAfterWinPanel() {
        return buttonsAfterWinPanel;
    }

    public BattleTextArea getBattleTextArea(){
        return battleTextArea;
    }
}
