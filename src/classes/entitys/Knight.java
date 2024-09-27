package classes.entitys;

import classes.Attack;
import java.util.ArrayList;

public class Knight extends Player {

    //Constructor
    public Knight(){
        super(50, 40, 20, new ArrayList<Attack>());

        attackList.add(new Attack("Sword Strike", 2));
        attackList.add(new Attack("Drain Mace", 5));
        attackList.add(new Attack("Shield Reduction", 1));
        attackList.add(new Attack("Attack number 4", 3));

    }

    @Override
    public String toString(){
        return "KNIGHT";
    }

}
