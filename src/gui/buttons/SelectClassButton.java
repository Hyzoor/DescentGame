package gui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.Battle;
import classes.Game;
import classes.PanelManager;
import classes.entities.Enemy;
import classes.entities.Player;

public class SelectClassButton extends JButton implements ActionListener {

    Player classToSelect;

    //Constructor
    public SelectClassButton(Player newClassToSelect) {
        classToSelect = newClassToSelect;
        this.setText("Select " + classToSelect.toString());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Game.instance.setPlayer(classToSelect);

        //TODO BIEN
        Game.instance.setBattle(new Battle(classToSelect, new Enemy("Default")));
        PanelManager.changeToBattlePanel();
        //TODO BIEN
    }
}
