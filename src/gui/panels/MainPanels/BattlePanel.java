package gui.panels.MainPanels;

import javax.swing.*;
import java.awt.*;

import classes.Game;
import gui.panels.OtherPanels.AttackButtonsPanel;
import gui.panels.OtherPanels.EntityPanel;

public class BattlePanel extends JPanel {

    //Attributes - Components
    private final JTextArea battleTextArea = new JTextArea();
    private final JPanel southPanel = new JPanel();
    private final JPanel northPanel = new JPanel();


    //Constructor
    public BattlePanel() {

        this.setLayout(new GridLayout(2, 1, 10, 10));

        initializeTextArea();
        initializePanels();

        this.add(northPanel);
        this.add(southPanel);
    }


    public void addText(String newText) {
        this.battleTextArea.append(newText);
        this.battleTextArea.append("\n");
    }

    public void clearText() {
        this.battleTextArea.setText("");
    }

    private void initializeTextArea() {
        battleTextArea.setEditable(false);
        battleTextArea.setCaretPosition(battleTextArea.getDocument().getLength());
        battleTextArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void initializePanels() {
        JScrollPane battleTextPane = new JScrollPane(battleTextArea);
        battleTextPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        battleTextPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        southPanel.setLayout(new GridLayout(2, 1, 20, 20));
        southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        southPanel.add(battleTextPane);
        southPanel.add(new AttackButtonsPanel());

        northPanel.setLayout(new GridLayout(1, 2, 30, 30));
        northPanel.setBorder(BorderFactory.createEmptyBorder(40, 20, 20, 20));
        northPanel.add(new EntityPanel(Game.instance.getBattle().getPlayer()));
        northPanel.add(new EntityPanel(Game.instance.getBattle().getEnemy()));
    }
}
