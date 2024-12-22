package ui.panels.mainpanels;

import javax.swing.*;
import java.awt.*;

import game.Game;
import settings.Settings;
import ui.BattleTextArea;
import ui.buttons.ShowCreditsButton;
import ui.panels.otherpanels.AttackButtonsPanel;
import ui.panels.otherpanels.ButtonsAfterLostPanel;
import ui.panels.otherpanels.ButtonsAfterWinPanel;
import ui.panels.otherpanels.EntityPanel;

/**
 * Represents the battle panel in the game interface.
 * It manages the layout and interactions of the battle screen, including the display of battle-related text and action buttons.
 */
public class BattlePanel extends JPanel {

    /**
     * Background image for the battle panel.
     */
    private final Image background;

    /**
     * Panel located at the south part of the layout.
     */
    private final JPanel southPanel = new JPanel();

    /**
     * Panel located at the north part of the layout.
     */
    private final JPanel northPanel = new JPanel();

    /**
     * Text area for displaying battle-related messages.
     */
    private final BattleTextArea battleTextArea = new BattleTextArea();

    /**
     * Panel containing buttons for actions after winning a battle.
     */
    private final ButtonsAfterWinPanel buttonsAfterWinPanel = new ButtonsAfterWinPanel();

    /**
     * Panel containing buttons for attack actions.
     */
    private AttackButtonsPanel attackButtonsPanel;

    /**
     * Creates a new BattlePanel with its components initialized, setting the background image.
     */
    public BattlePanel() {
        String imagesPath = Settings.getInstance().getFilePaths().get("images");
        ImageIcon image = new ImageIcon(imagesPath + "combat-background.jpg");
        background = image.getImage();
        initializePanel();
    }

    /**
     * Resets the panel for a new battle, reinitializing the components.
     */
    public void reset() {
        southPanel.removeAll();
        attackButtonsPanel = new AttackButtonsPanel();
        redrawEntities();
        southPanel.add(battleTextArea);
        southPanel.add(attackButtonsPanel);
        battleTextArea.clearText();
    }

    /**
     * Enables or disables the attack buttons based on the provided option.
     *
     * @param option true to enable, false to disable.
     */
    public void enableAttackButtons(boolean option) {
        attackButtonsPanel.enableButtons(option);
    }

    /**
     * Enables or disables the power-up buttons based on the provided option.
     *
     * @param option true to enable, false to disable.
     */
    public void enablePowerUpButtons(boolean option) {
        buttonsAfterWinPanel.enablePowerUpButtons(option);
    }

    /**
     * Adds buttons for actions after winning a battle to the south panel.
     */
    public void addButtonsAfterWinning() {
        enablePowerUpButtons(true);
        southPanel.remove(attackButtonsPanel);
        southPanel.add(buttonsAfterWinPanel);
        redraw();
    }

    /**
     * Adds a button to show credits after the game ends.
     */
    public void addEndGameButtons() {
        southPanel.remove(buttonsAfterWinPanel);
        southPanel.add(new ShowCreditsButton());
    }

    /**
     * Adds buttons for actions after losing a battle to the south panel.
     */
    public void addButtonsAfterLosing() {
        southPanel.remove(attackButtonsPanel);
        southPanel.add(new ButtonsAfterLostPanel());
        redraw();
    }

    /**
     * Paints the background of the panel.
     *
     * @param g Graphics object used for painting.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }

    /**
     * Redraws the player and enemy entities on the panel.
     */
    private void redrawEntities() {
        northPanel.removeAll();
        northPanel.add(new EntityPanel(Game.getInstance().getBattle().getPlayer()));
        northPanel.add(new EntityPanel(Game.getInstance().getBattle().getEnemy()));
        redraw();
    }

    /**
     * Initializes the layout and components of the panel.
     */
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

    /**
     * Redraws the panel, updating its components.
     */
    private void redraw() {
        repaint();
        revalidate();
    }

    //------------------ GETTERS ------------------//

    /**
     * Gets the battle text area.
     *
     * @return the battle text area.
     */
    public BattleTextArea getBattleTextArea() {
        return battleTextArea;
    }
}
