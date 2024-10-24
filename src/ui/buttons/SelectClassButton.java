package ui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
import game.enemyfactory.RandomEnemyFactory;
import ui.PanelManager;
import game.characters.Player;

public class SelectClassButton extends JButton implements ActionListener {

    private final String playerIdentifier;

    //Constructor
    public SelectClassButton(String newPlayerIdentifier) {

        playerIdentifier = newPlayerIdentifier;

        this.setText("Select " + playerIdentifier);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Game.instance.setPlayer(new Player(playerIdentifier));
        Game.instance.createBattle(new RandomEnemyFactory());

        PanelManager.changeToBattlePanel();
    }
}
