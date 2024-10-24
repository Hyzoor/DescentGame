package ui.buttons;

import game.Game;
import ui.PanelManager;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PowerUpButton extends JButton implements ActionListener {


    private final String statToIncrease;

    public PowerUpButton(String newStatToIncrease) {
        statToIncrease = newStatToIncrease.toLowerCase();
        this.setText("Get 15% more " + statToIncrease);
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        int actualValue = Game.instance.getPlayer().getStats().get(statToIncrease);
        Game.instance.getPlayer().setStatValue(statToIncrease, (int) (actualValue * 1.15));

        PanelManager.getBattlePanel().getButtonsAfterWinPanel().enablePowerUpButtons(false);
    }
}
