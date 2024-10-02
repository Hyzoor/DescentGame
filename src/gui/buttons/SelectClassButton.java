package gui.buttons;

import classes.Battle;
import classes.Game;
import classes.entitys.Enemy;
import classes.entitys.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectClassButton extends JButton implements ActionListener {

    Player classToSelect;

    public SelectClassButton(Player newClassToSelect){
        classToSelect = newClassToSelect;
        this.setText("SELECT " + classToSelect.toString());
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e){

        Game.instance.setPlayer(classToSelect);
        Game.instance.setBattle(new Battle(classToSelect, new Enemy()));
        Game.instance.getMainFrame().changeToBattlePanel();


        //TODO BIEN
    }
}
