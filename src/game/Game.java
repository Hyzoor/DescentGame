package game;

import game.battle.Battle;
import game.characters.Player;
import game.enemyfactory.EnemyFactory;
import ui.PanelManager;
import ui.mainframe.MainFrame;

public class Game {

    //Singleton
    public static Game instance;

    private final MainFrame mainFrame;
    private Player player;
    private Battle battle;

    private Game() {
        mainFrame = new MainFrame();
    }

    public static void start() {
        if (instance != null) {
            return;
        }
        instance = new Game();
    }

    //Methods
    public void createBattle(EnemyFactory enemyFactory) {
        battle = new Battle(player, enemyFactory.createEnemy());
        PanelManager.getBattlePanel().updatePanel();
    }

//------------------ SETTERS AND GETTERS ------------------//

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player newPlayer) {
        player = newPlayer;
    }

    public Battle getBattle() {
        return battle;
    }

}

