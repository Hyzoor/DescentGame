package classes.entities;

import java.util.ArrayList;
import java.util.HashMap;

import classes.Attack;

public class Enemy extends Entity {

    public Enemy(String newIdentifier) {
        super(newIdentifier, new HashMap<String, Integer>(), new ArrayList<Attack>());
        createEnemy();
    }


    public void createEnemy() {

        switch (this.getIdentifier().toUpperCase()) {

            case "DEFAULT":
                setHealth(100);
                setStrength(20);
                setDefense(30);
                attackList.add(new Attack("Default Enemy Attack", 2));
                break;

            case "SKELETON":
                break;

        }
    }

    public void performAttackTo(Entity target) {
        //TODO attack selection logic
        super.performAttackTo(target, 0);
    }

}
