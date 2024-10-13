package classes;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import classes.entities.Enemy;
import classes.entities.Player;

public class Battle {

    //Attributes
    private Player player;
    private Enemy enemy;
    private boolean isPlayersTurn;
    private Timer timer;


    public Battle(Player newPlayer, Enemy newEnemy) {
        setPlayer(newPlayer);
        setEnemy(newEnemy);
        isPlayersTurn = true;
        initializeTimer();
    }


    //Methods
    public void endBattle() {
        timer.stop();
        PanelManager.getBattlePanel().enablePlayerButtons(false);
        showResults();
        PanelManager.getBattlePanel().addButtonsAfterWin();

        //Prueba para hacer batallas consecutivas
//        player.restoreHealth();
//        Game.instance.createBattle();
//        PanelManager.changeToBattlePanel();
        ///////////////////////////////////////////////
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
                if (!isPlayersTurn) {
                    enemy.performAttackTo(player);
                    rotate();
                    PanelManager.getBattlePanel().enablePlayerButtons(true);
                }
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
