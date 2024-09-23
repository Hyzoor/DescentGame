package classes;

abstract public class Entity {

    //Attributes
    protected int health;
    protected int strength;
    protected int defense;



    //Setters and Getters
    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public void setDefense(int newStrength){
        this.strength = newStrength;
    }

    public void setStrength(int newDefense){
        this.defense = newDefense;
    }

    public int getHealth(){
        return this.health;
    }

    public int getStrength(){
        return this.strength;
    }

    public int getDefense(){
        return this.defense;
    }

    //Methods
    public void takeDamage(int attackPower){
            this.health -= attackPower;
    }

    public boolean isDead(){
        return this.health <= 0;
    }

    public void showHealth(){
        System.out.println(this.getHealth());
    }
}
