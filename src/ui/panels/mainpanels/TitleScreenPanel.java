package ui.panels.mainpanels;

import javax.swing.*;
import java.awt.*;

import ui.buttons.TitleScreenStartButton;

/**
 * Represents the title screen panel in the game interface.
 *
 * This panel is displayed when the game starts, showing the game's title screen
 * along with a button to start the game.
 */
public class TitleScreenPanel extends JPanel {

    /**
     * The background image for the title screen panel.
     */
    private final Image background;

    /**
     * Creates a new TitleScreenPanel, initializing the background and adding the start button.
     */
    public TitleScreenPanel() {
        background = new ImageIcon("src/resources/images/title-screen.jpg").getImage();

        this.setLayout(new BorderLayout());
        this.add(new TitleScreenStartButton(), BorderLayout.CENTER);
    }

    /**
     * Paints the background image of the panel.
     *
     * @param g Graphics object used for painting the background.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
