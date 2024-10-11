package classes;

import classes.entities.Player;
import gui.MainFrame;

public class Game {

    private final MainFrame mainFrame;
    private Player player;
    private Battle battle;

    public static Game instance;

    public Game() {
        instance = this;    //Singleton
        mainFrame = new MainFrame();
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
        battle.start();
    }
}

