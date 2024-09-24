package classes;
import java.util.ArrayList;

public class Rogue extends Player {

    //Constructor
    Rogue(){
        super(20, 20, 70, new ArrayList<Attack>());

        attackList.add(new Attack("Payday", 4));
        attackList.add(new Attack("Lethal Knife", 8));
        attackList.add(new Attack("Stealth", 1));

    }


    public void showHealth(){
        System.out.print("Rogue ");
        super.showHealth();
        System.out.println();

    }

}
