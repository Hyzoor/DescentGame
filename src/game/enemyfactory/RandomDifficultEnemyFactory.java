package game.enemyfactory;

import java.util.Random;

import game.characters.Enemy;
import game.characters.EnemyType;
import settings.Settings;

public class RandomDifficultEnemyFactory implements EnemyFactory {

    public RandomDifficultEnemyFactory(){
        initializeAllEnemiesAvailable();
    }

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

    private void increaseEnemyStats(Enemy enemy) {
        for (String stat : enemy.getStats().keySet()) {
            int actualValue = enemy.getStatValue(stat);

            double difficultyMultiplier = Settings.getInstance().getMultipliers().get("difficulty");
            enemy.setStatValue(stat, (int) (actualValue * difficultyMultiplier));
        }
    }

}
