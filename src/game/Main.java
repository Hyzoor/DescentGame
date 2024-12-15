package game;

import settings.Settings;
import ui.PanelManager;
import ui.mainframe.MainFrame;

/**
 * Main class to start the game application.
 * <p>
 * This class serves as the entry point of the game. It initializes the settings,
 * the game instance, and the main frame. It then transitions to the title screen
 * to begin the game.
 * </p>
 */
public class Main {

    /**
     * The main method that is executed when the game starts.
     * <p>
     * It initializes the necessary instances for the game, settings, and main frame,
     * then changes the screen to the title screen.
     * </p>
     *
     * @param args Command line arguments (not used in this implementation).
     */
    public static void main(String[] args) {

        Settings settings = Settings.getInstance();
        Game game = Game.getInstance();
        MainFrame mainFrame = MainFrame.getInstance();

        PanelManager.changeToTittleScreen();
    }
}
