package classes;

import classes.entitys.Entity;

public class Turn {

    //Attributes
    private Entity attacker;
    private Entity defender;


    public Turn(Entity newAttacker, Entity newDefender){
        setAttacker(newAttacker);
        setDefender(newDefender);
    }


    //Methods
    private Attack selectAttack(){
        /* TODO implementar logica de seleccion de ataque para el jugador */
        return attacker.getAttackList().get(1);
    }


    private int calculateDamage(Attack attack){

        return (int) ((attacker.getStrength() * attack.getAttackPower()) / (defender.getDefense() * 0.4));
    }

    public void performTurn(){

        Attack attackSelected = selectAttack();
        int damage = calculateDamage(attackSelected);
        defender.takeDamage(damage);
    }


    //Setters and Getters
    Entity getAttacker(){
        return attacker;
    }

    Entity getDefender(){
        return defender;
    }

    void setAttacker(Entity newAttacker){
        attacker = newAttacker;
    }

    void setDefender(Entity newDefender){
        defender = newDefender;
    }

}
