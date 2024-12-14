package game.enemyfactory;

import java.util.Random;

import game.characters.Enemy;
import game.characters.EnemyType;
import settings.Settings;

/**
 * Factory class for creating a random difficult enemy.
 * Implements the {@link EnemyFactory} interface.
 */
public class RandomDifficultEnemyFactory implements EnemyFactory {

    /**
     * Constructor for RandomDifficultEnemyFactory.
     * Initializes all available enemies by calling {@link #initializeAllEnemiesAvailable()}.
     */
    public RandomDifficultEnemyFactory(){
        initializeAllEnemiesAvailable();
    }

    /**
     * Creates a random difficult enemy.
     * The enemy is selected from the list of available enemies, ensuring that the enemy is of type {@link EnemyType#DIFFICULT}.
     * After creation, the enemy's stats are increased by a difficulty multiplier.
     *
     * @return A randomly selected difficult enemy with enhanced stats.
     */
    @Override
    public Enemy create() {
        Random random = new Random();
        int i;

        do {
            i = random.nextInt(enemiesAvailable.size());
        } while (enemiesAvailable.get(i).getEnemyType() != EnemyType.DIFFICULT);

        Enemy difficultEnemy = new Enemy(enemiesAvailable.get(i).toString());
        increaseEnemyStats(difficultEnemy);

        return difficultEnemy;
    }

    /**
     * Increases the stats of the given enemy using a difficulty multiplier from the settings.
     *
     * @param enemy The enemy whose stats will be increased.
     */
    private void increaseEnemyStats(Enemy enemy) {
        for (String stat : enemy.getStats().keySet()) {
            int actualValue = enemy.getStatValue(stat);

            double difficultyMultiplier = Settings.getInstance().getMultipliers().get("difficulty");
            enemy.setStatValue(stat, (int) (actualValue * difficultyMultiplier));
        }
    }
}
