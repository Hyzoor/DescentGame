package game.characters;

import java.util.Random;

import game.JsonMapper;


public class Enemy extends Entity {

    //Constructor
    public Enemy(String newIdentifier) {
        super(newIdentifier);

        String jsonFilepath = "src/game/characters/data/enemies/" + identifier.toLowerCase() + ".json";
        JsonMapper.mapEntity(jsonFilepath, this);
    }

    //Methods
    public void performAttackTo(Entity target) {
        int attackNumber = attackSelector();
        super.performAttackTo(target, attackNumber);
    }

    private int attackSelector() {
        Random random = new Random();
        return random.nextInt(attackList.size());
    }
}
