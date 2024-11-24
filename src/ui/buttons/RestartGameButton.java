package ui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.BattleCounter;
import game.Game;
import game.characters.Player;
import ui.PanelManager;

public class RestartGameButton extends JButton implements ActionListener {

    public RestartGameButton() {
        this.addActionListener(this);
        this.setText("Restart to Try Again");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        BattleCounter.reset();
        String actualPlayerClass = Game.instance.getPlayer().toString();
        Game.instance.setPlayer(new Player(actualPlayerClass));
        Game.instance.createBattle();
        PanelManager.changeToBattlePanel();
    }
}
