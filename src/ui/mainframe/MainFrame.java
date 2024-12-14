package ui.mainframe;

import javax.swing.*;
import java.awt.*;

/**
 * The main window of the game, configured with a title, size, layout, and other settings.
 * This class follows the Singleton pattern to ensure only one instance of the window is created.
 */
public class MainFrame extends JFrame {

    private static MainFrame instance;

    /**
     * Private constructor to prevent instantiation from outside the class.
     * Initializes the main window with title, size, layout, and other properties.
     */
    private MainFrame() {

        setTitle("The Descent - RogueLike Game");
        setSize(1200, 750);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        setVisible(true);
    }

    /**
     * Retrieves the single instance of the MainFrame. If an instance doesn't exist, it creates one.
     *
     * @return the single instance of MainFrame
     */
    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

}
