package classes;
import java.util.List;
import java.util.ArrayList;

public abstract class Player extends Entity{

    //Attributes
    protected List<Attack> attackList;


    Player(int newHealth, int newDefense, int newStrength, List<Attack> newAttackList){
        super(newHealth, newStrength, newDefense);
        setAttackList(newAttackList);
    }


    //Getters and Setters
    public List<Attack> getAttackList(){
        return attackList;
    }

    public void setAttackList(List<Attack> newAttackList){
        attackList = newAttackList;
    }
}
