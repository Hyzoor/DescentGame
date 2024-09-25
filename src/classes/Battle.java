package classes;

import classes.entitys.Entity;

public class Battle {

    //Attributes
    private Entity player;
    private Entity enemy;
    private Turn turn;

    public Battle(Entity newPlayer, Entity newEnemy){
        setPlayer(newPlayer);
        setEnemy(newEnemy);
        setTurn(new Turn(player, enemy));
    }



    //Methods
    private void changeTurn(){

        turn = new Turn(turn.getDefender(), turn.getAttacker());
    }

    public void start(){

        while(!enemy.isDead() && !player.isDead()){

            turn.performTurn();
            changeTurn();
        }

    }






    //Setters and Getters
    public void setPlayer(Entity newPlayer){
        player = newPlayer;
    }

    public void setEnemy(Entity newEnemy){
        enemy = newEnemy;
    }

    public void setTurn(Turn newTurn){
        turn = newTurn;
    }

    public Entity getPlayer(){
        return player;
    }

    public Entity getEnemy(){
        return enemy;
    }

    public Turn getTurn(){
        return turn;
    }
}
