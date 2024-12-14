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
        // Set the background color to black
        this.setBackground(Color.black);

        // Add a label with the text "fin" in the center
        this.add(new JLabel("fin"), BorderLayout.CENTER);

        // Set the layout and make the panel visible
        this.setLayout(new BorderLayout());
        this.setVisible(true);
    }
}
