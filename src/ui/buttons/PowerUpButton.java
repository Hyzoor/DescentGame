package ui.buttons;

import game.Game;
import game.characters.Player;
import settings.Settings;
import ui.PanelManager;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PowerUpButton extends JButton implements ActionListener {


    private final String statToIncrease;

    public PowerUpButton(String newStatToIncrease) {
        statToIncrease = newStatToIncrease.toLowerCase();
        this.setText("Get " + statToIncrease + " power up !");
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Player player = Game.getInstance().getPlayer();

        double powerUpMultiplier = Settings.getInstance().getMultipliers().get("powerUp");

        int actualValue = player.getStats().get(statToIncrease);
        int newValue = (int) (actualValue * powerUpMultiplier);

        player.setStatValue(statToIncrease, newValue);


        PanelManager.getBattlePanel().enablePowerUpButtons(false);
    }
}
