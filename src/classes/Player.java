package classes;
import java.util.List;


public abstract class Player extends Entity{

    //Attributes
    protected int gold;

    Player(int newHealth, int newDefense, int newStrength, List<Attack> newAttackList){
        super(newHealth, newStrength, newDefense, newAttackList);
        gold = 0;
    }

}
