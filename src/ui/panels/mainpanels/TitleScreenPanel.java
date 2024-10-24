package ui.panels.mainpanels;

import javax.swing.*;
import java.awt.*;

import ui.buttons.TitleScreenStartButton;

public class TitleScreenPanel extends JPanel {

    private final Image background;

    public TitleScreenPanel() {

        background = new ImageIcon("src/resources/images/title-screen.jpg").getImage();

        this.setLayout(new BorderLayout());
        this.add(new TitleScreenStartButton(), BorderLayout.CENTER);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
