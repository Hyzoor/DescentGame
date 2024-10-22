package game.characters;


import game.JsonMapper;

import java.util.ArrayList;
import java.util.HashMap;


public class Enemy extends Entity {

    //Constructor
    public Enemy(String newIdentifier) {
        super(newIdentifier, new HashMap<>(), new ArrayList<>());

        String jsonFilepath = "src/classes/characters/data/enemies/" + identifier.toLowerCase() + ".json";
        JsonMapper.mapEntity(jsonFilepath, this);
    }

    //Methods
    public void performAttackTo(Entity target) {
        int attackNumber = attackSelector();
        super.performAttackTo(target, attackNumber);
    }

    private int attackSelector() {
        return (int) (Math.random() * attackList.size());
    }
}
