package ui;

import ui.mainframe.MainFrame;
import ui.panels.mainpanels.*;

/**
 * The PanelManager class is responsible for managing the different panels
 * in the application's user interface. It allows switching between the title screen,
 * player selection, battle, and credits panels, and updates the main frame accordingly.
 */
public class PanelManager {

    // Attributes - Panels
    /**
     * The panel that displays the title screen of the application.
     */
    private final static TitleScreenPanel titleScreenPanel;

    /**
     * The panel used for player selection in the application.
     */
    private final static PlayerSelectionPanel playerSelectionPanel;

    /**
     * The panel that manages the battle screen during gameplay.
     */
    private final static BattlePanel battlePanel;

    /**
     * The panel that displays the credits at the end of the game.
     */
    private final static CreditsPanel creditsPanel;

    /**
     * The main frame of the application where panels are added.
     */
    private final static MainFrame mainFrame;

    // Static block to initialize the panels and the main frame
    static {
        titleScreenPanel = new TitleScreenPanel();
        playerSelectionPanel = new PlayerSelectionPanel();
        battlePanel = new BattlePanel();
        creditsPanel = new CreditsPanel();
        mainFrame = MainFrame.getInstance();
    }

    // Methods

    /**
     * Switches the main frame to the player selection panel.
     * This removes all existing components and adds the player selection panel.
     */
    public static void changeToPlayerSelection() {
        mainFrame.getContentPane().removeAll();
        mainFrame.add(playerSelectionPanel);
        updateMainFrame();
    }

    /**
     * Switches the main frame to the title screen panel.
     * This removes all existing components and adds the title screen panel.
     */
    public static void changeToTittleScreen() {
        mainFrame.getContentPane().removeAll();
        mainFrame.add(titleScreenPanel);
        updateMainFrame();
    }

    /**
     * Switches the main frame to the battle panel.
     * This removes all existing components and adds the battle panel.
     */
    public static void changeToBattle() {
        mainFrame.getContentPane().removeAll();
        mainFrame.add(battlePanel);
        updateMainFrame();
    }

    /**
     * Switches the main frame to the credits panel.
     * This removes all existing components and adds the credits panel.
     */
    public static void changeToCredits(){
        mainFrame.getContentPane().removeAll();
        mainFrame.add(creditsPanel);
        updateMainFrame();
    }

    /**
     * Updates the main frame by repainting and revalidating it to ensure that
     * the newly added panel is correctly displayed.
     */
    private static void updateMainFrame(){
        mainFrame.repaint();
        mainFrame.revalidate();
    }

    //------------------ GETTERS ------------------//

    /**
     * Gets the title screen panel.
     *
     * @return the title screen panel
     */
    public static TitleScreenPanel getTitleScreenPanel() {
        return titleScreenPanel;
    }

    /**
     * Gets the player selection panel.
     *
     * @return the player selection panel
     */
    public static PlayerSelectionPanel getPlayerSelectionPanel() {
        return playerSelectionPanel;
    }

    /**
     * Gets the battle panel.
     *
     * @return the battle panel
     */
    public static BattlePanel getBattlePanel() {
        return battlePanel;
    }

    /**
     * Gets the credits panel.
     *
     * @return the credits panel
     */
    public static CreditsPanel getCreditsPanel(){
        return creditsPanel;
    }
}
