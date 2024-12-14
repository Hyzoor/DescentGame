package game.enemyfactory;

import java.util.Random;

import game.characters.Enemy;
import game.characters.EnemyType;

/**
 * Factory class for creating a random easy enemy.
 * Implements the {@link EnemyFactory} interface.
 */
public class RandomEnemyFactory implements EnemyFactory {

    /**
     * Constructor for RandomEnemyFactory.
     * Initializes all available enemies by calling {@link #initializeAllEnemiesAvailable()}.
     */
    public RandomEnemyFactory(){
        initializeAllEnemiesAvailable();
    }

    /**
     * Creates a random easy enemy.
     * The enemy is selected from the list of available enemies, ensuring that the enemy is of type {@link EnemyType#EASY}.
     *
     * @return A randomly selected easy enemy.
     */
    @Override
    public Enemy create() {
        Random random = new Random();
        int i;
        do {
            i = random.nextInt(enemiesAvailable.size());
        } while (enemiesAvailable.get(i).getEnemyType() != EnemyType.EASY);

        return new Enemy(enemiesAvailable.get(i).toString());
    }
}
