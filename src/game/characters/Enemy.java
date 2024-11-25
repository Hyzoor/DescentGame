package game.characters;

import java.util.Random;

import game.JsonMapper;

/**
 * Represents an Enemy that auto perform attacks to the player
 */
public class Enemy extends Entity {

    /**
     * Constructs enemy from a json file using JsonMapper
     * @see JsonMapper
     * @param newIdentifier String identifier. Has to be named same as the json file
     */
    public Enemy(String newIdentifier) {
        super(newIdentifier);

        String jsonFilepath = "src/game/characters/data/enemies/" + identifier.toLowerCase() + ".json";
        JsonMapper.mapEntity(jsonFilepath, this);
    }

    /**
     * Perform an attack to a target with a random attack
     * @param target Entity that receives the damage
     */
    public void performAttackTo(Entity target) {
        int attackNumber = attackSelector();
        super.performAttackTo(target, attackNumber);
    }

    /**
     * Selects a random attack from the list
     * @return Index of the attack selected
     */
    private int attackSelector() {
        Random random = new Random();
        return random.nextInt(attackList.size());
    }
}
