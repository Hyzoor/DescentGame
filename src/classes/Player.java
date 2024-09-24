package classes;
import java.util.List;
import java.util.ArrayList;

public abstract class Player extends Entity{

    //Attributes
    protected int gold;
    protected List<Attack> attackList;


    Player(int newHealth, int newDefense, int newStrength, List<Attack> newAttackList){
        super(newHealth, newStrength, newDefense);
        setGold(0);
        setAttackList(newAttackList);
    }



    //Gold methods
    public void addGold(int newGold){
        gold += newGold;
    }

    public void removeGold(int goldToRemove){
        gold -= goldToRemove;
    }





    //Getters and Setters
    public int getGold(){
        return gold;
    }

    public List<Attack> getAttackList(){
        return attackList;
    }

    public void setAttackList(List<Attack> newAttackList){
        attackList = newAttackList;
    }

    public void setGold(int newGold){
        gold = newGold;
    }
}
