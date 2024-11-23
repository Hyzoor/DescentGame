package game;

import game.battle.Battle;
import game.characters.Player;
import game.enemyfactory.EnemyFactory;
import ui.PanelManager;
import ui.mainframe.MainFrame;

public class Game {

    // Singleton
    public static Game instance;

    private final MainFrame mainFrame;
    private Player player;
    private Battle battle;

    private Game() {
        mainFrame = new MainFrame();
        BattleCounter.reset();
    }

    public static void start() {
        if (instance != null) {
            return;
        }
        instance = new Game();
    }

    // Methods
    public void createBattle(EnemyFactory enemyFactory) {
        if (BattleCounter.hasReachedMax()) {
            endGame();
            return;
        }

        battle = new Battle(player, enemyFactory.createEnemy());
        BattleCounter.increment();
        PanelManager.getBattlePanel().showBattleCount();
        PanelManager.getBattlePanel().updatePanel();
    }

    private void endGame() {
        PanelManager.getBattlePanel().addText("You have reach level " + BattleCounter.get() + ", you have win!");
    }

    //------------------ SETTERS Y GETTERS ------------------//

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
