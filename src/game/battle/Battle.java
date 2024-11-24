package game.battle;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.BattleCounter;
import ui.PanelManager;
import game.characters.Enemy;
import game.characters.Player;

public class Battle {

    //Attributes
    private Player player;
    private Enemy enemy;
    private Timer timer;
    private boolean isPlayersTurn;

    //Constructor
    public Battle(Player newPlayer, Enemy newEnemy) {
        isPlayersTurn = true;
        setPlayer(newPlayer);
        setEnemy(newEnemy);
        initializeTimer();
    }


    //Methods
    public void rotate() {
        if (isAnyoneDead()) {
            end();
            return;
        }
        isPlayersTurn = !isPlayersTurn;
    }

    public boolean isPlayerWinner(){
        return !player.isDead();
    }

    public boolean isAnyoneDead() {
        return player.isDead() || enemy.isDead();
    }

    public void end() {
        timer.stop();
        PanelManager.getBattlePanel().enablePlayerButtons(false);

        if(isPlayerWinner()){
            PanelManager.getBattlePanel().addButtonsAfterWinning();
        }else{
            PanelManager.getBattlePanel().addButtonsAfterLosing();
        }

        showResults();
    }

    public void showResults() {
        String result;
        if (player.isDead()) {
            result = enemy.toString() + " has defeated you ...";
        } else {
            result = "You have defeated " + enemy.toString() + " ! Good job !";
        }

        PanelManager.getBattlePanel().getBattleTextArea().addText(result);
    }

    private void initializeTimer() {

        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isPlayersTurn) {
                    return;
                }

                enemy.performAttackTo(player);
                rotate();
                PanelManager.getBattlePanel().enablePlayerButtons(true);
            }
        });

        timer.start();
    }


//------------------ SETTERS AND GETTERS ------------------//

    public void setPlayer(Player newPlayer) {
        player = newPlayer;
    }

    public void setEnemy(Enemy newEnemy) {
        enemy = newEnemy;
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
