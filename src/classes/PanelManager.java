package classes;

import gui.panels.MainPanels.*;

public class PanelManager {

    //Attributes - Panels
    private final static TitleScreenPanel titleScreenPanel;
    private final static PlayerSelectionPanel playerSelectionPanel;
    private static BattlePanel battlePanel;


    static {

        titleScreenPanel = new TitleScreenPanel();
        playerSelectionPanel = new PlayerSelectionPanel();

    }


    //Methods
    public static void changeToClassSelectionPanel() {
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
        Game.instance.createBattle();
        battlePanel = new BattlePanel();
        Game.instance.getMainFrame().add(battlePanel);
        Game.instance.getMainFrame().repaint();
        Game.instance.getMainFrame().revalidate();
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
