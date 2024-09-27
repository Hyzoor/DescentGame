package classes.entitys;

import classes.Attack;
import java.util.ArrayList;

public class Rogue extends Player {

    //Constructor
    public Rogue(){
        super(20, 20, 70, new ArrayList<Attack>());

        attackList.add(new Attack("Payday", 4));
        attackList.add(new Attack("Lethal Knife", 8));
        attackList.add(new Attack("Stealth", 1));

    }

    @Override
    public String toString(){
        return "ROGUE";
    }
}
