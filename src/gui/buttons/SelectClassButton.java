package gui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.Game;
import classes.PanelManager;
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
        Game.instance.createBattle();
        PanelManager.changeToBattlePanel();
    }
}
