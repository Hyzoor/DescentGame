package game.enemyfactory;

import java.util.Random;

import game.characters.Enemy;

public class RandomDifficultEnemyFactory implements EnemyFactory{

    private final String[] enemies;

    public RandomDifficultEnemyFactory(){
        enemies = new String[]{"Beast", "Demon", "Goblin", "Ghost"};
    }

    @Override
    public Enemy createEnemy() {
        Random random = new Random();
        int i = random.nextInt(enemies.length);

        Enemy difficultEnemy = new Enemy(enemies[i]);
        increaseEnemyStats(difficultEnemy);


        return difficultEnemy;
    }

    private void increaseEnemyStats(Enemy enemy){
        for(String stat : enemy.getStats().keySet()){
            int actualValue = enemy.getStatValue(stat);
            enemy.setStatValue(stat, (int) (actualValue * 1.75));
        }
    }

}
