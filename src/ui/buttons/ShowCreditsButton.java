package ui.buttons;

import ui.PanelManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowCreditsButton extends JButton implements ActionListener {

    public ShowCreditsButton(){
        this.setText("Show Credits");
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PanelManager.changeToCredits();
    }
}
