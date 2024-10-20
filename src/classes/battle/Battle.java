package classes.battle;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ui.PanelManager;
import classes.characters.Enemy;
import classes.characters.Player;

public class Battle {

    //Attributes
    private Player player;
    private Enemy enemy;
    private boolean isPlayersTurn;
    private Timer timer;


    public Battle(Player newPlayer, Enemy newEnemy) {
        isPlayersTurn = true;
        setPlayer(newPlayer);
        setEnemy(newEnemy);
        initializeTimer();
    }


    //Methods
    public void endBattle() {
        timer.stop();
        PanelManager.getBattlePanel().enablePlayerButtons(false);
        PanelManager.getBattlePanel().addButtonsAfterWin();
        showResults();
    }

    public void rotate() {
        if (isAnyoneDead()) {
            endBattle();
            return;
        }
        isPlayersTurn = !isPlayersTurn;
    }

    public boolean isAnyoneDead() {
        return player.isDead() || enemy.isDead();
    }

    public void showResults() {
        String result;
        if (player.isDead()) {
            result = enemy.toString() + " has defeated you ...";
        } else {
            result = "You have defeated " + enemy.toString() + " ! Good job !";
        }

        PanelManager.getBattlePanel().addText(result);
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
