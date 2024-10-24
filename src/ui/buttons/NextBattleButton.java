package ui.buttons;

import game.Game;
import game.enemyfactory.RandomEnemyFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NextBattleButton extends JButton implements ActionListener {

    public NextBattleButton() {
        this.setText("Next Battle");
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Game.instance.getPlayer().restoreHealth();
        Game.instance.createBattle(new RandomEnemyFactory());
    }
}
