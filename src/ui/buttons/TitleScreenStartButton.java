package ui.buttons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import settings.Settings;
import ui.PanelManager;

/**
 * Represents the "Start" button on the title screen.
 * When clicked, it transitions the UI to the player selection screen.
 */
public class TitleScreenStartButton extends JButton implements ActionListener {

    /**
     * Constructs the "Start" button.
     * It sets the button's action listener and initializes the button's appearance.
     */
    public TitleScreenStartButton() {
        this.addActionListener(this);
        initializeButton();
    }

    /**
     * Initializes the button's appearance by removing borders and setting an icon.
     * The icon is loaded from the settings' images path.
     */
    private void initializeButton() {

        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);

        // Load the image icon for the button from the images path
        String imagesPath = Settings.getInstance().getFilePaths().get("images");
        this.setIcon(new ImageIcon(imagesPath + "start-button.png"));
    }

    /**
     * When the button is clicked, this method is called to transition the UI to the player selection screen.
     *
     * @param e The action event triggered by the button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Switch the panel to the player selection screen
        PanelManager.changeToPlayerSelection();
    }
}
