package game.enemyfactory;

import java.util.ArrayList;
import java.util.Random;

import game.characters.Enemy;


public class RandomEnemyFactory implements EnemyFactory{

    private final ArrayList<String> enemyList = new ArrayList<>();

    public RandomEnemyFactory(){
        enemyList.add("Goblin");
        enemyList.add("Beast");
        enemyList.add("Demon");
        enemyList.add("Ghost");
    }

    @Override
    public Enemy createEnemy(){
        Random random = new Random();
        int i = random.nextInt(enemyList.size());

        return new Enemy(enemyList.get(i));
    }
}
