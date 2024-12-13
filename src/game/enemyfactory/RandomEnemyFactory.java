package game.enemyfactory;

import java.util.Random;

import game.characters.Enemy;
import game.characters.EnemyType;


public class RandomEnemyFactory implements EnemyFactory {

    public RandomEnemyFactory(){
        initializeAllEnemiesAvailable();
    }

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
