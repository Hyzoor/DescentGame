package ui;

import game.Game;
import ui.panels.mainpanels.*;

public class PanelManager {

    // Attributes - Panels
    private final static TitleScreenPanel titleScreenPanel;
    private final static PlayerSelectionPanel playerSelectionPanel;
    private final static BattlePanel battlePanel;

    static {
        titleScreenPanel = new TitleScreenPanel();
        playerSelectionPanel = new PlayerSelectionPanel();
        battlePanel = new BattlePanel();
    }

    // Methods
    public static void changeToPlayerSelectionPanel() {
        Game.instance.getMainFrame().getContentPane().removeAll();
        Game.instance.getMainFrame().add(playerSelectionPanel);
        Game.instance.getMainFrame().repaint();
        Game.instance.getMainFrame().revalidate();
    }

    public static void changeToTittleScreenPanel() {
        Game.instance.getMainFrame().getContentPane().removeAll();
        Game.instance.getMainFrame().add(titleScreenPanel);
        Game.instance.getMainFrame().repaint();
        Game.instance.getMainFrame().revalidate();
    }

    public static void changeToBattlePanel() {
        Game.instance.getMainFrame().getContentPane().removeAll();
        PanelManager.battlePanel.updatePanel();
        Game.instance.getMainFrame().add(battlePanel);
        Game.instance.getMainFrame().repaint();
        Game.instance.getMainFrame().revalidate();
    }

    public static void updateBattleCount() {
        battlePanel.setBattleCount(Game.instance.getBattleCounter().getCount());
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
