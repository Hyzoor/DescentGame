package game.enemyfactory;

import java.util.Random;

import game.characters.Enemy;


public class RandomEnemyFactory implements EnemyFactory{

    private final String[] enemies;

    public RandomEnemyFactory(){
        enemies = new String[]{"Beast", "Demon", "Goblin", "Ghost"};
    }

    @Override
    public Enemy create(){
        Random random = new Random();
        int i = random.nextInt(enemies.length);

        return new Enemy(enemies[i]);
    }
}
