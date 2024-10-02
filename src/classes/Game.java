package classes;

import classes.entitys.Player;
import gui.MainFrame;


public class Game {

    private MainFrame mainFrame;
    private Player player;
    private Battle battle;

    public static Game instance;

    public Game(){
        mainFrame = new MainFrame();
        instance = this;
    }



//------------------ SETTERS AND GETTERS ------------------//

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public Player getPlayer(){
        return player;
    }

    public void setPlayer(Player newPlayer){
        player = newPlayer;
    }

    public Battle getBattle(){
        return battle;
    }

    public void setBattle(Battle newBattle){
        battle = newBattle;
    }
}

