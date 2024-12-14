package game;

import settings.Settings;
import ui.PanelManager;
import ui.mainframe.MainFrame;

/**
 * The entry point of the game. This class initializes the necessary components
 * and transitions to the title screen of the game.
 */
public class Main {

    /**
     * The main method that starts the game.
     *
     * It initializes the settings, game, and main frame instances, and then switches
     * the panel to the title screen.
     *
     * @param args The command line arguments (not used in this case).
     */
    public static void main(String[] args){

        // Initialize the singleton instances
        Settings settings = Settings.getInstance();
        Game game = Game.getInstance();
        MainFrame mainFrame = MainFrame.getInstance();

        // Change to the title screen
        PanelManager.changeToTittleScreen();
    }
}
