package game;

import game.battle.Battle;
import game.characters.Player;
import game.enemyfactory.EnemyFactory;
import game.enemyfactory.RandomBossFactory;
import game.enemyfactory.RandomDifficultEnemyFactory;
import game.enemyfactory.RandomEnemyFactory;
import ui.PanelManager;
import ui.mainframe.MainFrame;

import java.util.Random;

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
    public void createBattle(){
        int battlesPlayed = BattleCounter.get();

        if (BattleCounter.hasReachedMax()) {
            endGame();
            return;
        }

        if(battlesPlayed < 4){
            createBattle(new RandomEnemyFactory());
        }else if(battlesPlayed < 8){
            createBattle(new RandomDifficultEnemyFactory());
        }else{
            createBattle(new RandomBossFactory());
        }
    }

    private void createBattle(EnemyFactory enemyFactory) {
        battle = new Battle(player, enemyFactory.createEnemy());
        BattleCounter.increment();
        PanelManager.getBattlePanel().getBattleTextArea().showBattleCount();
        PanelManager.getBattlePanel().updatePanel();
    }

    private void endGame() {
        PanelManager.getBattlePanel().getBattleTextArea().addText("You have reach level " + BattleCounter.get() + ", you have win!");
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
