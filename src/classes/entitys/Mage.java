package classes.entitys;
import classes.Attack;

import java.util.ArrayList;

public class Mage extends Player {

    //Constructor
    public Mage(){
        super(35, 25, 55, new ArrayList<Attack>());

        attackList.add(new Attack("Ice Beam", 3));
        attackList.add(new Attack("Thunder", 7));
        attackList.add(new Attack("Magic Shield", 1));

    }


    public void showHealth(){
        System.out.print("Mage ");
        super.showHealth();
        System.out.println();

    }
}