package game.characters;

import java.util.Random;

import game.Game;
import game.JsonMapper;
import settings.Settings;

/**
 * Represents an Enemy that auto perform attacks to the player
 */
public class Enemy extends Entity {

    private EnemyType enemyType;

    /**
     * Constructs enemy from a json file using JsonMapper
     *
     * @param newIdentifier String identifier. Has to be named same as the json file
     * @see JsonMapper
     */
    public Enemy(String newIdentifier) {
        super(newIdentifier);

        String json = Settings.getInstance().getFilePaths().get("enemiesJsons") + identifier.toLowerCase() + ".json";
        JsonMapper.mapObject(json, this);
    }

    /**
     * Perform an attack to a target with a random attack
     *
     * @param target Entity that receives the damage
     */
    public void performAttackTo(Entity target) {
        Attack randomAttack = attackSelector();
        super.performAttackTo(target, randomAttack);
    }

    /**
     * Selects a random attack from the list
     *
     * @return Index of the attack selected
     */
    private Attack attackSelector() {
        Random random = new Random();
        int n = random.nextInt(attackList.size());
        return attackList.get(n);
    }

    //------------------ GETTERS ------------------//

    public EnemyType getEnemyType(){
        return this.enemyType;
    }
}
