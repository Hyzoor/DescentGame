package ui;

import game.Game;
import ui.mainframe.MainFrame;
import ui.panels.mainpanels.*;

import java.awt.*;

public class PanelManager {

    // Attributes - Panels
    private final static TitleScreenPanel titleScreenPanel;
    private final static PlayerSelectionPanel playerSelectionPanel;
    private final static BattlePanel battlePanel;
    private final static MainFrame mainFrame;

    static {
        titleScreenPanel = new TitleScreenPanel();
        playerSelectionPanel = new PlayerSelectionPanel();
        battlePanel = new BattlePanel();
        mainFrame = MainFrame.getInstance();
    }

    // Methods
    public static void changeToPlayerSelection() {
        mainFrame.getContentPane().removeAll();
        mainFrame.add(playerSelectionPanel);
        updateMainFrame();
    }

    public static void changeToTittleScreen() {
        mainFrame.getContentPane().removeAll();
        mainFrame.add(titleScreenPanel);
        updateMainFrame();
    }

    public static void changeToBattle() {
        mainFrame.getContentPane().removeAll();
        mainFrame.add(battlePanel);
        updateMainFrame();
    }

    private static void updateMainFrame(){
        mainFrame.repaint();
        mainFrame.revalidate();
    }

    //------------------ SETTERS AND GETTERS ------------------//

    public static TitleScreenPanel getTitleScreenPanel() {
        return titleScreenPanel;
    }

    public static PlayerSelectionPanel getPlayerSelectionPanel() {
        return playerSelectionPanel;
    }

    public static BattlePanel getBattlePanel() {
        return battlePanel;
    }
}
