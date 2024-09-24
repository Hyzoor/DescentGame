package classes;
import java.util.ArrayList;

public class Knight extends Player {

    //Constructor
    Knight(){
<<<<<<< HEAD
        super(50, 40, 20, new ArrayList<Attack>());
=======

        super(100, 3, 2, new ArrayList<Attack>());
>>>>>>> 50f67b4ba9ff4cb66e4497e8a5e1042c7a23752b

        attackList.add(new Attack("Sword Strike", 2));
        attackList.add(new Attack("Drain Mace", 5)); //drenar vida
        attackList.add(new Attack("Shield Reduction", 1)); //50% menos de daño recibido

    }

}
