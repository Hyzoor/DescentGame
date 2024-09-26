package classes;
import java.util.ArrayList;

public class git sKnight extends Player {

    //Constructor
    Knight(){
        super(50, 40, 20, new ArrayList<Attack>());

        attackList.add(new Attack("Sword Strike", 2));
        attackList.add(new Attack("Drain Mace", 5));
        attackList.add(new Attack("Shield Reduction", 1));

    }


    public void showHealth(){
        System.out.println("Knight ");
        super.showHealth();
        System.out.println();

    }
}
