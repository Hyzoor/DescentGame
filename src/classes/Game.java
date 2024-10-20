package classes;

import classes.battle.Battle;
import classes.characters.Player;
import ui.mainframe.MainFrame;

public class Game {

    //Singleton
    public static Game instance;

    private final MainFrame mainFrame;
    private Battle battle;
    private Player player;

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
        battle = new Battle(player, EnemyFactory.createRandomEnemy());
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

    public void setBattle(Battle newBattle) {
        battle = newBattle;
    }
}

