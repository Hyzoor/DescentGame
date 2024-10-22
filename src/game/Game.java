package game;

import game.battle.Battle;
import game.characters.Player;
import game.enemyfactory.RandomEnemyFactory;
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

    public static void startGame(){
        if(instance != null){
            return;
        }
        instance = new Game();
    }

    //Methods
    public void createBattle(){
        battle = new Battle(player, new RandomEnemyFactory().createEnemy());
    }

    public void createBossBattle(){
        //TODO
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

