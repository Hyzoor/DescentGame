package ui.panels.mainpanels;

import javax.swing.*;
import java.awt.*;

/**
 * Represents the credits panel in the game interface.
 *
 * This panel is displayed at the end of the game, showing the credits or acknowledgments.
 */
public class CreditsPanel extends JPanel {

    /**
     * Creates a new CreditsPanel with a black background and a label displaying "fin".
     */
    public CreditsPanel(){
        this.setBackground(Color.black);

        this.add(new JLabel("fin"), BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }
}
