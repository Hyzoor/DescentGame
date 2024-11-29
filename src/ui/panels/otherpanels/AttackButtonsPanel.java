package ui.panels.otherpanels;

import javax.swing.*;
import java.awt.*;

import game.Game;
import game.characters.Attack;
import game.characters.Player;
import ui.buttons.AttackButton;

public class AttackButtonsPanel extends JPanel {


    public AttackButtonsPanel() {
        this.setLayout(new GridLayout(2, 2, 10, 10));
        this.setOpaque(false);

        addAttackButtons();
    }


    //Methods
    public void enableButtons(boolean option) {
        for (Component button : this.getComponents()) {
            button.setEnabled(option);
        }
    }

    private void addAttackButtons() {
        Player player = Game.getInstance().getPlayer();

        for (Attack attack : player.getAttackList()) {
            this.add(new AttackButton(attack));
        }
    }

}
