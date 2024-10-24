package ui.panels.mainpanels;

import javax.swing.*;
import java.awt.*;

import game.Game;
import ui.panels.otherpanels.AttackButtonsPanel;
import ui.panels.otherpanels.ButtonsAfterWinPanel;
import ui.panels.otherpanels.EntityPanel;

public class BattlePanel extends JPanel {

    //Attributes - Components
    private final JTextArea battleTextArea = new JTextArea();
    private final ButtonsAfterWinPanel buttonsAfterWinPanel = new ButtonsAfterWinPanel();
    private final Image background;
    private final JPanel southPanel = new JPanel();
    private final JPanel northPanel = new JPanel();
    private  AttackButtonsPanel attackButtonsPanel;


    //Constructor
    public BattlePanel() {
        background = new ImageIcon("src/resources/images/combat-background.jpg").getImage();

        this.setLayout(new GridLayout(2, 1, 10, 10));
        initializePanel();
    }


    //Methods
    public void addTurnText(String attacker, String defender, String attack, int defenderHealth) {
        addText(String.format("%s has used %s. %s health: %d", attacker, attack, defender, defenderHealth));
    }

    public void addText(String newText) {
        this.battleTextArea.append(newText);
        this.battleTextArea.append("\n");
    }

    public void clearText() {
        this.battleTextArea.setText("");
    }

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
        //TODO
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }

    //Methods for constructor
    private void initializePanel() {
        battleTextArea.setEditable(false);
        battleTextArea.setCaretPosition(battleTextArea.getDocument().getLength());
        battleTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        northPanel.setLayout(new GridLayout(1, 2, 30, 30));
        northPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
        northPanel.setOpaque(false);

        southPanel.setLayout(new GridLayout(2, 1, 20, 20));
        southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        southPanel.setOpaque(false);
    }

    public void updatePanel() {

        this.southPanel.removeAll();
        this.northPanel.removeAll();

        JScrollPane battleTextPane = new JScrollPane(battleTextArea);
        battleTextPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        battleTextPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        southPanel.add(battleTextPane);
        southPanel.add(attackButtonsPanel = new AttackButtonsPanel());

        northPanel.add(new EntityPanel(Game.instance.getBattle().getPlayer()));
        northPanel.add(new EntityPanel(Game.instance.getBattle().getEnemy()));

        this.add(northPanel);
        this.add(southPanel);
        this.repaint();
        this.revalidate();
    }

    //------------------ GETTERS ------------------//

    public ButtonsAfterWinPanel getButtonsAfterWinPanel() {
        return buttonsAfterWinPanel;
    }

}
