package gui.panels.MainPanels;

import javax.swing.*;
import java.awt.*;

import classes.Game;
import gui.panels.OtherPanels.AttackButtonsPanel;
import gui.panels.OtherPanels.ButtonsAfterWinPanel;
import gui.panels.OtherPanels.EntityPanel;

public class BattlePanel extends JPanel {

    //Attributes - Components
    private final JTextArea battleTextArea = new JTextArea();
    private AttackButtonsPanel attackButtonsPanel;
    private final ButtonsAfterWinPanel buttonsAfterWinPanel = new ButtonsAfterWinPanel();
    private final JPanel southPanel = new JPanel();
    private final JPanel northPanel = new JPanel();


    //Constructor
    public BattlePanel() {
        this.setLayout(new GridLayout(2, 1, 10, 10));
        initializePanel();
    }


    public void addText(String newText) {
        this.battleTextArea.append(newText);
        this.battleTextArea.append("\n");
    }

    public void clearText() {
        this.battleTextArea.setText("");
    }

    public void enablePlayerButtons(boolean option){
        attackButtonsPanel.enableButtons(option);
    }

    public void addButtonsAfterWin(){
        buttonsAfterWinPanel.enablePowerUpButtons(true);
        southPanel.remove(attackButtonsPanel);
        southPanel.add(buttonsAfterWinPanel);
        this.repaint();
        this.revalidate();
    }

    //Methods for constructor
    private void initializePanel() {
        battleTextArea.setEditable(false);
        battleTextArea.setCaretPosition(battleTextArea.getDocument().getLength());
        battleTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        northPanel.setLayout(new GridLayout(1, 2, 30, 30));
        northPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));

        southPanel.setLayout(new GridLayout(2, 1, 20, 20));
        southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
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

    public ButtonsAfterWinPanel getButtonsAfterWinPanel(){
        return buttonsAfterWinPanel;
    }

}
