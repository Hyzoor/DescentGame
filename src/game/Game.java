package game;

import game.battle.Battle;
import game.characters.Enemy;
import game.characters.Player;
import game.enemyfactory.*;

import ui.PanelManager;

/**
 * Manages the game logic, the player, creates battles and checks when has the game finished
 */
public class Game {

    private static Game instance;
    private Player player;
    private Enemy enemy;
    private Battle battle;


    private Game() {
        BattleCounter.reset();
    }

    /**
     * @return Returns game object instance if already exists one, creates one and returns it otherwise
     */
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }

        return instance;
    }

    /**
     * Creates a new battle with a random enemy or boss depending on how many battles have been played
     */
    public void createBattle() {

        if (isTheGameFinished()) {
            endGame();
            return;
        }

        int battlesPlayed = BattleCounter.get();
        EnemyFactory enemyFactory;

        if (battlesPlayed < 3) {
            enemyFactory = new RandomEnemyFactory();
        } else if (battlesPlayed < 7) {
            enemyFactory = new RandomDifficultEnemyFactory();
        } else {
            enemyFactory = new RandomBossFactory();
        }

        setEnemy(enemyFactory.create());
        createBattle(enemy);
    }

    private boolean isTheGameFinished(){
        return BattleCounter.hasReachedMax();
    }

    private void createBattle(Enemy enemy) {
        battle = new Battle(player, enemy);
        BattleCounter.increment();

        PanelManager.getBattlePanel().reset();
        PanelManager.getBattlePanel().getBattleTextArea().showBattleCount();
    }

    private void endGame() {
        PanelManager.getBattlePanel().getBattleTextArea().addText("You have reach level " + BattleCounter.get() + ", you have win!");
        //Todo final buttons or credits screen
    }

    //------------------ SETTERS Y GETTERS ------------------//


    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player newPlayer) {
        player = newPlayer;
    }

    public Enemy getEnemy(){
        return enemy;
    }

    public void setEnemy(Enemy newEnemy){
        enemy = newEnemy;
    }

    public Battle getBattle() {
        return battle;
    }

}
