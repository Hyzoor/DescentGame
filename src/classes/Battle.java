package classes;

import classes.entitys.Enemy;
import classes.entitys.Player;

public class Battle {

    //Attributes
    public static Battle instance;
    private Player player;
    private Enemy enemy;
    private boolean isPlayersTurn;


    public Battle(Player newPlayer, Enemy newEnemy){
        setPlayer(newPlayer);
        setEnemy(newEnemy);
        isPlayersTurn = true;
        instance = this;
    }


    //Methods
    private void rotate(){
        isPlayersTurn = !isPlayersTurn;
    }

    public void start(){

//        while(!isBattleEnded()){
//
//
//            rotate();
//        }

    }

    public boolean isBattleEnded(){
        return player.isDead() || enemy.isDead();
    }

    public void performPlayerAttack(Enemy target, int attackSelected){
        player.performAttackTo(enemy, attackSelected);
    }

    public void performEnemyAttack(Player target){
        enemy.performAttackTo(player);
    }


    //Setters and Getters
    public void setPlayer(Player newPlayer){
        player = newPlayer;
    }

    public void setEnemy(Enemy newEnemy){
        enemy = newEnemy;
    }

    public Player getPlayer(){
        return player;
    }

    public Enemy getEnemy(){
        return enemy;
    }

}
