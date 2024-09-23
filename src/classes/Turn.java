package classes;

public class Turn {

    //Attributes
    private Entity attacker;
    private Entity defender;


    Turn(Entity newAttacker, Entity newDefender){
        setAttacker(newAttacker);
        setDefender(newDefender);
    }


    //Methods
    Entity getAttacker(){
        return this.attacker;
    }

    Entity getDefender(){
        return this.defender;
    }

    void setAttacker(Entity newAttacker){
        this.attacker = newAttacker;
    }

    void setDefender(Entity newDefender){
        this.defender = newDefender;
    }

    public void doDamage(int damage){

        this.defender.takeDamage(damage);
    }

}
