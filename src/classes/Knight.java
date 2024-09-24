package classes;
import java.util.ArrayList;

public class Knight extends Player {

    //Constructor
    Knight(){

        super(100, 3, 2, new ArrayList<Attack>());

        attackList.add(new Attack("Ataque rapido", 5));
        attackList.add(new Attack("Ataque fuerte", 7));
        attackList.add(new Attack("Habilidad Knight 3", 1));

    }

}
