package ui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        Player actualPlayer = Game.getInstance().getPlayer();
        Player playerWithoutUpgrades = new Player(actualPlayer.toString());
        Game.getInstance().setPlayer(playerWithoutUpgrades);

        Game.getInstance().getBattleCounter().reset();
        Game.getInstance().createBattle();
        PanelManager.changeToBattle();
    }
}
