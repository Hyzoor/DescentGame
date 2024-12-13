package game.enemyfactory;

import game.characters.Enemy;
import game.characters.EnemyType;

import java.util.Random;

public class RandomBossFactory implements EnemyFactory {

    public RandomBossFactory(){
        initializeAllEnemiesAvailable();
    }

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
