package game.characters;

import java.util.Random;

import game.JsonMapper;
import settings.Settings;

/**
 * Represents an enemy that automatically performs attacks on the player.
 */
public class Enemy extends Entity {

    /**
     * The type of the enemy.
     */
    private EnemyType enemyType;

    /**
     * Constructs an enemy from a JSON file using {@link JsonMapper}.
     *
     * @param newIdentifier the string identifier of the enemy. Must match the name of the JSON file.
     */
    public Enemy(String newIdentifier) {
        super(newIdentifier);

        String json = Settings.getInstance().getFilePaths().get("enemiesJsons") + identifier.toLowerCase() + ".json";
        JsonMapper.mapObject(json, this);
    }

    /**
     * Performs an attack on a target using a randomly selected attack.
     *
     * @param target the entity that receives the damage.
     */
    public void performAttackTo(Entity target) {
        Attack randomAttack = attackSelector();
        super.performAttackTo(target, randomAttack);
    }

    /**
     * Selects a random attack from the list of available attacks.
     *
     * @return the selected attack.
     */
    private Attack attackSelector() {
        Random random = new Random();
        int n = random.nextInt(attackList.size());
        return attackList.get(n);
    }

    //------------------ GETTERS ------------------//

    /**
     * Gets the type of the enemy.
     *
     * @return the enemy type.
     */
    public EnemyType getEnemyType() {
        return this.enemyType;
    }
}
