package ui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
import game.characters.Player;

public class NextBattleButton extends JButton implements ActionListener {

    public NextBattleButton() {
        this.setText("Next Battle");
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Player player = Game.getInstance().getPlayer();

        player.restoreHealth();
        Game.getInstance().createBattle();
    }


}
