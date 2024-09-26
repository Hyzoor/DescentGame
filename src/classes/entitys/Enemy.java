package classes.entitys;

import classes.Attack;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Entity{

    public Enemy(){
        super(100,20,20, new ArrayList<Attack>());

    }

    public void performAttackTo(Entity target){
        //TODO
    }
}
