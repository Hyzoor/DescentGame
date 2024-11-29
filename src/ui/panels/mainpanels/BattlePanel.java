package ui.panels.mainpanels;

import javax.swing.*;
import java.awt.*;


import game.Game;
import settings.Settings;
import ui.BattleTextArea;
import ui.panels.otherpanels.AttackButtonsPanel;
import ui.panels.otherpanels.ButtonsAfterLostPanel;
import ui.panels.otherpanels.ButtonsAfterWinPanel;
import ui.panels.otherpanels.EntityPanel;

public class BattlePanel extends JPanel {

    // Attributes - Components
    private final Image background;
    private final JPanel southPanel = new JPanel();
    private final JPanel northPanel = new JPanel();

    private final BattleTextArea battleTextArea = new BattleTextArea();
    private final ButtonsAfterWinPanel buttonsAfterWinPanel = new ButtonsAfterWinPanel();
    private AttackButtonsPanel attackButtonsPanel;

    // Constructor
    public BattlePanel() {

        String imagesPath = Settings.getInstance().getFilePaths().get("images");

        ImageIcon image = new ImageIcon(imagesPath + "combat-background.jpg");
        background = image.getImage();

        initializePanel();
    }


    // Methods
    public void reset(){
        southPanel.removeAll();
        attackButtonsPanel = new AttackButtonsPanel();

        redrawEntities();
        southPanel.add(battleTextArea);
        southPanel.add(attackButtonsPanel);
    }
    public void enableAttackButtons(boolean option) {
        attackButtonsPanel.enableButtons(option);
    }

    public void enablePowerUpButtons(boolean option) {
        buttonsAfterWinPanel.enablePowerUpButtons(option);
    }

    public void addButtonsAfterWinning() {
        enablePowerUpButtons(true);
        southPanel.remove(attackButtonsPanel);
        southPanel.add(buttonsAfterWinPanel);
        redraw();
    }

    public void addButtonsAfterLosing() {
        southPanel.remove(attackButtonsPanel);
        southPanel.add(new ButtonsAfterLostPanel());
        redraw();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }

    private void redrawEntities() {

        northPanel.removeAll();
        northPanel.add(new EntityPanel(Game.getInstance().getBattle().getPlayer()));
        northPanel.add(new EntityPanel(Game.getInstance().getBattle().getEnemy()));

        redraw();
    }

    // Methods for constructor

    private void initializePanel() {

        this.setLayout(new BorderLayout());

        northPanel.setLayout(new GridLayout(1, 2, 30, 30));
        northPanel.setBorder(BorderFactory.createEmptyBorder(100, 20, 100, 20));
        northPanel.setOpaque(false);

        southPanel.setLayout(new GridLayout(2, 1, 20, 20));
        southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        southPanel.setOpaque(false);

        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.CENTER);
    }

    private void redraw(){
        repaint();
        revalidate();
    }



    //------------------ GETTERS ------------------//

    public BattleTextArea getBattleTextArea() {
        return battleTextArea;
    }
}
