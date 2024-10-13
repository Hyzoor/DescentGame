package gui.buttons;

import classes.Game;
import classes.PanelManager;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PowerUpButton extends JButton implements ActionListener {


    private final String statToIncrease;

    public PowerUpButton(String newStatToIncrease) {
        statToIncrease = newStatToIncrease.toLowerCase();
        this.setText("Get 25% more " + statToIncrease);
        this.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        int actualValue = Game.instance.getPlayer().getStats().get(statToIncrease);
        int valueToAdd = (int) (actualValue * 0.25);
        Game.instance.getPlayer().increaseStat(statToIncrease, valueToAdd);
        PanelManager.getBattlePanel().getButtonsAfterWinPanel().enablePowerUpButtons(false);
    }
}
