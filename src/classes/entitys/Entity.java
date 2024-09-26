package classes.entitys;
import classes.Attack;

import java.util.List;

abstract public class Entity {

    //Attributes
    protected int health;
    protected int strength;
    protected int defense;
    protected List<Attack> attackList;


    public Entity(int newHealth, int newStrength, int newDefense, List<Attack> newAttackList){
        setDefense(newDefense);
        setHealth(newHealth);
        setStrength(newStrength);
        setAttackList(newAttackList);
    }


    //Methods
    public void takeDamage(int damage){

        if(isDead()){
            return;
        }

        health -= (int) (damage / (defense * 0.4));
    }


    public boolean isDead(){
        return health <= 0;
    }

    public void showHealth(){
        System.out.print("health: " + getHealth());
    }


    //Setters and Getters
    public void setHealth(int newHealth){
        health = newHealth;
    }

    public void setStrength(int newStrength){
        strength = newStrength;
    }

    public void setDefense(int newDefense){
        defense = newDefense;
    }

    public void setAttackList(List<Attack> newAttackList){
        attackList = newAttackList;
    }

    public int getHealth(){
        return health;
    }

    public int getStrength(){
        return strength;
    }

    public int getDefense(){
        return defense;
    }

    public List<Attack> getAttackList(){
        return attackList;
    }
}