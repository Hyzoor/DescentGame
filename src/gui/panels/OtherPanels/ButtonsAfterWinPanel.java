package gui.panels.OtherPanels;

import gui.buttons.NextBattleButton;
import gui.buttons.PowerUpButton;

import javax.swing.JPanel;
import java.awt.*;

public class ButtonsAfterWinPanel extends JPanel{

    public ButtonsAfterWinPanel(){
        this.setLayout(new GridLayout(2,2,10,10));
        this.add(new PowerUpButton("health"));
        this.add(new PowerUpButton("strength"));
        this.add(new PowerUpButton("defense"));
        this.add(new NextBattleButton());

    }

    public void enablePowerUpButtons(boolean option){
        for(Component button : this.getComponents()){
            if(!(button instanceof PowerUpButton)){
                continue;
            }
            button.setEnabled(option);
        }
    }
}
