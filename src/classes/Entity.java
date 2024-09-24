package classes;

abstract public class Entity {

    //Attributes
    protected int health;
    protected int strength;
    protected int defense;

    Entity(int newHealth, int newStrength, int newDefense){
        setDefense(newDefense);
        setHealth(newHealth);
        setStrength(newStrength);
    }



    //Methods
    public void takeDamage(int attackPower){
        health -= attackPower;
    }

    public boolean isDead(){
        return health <= 0;
    }

    public void showHealth(){
        System.out.println("Health: " + getHealth());
    }




    //Setters and Getters
    public void setHealth(int newHealth){
        health = newHealth;
    }

    public void setDefense(int newStrength){
        strength = newStrength;
    }

    public void setStrength(int newDefense){
        defense = newDefense;
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
}
