package classes.entitys;

import classes.Attack;
import java.util.ArrayList;


public class Enemy extends Entity{

    public Enemy(){
        super(100,20,20, new ArrayList<Attack>());
        attackList.add(new Attack("Default ATTACK", 2));


    }

    public void performAttackTo(Entity target){

        //TODO: Enemy LOGIC ATTACK SELECTION
        super.performAttackTo(target, 0);
    }

    @Override
    public String toString(){
        return "ENEMY";
    }
}
