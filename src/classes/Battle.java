package classes;

import classes.entitys.Enemy;
import classes.entitys.Player;

public class Battle {

    //Attributes
    private Player player;
    private Enemy enemy;
    private boolean isPlayersTurn;


    public Battle(Player newPlayer, Enemy newEnemy){
        setPlayer(newPlayer);
        setEnemy(newEnemy);
        isPlayersTurn = true;
    }


    //Methods
    public void start(){

        // TODO -------------------------------------------------

    }

    public void rotate(){
        isPlayersTurn = !isPlayersTurn;
    }

    public boolean isBattleEnded(){
        return player.isDead() || enemy.isDead();
    }

    public void performPlayerAttack(int attackSelected){
        player.performAttackTo(enemy, attackSelected);
    }

    public void performEnemyAttack(){
        enemy.performAttackTo(player);
    }


//------------------ SETTERS AND GETTERS ------------------//

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
