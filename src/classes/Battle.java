package classes;

import javax.swing.Timer;

import classes.entities.Enemy;
import classes.entities.Player;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
    }


    //Methods
    public void start() {
        initializeTimer();
    }

    public void end(){
        timer.stop();
        PanelManager.getBattlePanel().enablePlayerButtons(false);
        showResults();
        // TODO More things
    }

    public void rotate() {
        if (isAnyoneDead()){
            end();
            return;
        }
        isPlayersTurn = !isPlayersTurn;
    }

    public boolean isAnyoneDead() {
        return player.isDead() || enemy.isDead();
    }

    public void performPlayerAttack(int attackSelected) {
        player.performAttackTo(enemy, attackSelected);
    }

    public void performEnemyAttack() {
        enemy.performAttackTo(player);
    }

    public void showResults(){
        String result;
        if(player.isDead()){
            result = enemy.toString() + " has defeated you ...";
        }else{
            result = "You have defeated " + enemy.toString() + " ! Good job !";
        }

        PanelManager.getBattlePanel().addText(result);
    }

    private void initializeTimer(){

        timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isPlayersTurn){
                    performEnemyAttack();
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
