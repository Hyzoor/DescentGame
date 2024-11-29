package ui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.BattleCounter;
import ui.PanelManager;

public class ChangeClassButton extends JButton implements ActionListener {

    public ChangeClassButton(){
        this.addActionListener(this);
        this.setText("Change Class");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BattleCounter.reset();
        PanelManager.changeToPlayerSelection();
    }
}