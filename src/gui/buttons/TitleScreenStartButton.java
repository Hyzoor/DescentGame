package gui.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.Game;
import classes.PanelManager;

public class TitleScreenStartButton extends JButton implements ActionListener {

    //Constructor
    public TitleScreenStartButton(){
        this.addActionListener(this);
        initializeButton();
    }


    //Methods
    private void initializeButton(){
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);

        this.setIcon(new ImageIcon("src/resources/images/start-button.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PanelManager.changeToClassSelectionPanel();
    }
}