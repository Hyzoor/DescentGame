package classes;
import java.util.ArrayList;

public class Mage extends Player {

    //Constructor
    Mage(){
        super(20, 20, 70, new ArrayList<Attack>());

        attackList.add(new Attack("Payday", 4)); //mas experiencia/oro alomejor
        attackList.add(new Attack("Lethal Knife", 8));
        attackList.add(new Attack("Stealth", 1)); //sigilo

    }

}
