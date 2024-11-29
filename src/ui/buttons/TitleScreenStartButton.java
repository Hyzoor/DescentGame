package ui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Settings;
import ui.PanelManager;

public class TitleScreenStartButton extends JButton implements ActionListener {

    //Constructor
    public TitleScreenStartButton() {
        this.addActionListener(this);
        initializeButton();
    }


    //Methods
    private void initializeButton() {
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);

        String imagesPath = Settings.getInstance().getFilePaths().get("images");
        this.setIcon(new ImageIcon(imagesPath + "start-button.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        PanelManager.changeToPlayerSelection();
    }
}