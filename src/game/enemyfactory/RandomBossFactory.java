package game.enemyfactory;

import game.characters.Enemy;
import game.characters.EnemyType;

import java.util.Random;

/**
 * Factory class for creating a random boss enemy.
 * Implements the {@link EnemyFactory} interface.
 */
public class RandomBossFactory implements EnemyFactory {

    /**
     * Constructor for RandomBossFactory.
     * Initializes all available enemies by calling {@link #initializeAllEnemiesAvailable()}.
     */
    public RandomBossFactory(){
        initializeAllEnemiesAvailable();
    }

    /**
     * Creates a random boss enemy.
     * The enemy is selected from the list of available enemies, ensuring that the enemy is of type {@link EnemyType#BOSS}.
     *
     * @return A randomly selected boss enemy.
     */
    @Override
    public Enemy create() {
        Random random = new Random();
        int i;

        do {
            i = random.nextInt(enemiesAvailable.size());
        } while (enemiesAvailable.get(i).getEnemyType() != EnemyType.BOSS);

        return new Enemy(enemiesAvailable.get(i).toString());
    }
}
